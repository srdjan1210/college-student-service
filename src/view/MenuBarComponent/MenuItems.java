package view.MenuBarComponent;

import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.event.MenuKeyEvent;

public class MenuItems extends JMenuItem {
	public MenuItems(String naziv, String iconURL, String shortcutText) {
		super(naziv);
		if (iconURL != null) {
			//Image icon = Toolkit.getDefaultToolkit().getImage(iconURL);
			//icon = icon.getScaledInstance(13, 13, icon.SCALE_SMOOTH);
			//setIcon(new ImageIcon(icon));
			ImageIcon imageIcon=new ImageIcon(iconURL);
			Image image=imageIcon.getImage().getScaledInstance(13,13,Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(image));

			char key = shortcutText.charAt(shortcutText.length() - 1);
			setAccelerator(KeyStroke.getKeyStroke(key, MenuKeyEvent.CTRL_DOWN_MASK));
		}
	}
}