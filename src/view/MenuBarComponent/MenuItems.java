package view.MenuBarComponent;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.event.MenuKeyEvent;
import utils.ImageUtils;

public class MenuItems extends JMenuItem {
	public MenuItems(String naziv, String iconURL, String shortcutText) {
		super(naziv);
		
		if (iconURL != null) {
			ImageIcon image=readImageIcon(iconURL);
			image=ImageUtils.scaleImage(image, 13, 13);
			setIcon(image);
			char key = shortcutText.charAt(shortcutText.length() - 1);
			setAccelerator(KeyStroke.getKeyStroke(key, MenuKeyEvent.CTRL_DOWN_MASK));
		}
	}
	
	public static ImageIcon readImageIcon(String path) {

	    try {
	        BufferedImage ic = ImageIO.read( ClassLoader.getSystemResource(path));
	        ImageIcon ic2 = new ImageIcon(ic);
	        return ic2;
	    } catch (Exception e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    return null;
	}
}