package com.newbie.entity;

import java.awt.Graphics;
import java.awt.Image;

import com.newbie.util.ImageUtils;

/**
 * 中心星entity
 * @author newbie
 *
 */
public abstract class Star {

	protected double x; // 中心x
	protected double y; // 中心y
	protected Image image; // 图片
	protected double locationX; // 位置x
	protected double locationY; // 位置y
	protected boolean isMoving; // 是否动，true-动，false-不动。
	protected boolean useLine; // 轨迹是否画线，true-画，false-不画。
	
	public Star() {}
	
	public Star(double x, double y, Image image) {
		this.x = x;
		this.y = y;
		this.image = image;
		this.locationX = x - image.getWidth(null) / 2;
		this.locationY = y - image.getHeight(null) / 2;
	}
	
	public Star(double x, double y, String imagePath) {
		this(x, y, ImageUtils.getImage(imagePath));
	}
	
	/**
	 * 显示该星
	 * @param g
	 */
	public void show(Graphics g) {
		g.drawImage(image, (int)locationX, (int)locationY, null);
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getLocationX() {
		return locationX;
	}

	public void setLocationX(double locationX) {
		this.locationX = locationX;
	}

	public double getLocationY() {
		return locationY;
	}

	public void setLocationY(double locationY) {
		this.locationY = locationY;
	}

	public boolean isMoving() {
		return isMoving;
	}

	public void setMoving(boolean isMoving) {
		this.isMoving = isMoving;
	}

	public boolean isUseLine() {
		return useLine;
	}

	public void setUseLine(boolean useLine) {
		this.useLine = useLine;
	}
	
}
