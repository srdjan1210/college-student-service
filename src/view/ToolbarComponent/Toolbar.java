package view.ToolbarComponent;

import java.awt.Color;
import java.awt.Cursor;
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
		
		ToolbarIconButton btnNew = new ToolbarIconButton("Icons/NewMenuItem.png");
		ToolbarIconButton btnEdit = new ToolbarIconButton("Icons/DeleteMenuItem.png");
		ToolbarIconButton btnDelete = new ToolbarIconButton("Icons/EditMenuitem.png");
		ToolbarIconButton btnSearch = new ToolbarIconButton("Icons/SearchIconItem.png");
		ToolbarSearch searchField = new ToolbarSearch();

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
		add(searchField);
		add(new CustomSeparator());
		add(btnSearch);
		add(new CustomSeparator());

	}

}
