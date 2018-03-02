package com.newbie.entity;

import java.awt.Graphics;
import java.awt.Image;

import com.newbie.util.ImageUtils;

/**
 * 星球entity
 * @author newbie
 *
 */
public class Planet extends Star {
	
	private Star star; // 参照星
	private double longAxis; // 轨迹长轴
	private double shortAxis; // 轨迹短轴
	private double angle = 0; // 角度
	private double speed; // 速度
	
	public Planet(double x, double y, Image image) {
		this.x = x;
		this.y = y;
		this.image = image;
		this.locationX = x - image.getWidth(null) / 2;
		this.locationY = y - image.getHeight(null) / 2;
	}
	
	public Planet(double x, double y, String imagePath) {
		this(x, y, ImageUtils.getImage(imagePath));
	}
	
	public Planet(Star star, double longAxis, double shortAxis, double speed, Image image, boolean isMoving, boolean useLine) {
		this.star = star;
		this.longAxis = longAxis;
		this.shortAxis = shortAxis;
		this.speed = speed;
		this.image = image;
		this.x = star.getX() + longAxis;
		this.y = star.getY();
		this.locationX = x - image.getWidth(null) / 2;
		this.locationY = y - image.getHeight(null) / 2;
		this.isMoving = isMoving;
		this.useLine = useLine;
	}
	
	public Planet(Star star, double longAxis, double shortAxis, double speed, String imagePath, boolean isMoving, boolean useLine) {
		this(star, longAxis, shortAxis, speed, ImageUtils.getImage(imagePath), isMoving, useLine);
	}
	
	/**
	 * 动
	 * @param g
	 */
	public void move() {
		x = star.getX() + longAxis * Math.cos(angle);
		y = star.getY() + shortAxis * Math.sin(angle);
		locationX = x - image.getWidth(null) / 2;
		locationY = y - image.getHeight(null) / 2;
		angle += speed;
	}
	
	/**
	 * 画轨迹线
	 * @param g
	 */
	public void drawLine(Graphics g) {
		g.drawOval((int)(star.getX() - longAxis), (int)(star.getY() - shortAxis), (int)(longAxis * 2), (int)(shortAxis * 2));
	}
}
