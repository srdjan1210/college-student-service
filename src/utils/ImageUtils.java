package utils;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImageUtils {

	public static ImageIcon scaleImage(ImageIcon imageIcon, int width, int height) {
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(newimg);
	}

	public static ImageIcon readImageIcon(String path) {

		try {
			BufferedImage ic = ImageIO.read(ClassLoader.getSystemResource(path));
			ImageIcon ic2 = new ImageIcon(ic);
			return ic2;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
