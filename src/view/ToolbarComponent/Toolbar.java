package view.ToolbarComponent;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import utils.Constants;
import utils.ImageUtils;

public class Toolbar extends JToolBar {

	public Toolbar() {
		super(SwingConstants.HORIZONTAL);

		setPreferredSize(new Dimension(Constants.SCREEN_WIDTH * 3 / 4, 30));
		setFloatable(false);

		ImageIcon iconNew = ImageUtils.scaleImage(ImageUtils.readImageIcon("Icons/NewMenuItem.png"), Constants.ICON_BUTTON_WIDTH, Constants.ICON_BUTTON_HEIGHT);
		ImageIcon iconDelete = ImageUtils.scaleImage(ImageUtils.readImageIcon("Icons/DeleteMenuItem.png"), Constants.ICON_BUTTON_WIDTH, Constants.ICON_BUTTON_HEIGHT);
		ImageIcon iconEdit = ImageUtils.scaleImage(ImageUtils.readImageIcon("Icons/EditMenuitem.png"), Constants.ICON_BUTTON_WIDTH, Constants.ICON_BUTTON_HEIGHT);
		ImageIcon iconSearch = ImageUtils.scaleImage(ImageUtils.readImageIcon("Icons/SearchIconItem.png"), Constants.ICON_BUTTON_WIDTH, Constants.ICON_BUTTON_HEIGHT);

		JButton btnNew = new JButton(iconNew);
		JButton btnEdit = new JButton(iconEdit);
		JButton btnDelete = new JButton(iconDelete);
		JButton btnSearch = new JButton(iconSearch);

		setButtonProperties(btnNew);
		setButtonProperties(btnEdit);
		setButtonProperties(btnDelete);
		setButtonProperties(btnSearch);

		// Left side of toolbar
		add(new CustomSeparator());
		add(btnNew);
		add(new CustomSeparator());
		add(btnEdit);
		add(new CustomSeparator());
		add(btnDelete);

		// Middle
		add(Box.createHorizontalGlue());

		// Right side of toolbar
		add(new ToolbarSearch());
		add(new CustomSeparator());
		add(btnSearch);
		add(new CustomSeparator());

	}

	protected void setButtonProperties(JButton button) {
		button.setSize(20, 20);
		button.setBackground(Color.WHITE);
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setContentAreaFilled(false);

	}

}
