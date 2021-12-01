package view.ToolbarComponent.ToolbarCustomComponents;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;


public class ToolbarAbstractAction extends AbstractAction {

    public ToolbarAbstractAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Something happened");
    }
}
