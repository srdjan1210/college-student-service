package view.ToolbarComponent;

import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;


import utils.Constants;

import controller.ListenerHandler;

import view.ToolbarComponent.ToolbarCustomComponents.CustomSeparator;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarIconButton;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarSearch;

public class Toolbar extends JToolBar {

	private ToolbarIconButton btnNew;
	private ToolbarIconButton btnEdit;
	private ToolbarIconButton btnDelete;
	private ToolbarIconButton btnSearch;
	private ToolbarSearch searchField;
	

	public Toolbar() {
		super(SwingConstants.HORIZONTAL);

		setPreferredSize(new Dimension(Constants.SCREEN_WIDTH * 3 / 4, 30));
		setFloatable(false);

		btnNew = new ToolbarIconButton("Icons/NewMenuItem.png", "Add Entity");
		btnEdit = new ToolbarIconButton("Icons/EditMenuItem.png", "Edit Entity");
		btnDelete = new ToolbarIconButton("Icons/DeleteMenuitem.png", "Delete Entity");
		btnSearch = new ToolbarIconButton("Icons/SearchIconItem.png", "Search");

		searchField = new ToolbarSearch();
		btnNew.addActionListener(ListenerHandler.openWindowListener(btnNew));
		btnEdit.addActionListener(ListenerHandler.openEditDialogListener(btnEdit));
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

	public ToolbarIconButton getBtnNew() {
		return btnNew;
	}

	public ToolbarIconButton getBtnEdit() {
		return btnEdit;
	}

	public ToolbarIconButton getBtnDelete() {
		return btnDelete;
	}

	public ToolbarIconButton getBtnSearch() {
		return btnSearch;
	}

	public ToolbarSearch getSearchField() {
		return searchField;
	}
	

}
