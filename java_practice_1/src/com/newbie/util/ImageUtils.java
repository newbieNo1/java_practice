package com.newbie.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * 图片工具类
 * @author newbie
 *
 */
public class ImageUtils {
	
	private ImageUtils() {};
	
	/**
	 * 获取图片
	 * @param path
	 * @return Image对象
	 */
	public static Image getImage(String path) {
		URL url = ImageUtils.class.getClassLoader().getResource(path);
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bufferedImage;
	}
}
