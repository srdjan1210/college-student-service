package utils;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ImageUtils {
	
	public static ImageIcon scaleImage(ImageIcon imageIcon, int width, int height) {
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(newimg);  
	}

}
