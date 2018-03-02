package com.newbie.frame;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.newbie.entity.Planet;
import com.newbie.entity.Star;
import com.newbie.util.ImageUtils;

/**
 * 简单窗口
 * @author newbie
 *
 */
public class SimpleFrame extends Frame {

	private static final long serialVersionUID = 1L;

	private int x = 100; // 坐标x
	private int y = 50; // 坐标y
	private int width = 1500; // 宽度
	private int height = 800; // 高度
	private Star star; // 中心星
	private Planet mercury; // 水星
	private Planet venus; // 金星
	private Planet earth; // 地球
	private Planet mars; // 火星
	private Planet jupiter; // 木星
	private Planet saturn; // 土星
	private Planet uranus; // 天王星
	private Planet neptune; // 海王星
	private Planet moon; // 月亮
	
	/**
	 * 开启窗口
	 */
	public void launchFrame() {
		setLocation(x, y);
		setSize(width, height);
		setVisible(true);
		new PaintThread().start();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(ImageUtils.getImage("images/bg.jpg"), 0, 0, null);
		star.show(g);
		g.setColor(Color.blue);
		mercury.move();
		mercury.drawLine(g);
		mercury.show(g);
		venus.move();
		venus.drawLine(g);
		venus.show(g);
		earth.move();
		earth.drawLine(g);
		earth.show(g);
		mars.move();
		mars.drawLine(g);
		mars.show(g);
		jupiter.move();
		jupiter.drawLine(g);
		jupiter.show(g);
		saturn.move();
		saturn.drawLine(g);
		saturn.show(g);
		neptune.move();
		neptune.drawLine(g);
		neptune.show(g);
		uranus.move();
		uranus.drawLine(g);
		uranus.show(g);
		moon.move();
		moon.drawLine(g);
		moon.show(g);
	}
	
	class PaintThread extends Thread {
		@Override
		public void run() {
			while (true) {
				repaint();
				try {
					Thread.sleep(60);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Star getStar() {
		return star;
	}

	public void setStar(Star star) {
		this.star = star;
	}

	public Planet getMercury() {
		return mercury;
	}

	public void setMercury(Planet mercury) {
		this.mercury = mercury;
	}

	public Planet getVenus() {
		return venus;
	}

	public void setVenus(Planet venus) {
		this.venus = venus;
	}

	public Planet getEarth() {
		return earth;
	}

	public void setEarth(Planet earth) {
		this.earth = earth;
	}

	public Planet getMars() {
		return mars;
	}

	public void setMars(Planet mars) {
		this.mars = mars;
	}

	public Planet getJupiter() {
		return jupiter;
	}

	public void setJupiter(Planet jupiter) {
		this.jupiter = jupiter;
	}

	public Planet getSaturn() {
		return saturn;
	}

	public void setSaturn(Planet saturn) {
		this.saturn = saturn;
	}

	public Planet getUranus() {
		return uranus;
	}

	public void setUranus(Planet uranus) {
		this.uranus = uranus;
	}

	public Planet getNeptune() {
		return neptune;
	}

	public void setNeptune(Planet neptune) {
		this.neptune = neptune;
	}

	public Planet getMoon() {
		return moon;
	}

	public void setMoon(Planet moon) {
		this.moon = moon;
	}
	
	public static void main(String[] args) {
		SimpleFrame simpleFrame = new SimpleFrame();
		Star sun = new Planet(400, 400, "images/sun.jpg");
		simpleFrame.setStar(sun);
		Planet mercury = new Planet(sun, 50, 25, 0.39, ImageUtils.getImage("images/Mercury.jpg"), true, true);
		simpleFrame.setMercury(mercury);
		Planet venus = new Planet(sun, 100, 50, 0.25, ImageUtils.getImage("images/Venus.jpg"), true, true);
		simpleFrame.setVenus(venus);
		Planet earth = new Planet(sun, 150, 75, 0.2, ImageUtils.getImage("images/Earth.jpg"), true, true);
		simpleFrame.setEarth(earth);
		Planet mars = new Planet(sun, 200, 100, 0.17, ImageUtils.getImage("images/Mars.jpg"), true, true);
		simpleFrame.setMars(mars);
		Planet jupiter = new Planet(sun, 250, 125, 0.13, ImageUtils.getImage("images/Jupiter.jpg"), true, true);
		simpleFrame.setJupiter(jupiter);
		Planet saturn = new Planet(sun, 300, 150, 0.087, ImageUtils.getImage("images/Saturn.jpg"), true, true);
		simpleFrame.setSaturn(saturn);
		Planet neptune = new Planet(sun, 350, 175, 0.054, ImageUtils.getImage("images/Neptune.jpg"), true, true);
		simpleFrame.setNeptune(neptune);
		Planet uranus = new Planet(sun, 400, 200, 0.0254, ImageUtils.getImage("images/Uranus.jpg"), true, true);
		simpleFrame.setUranus(uranus);
		Planet moon = new Planet(earth, 30, 20, 8, ImageUtils.getImage("images/moon.jpg"), true, false);
		simpleFrame.setMoon(moon);
		simpleFrame.launchFrame();
	}
	
}
