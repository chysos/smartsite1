package com.xingyun.smartsite.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

/**
 * 验证码工具类
 */
public class CaptchaUtil {

	// 随机产生的字符串（纯数字）
	private static final String RANDOM_NUMBER = "0123456789";

	public static final String KEY_CAPTCHA = "SE_KEY_MM_CODE";

	private static final String FONT_NAME = "Fixedsys";
	private static final int FONT_SIZE = 30;

	private Random random = new Random();

	private static final int WIDTH = 80;// 图片宽
	private static final int HEIGHT = 40;// 图片高
	private int lineNum = 0;// 干扰线数量
	private int strNum = 4;// 随机产生字符数量

	public BufferedImage genRandomCodeImage(StringBuffer randomCode) {
		return this.genRandomCodeImage(randomCode, null, null);
	}

	/**
	 * 生成随机图片
	 */
	public BufferedImage genRandomCodeImage(StringBuffer randomCode, Integer width, Integer height) {
		if (width == null || width <= 0) {
			width = WIDTH;
		}
		if (height == null || height <= 0) {
			height = HEIGHT;
		}
		// BufferedImage类是具有缓冲区的Image类
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		// 获取Graphics对象,便于对图像进行各种绘制操作
		Graphics g = image.getGraphics();
		// 设置背景色
		g.setColor(new Color(228, 249, 240));
		g.fillRect(0, 0, width, height);

		if (lineNum > 0) {
			// 设置干扰线的颜色
			g.setColor(getRandColor(110, 120));

			// 绘制干扰线
			for (int i = 0; i <= lineNum; i++) {
				drowLine(g);
			}
		}
		// 绘制随机字符
		g.setFont(new Font(FONT_NAME, Font.ROMAN_BASELINE, FONT_SIZE));
		for (int i = 1; i <= strNum; i++) {
			randomCode.append(drowString(g, i));
		}
		g.dispose();
		return image;
	}

	/**
	 * 给定范围获得随机颜色
	 */
	private Color getRandColor(int fc, int bc) {
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}

	/**
	 * 绘制字符串
	 */
	private String drowString(Graphics g, int i) {
		int r = random.nextInt(101);
		int x = random.nextInt(101);
		int b = random.nextInt(101);
		g.setColor(new Color(r, b, x));
		String rand = String.valueOf(getRandomString(random.nextInt(RANDOM_NUMBER.length())));
		g.translate(random.nextInt(3), random.nextInt(3));
		g.drawString(rand, 13 * i, 30);
		return rand;
	}

	/**
	 * 绘制干扰线
	 */
	private void drowLine(Graphics g) {
		int x = random.nextInt(WIDTH);
		int y = random.nextInt(WIDTH);
		int x0 = random.nextInt(16);
		int y0 = random.nextInt(16);
		g.drawLine(x, y, x + x0, y + y0);
	}

	/**
	 * 获取随机的字符
	 */
	private String getRandomString(int num) {
		return String.valueOf(RANDOM_NUMBER.charAt(num));
	}

	public static void main(String[] args) {
		CaptchaUtil tool = new CaptchaUtil();
		StringBuffer code = new StringBuffer();
		BufferedImage image = tool.genRandomCodeImage(code);
		try {
			// 将内存中的图片通过流动形式输出到客户端
			ImageIO.write(image, "JPEG", new FileOutputStream(new File("random-code.jpg")));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}