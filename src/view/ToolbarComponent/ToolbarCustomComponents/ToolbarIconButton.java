package view.ToolbarComponent.ToolbarCustomComponents;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import utils.Constants;
import utils.ImageUtils;

public class ToolbarIconButton extends JButton {
	
	public ToolbarIconButton(String path) {
		super();
		ImageIcon icon = ImageUtils.scaleImage(ImageUtils.readImageIcon(path), Constants.ICON_BUTTON_WIDTH, Constants.ICON_BUTTON_HEIGHT);
		this.setIcon(icon);
		setSize(20, 20);
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createEmptyBorder());
		setContentAreaFilled(false);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
	}

}
