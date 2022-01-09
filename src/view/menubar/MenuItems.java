package view.menubar;

import utils.ImageUtils;

import javax.swing.*;
import javax.swing.event.MenuKeyEvent;

public class MenuItems extends JMenuItem {
    public MenuItems(String naziv, String iconURL, String shortcutText, char mnemonicShortcut) {
        super(naziv);

        if (iconURL != null) {
            ImageIcon image = ImageUtils.readImageIcon(iconURL);
            image = ImageUtils.scaleImage(image, 13, 13);
            setIcon(image);
            char key = shortcutText.charAt(shortcutText.length() - 1);
            setAccelerator(KeyStroke.getKeyStroke(key, MenuKeyEvent.CTRL_DOWN_MASK));
            setMnemonic(mnemonicShortcut);
        }
    }
}