package view.ToolbarComponent.ToolbarCustomComponents;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

import utils.Constants;
import utils.ImageUtils;
import view.ToolbarComponent.Toolbar;

public class ToolbarIconButton extends JButton {
	
	public ToolbarIconButton(String path, String tooltip, char shortcut) {
		super();
		ImageIcon icon = ImageUtils.scaleImage(ImageUtils.readImageIcon(path), Constants.ICON_BUTTON_WIDTH, Constants.ICON_BUTTON_HEIGHT);
		this.setIcon(icon);
		setSize(20, 20);
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createEmptyBorder());
		setContentAreaFilled(false);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setToolTipText(tooltip);
		
	}

}
