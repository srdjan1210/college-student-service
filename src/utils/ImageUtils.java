package utils;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ImageUtils {
	
	public static ImageIcon scaleImage(ImageIcon imageIcon) {
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(newimg);  
	}

}
