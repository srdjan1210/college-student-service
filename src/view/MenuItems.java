package view;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.event.MenuKeyEvent;

import java.awt.Image;
import java.awt.Toolkit;

public class MenuItems extends JMenuItem {
	public MenuItems(String naziv, String iconURL, String shortcutText) {
		super(naziv);
		if (iconURL != null) {
			Image icon = Toolkit.getDefaultToolkit().getImage(iconURL);
			icon = icon.getScaledInstance(13, 13, icon.SCALE_SMOOTH);
			setIcon(new ImageIcon(icon));

			char key = shortcutText.charAt(shortcutText.length() - 1);
			setAccelerator(KeyStroke.getKeyStroke(key, MenuKeyEvent.CTRL_DOWN_MASK));
		}
	}
}
