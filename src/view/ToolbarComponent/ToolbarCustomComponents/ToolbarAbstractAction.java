package view.ToolbarComponent.ToolbarCustomComponents;

import utils.ImageUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;


public class ToolbarAbstractAction extends AbstractAction {

    public ToolbarAbstractAction() {
        putValue(NAME, "This is button name");
        putValue(SMALL_ICON, ImageUtils.scaleImage(ImageUtils.readImageIcon("Icons/NewMenuItem.png"), 20, 20));
        putValue(MNEMONIC_KEY, KeyEvent.VK_T);
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_K, KeyEvent.CTRL_DOWN_MASK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Something happened");
    }
}
