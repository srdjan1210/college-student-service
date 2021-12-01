package view.ToolbarComponent;

import utils.Constants;
import controller.ListenerHandler;
import view.ToolbarComponent.ToolbarCustomComponents.CustomSeparator;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarAbstractAction;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarIconButton;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarSearch;

import javax.swing.*;
import java.awt.*;

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

		btnNew = new ToolbarIconButton("Icons/NewMenuItem.png", "Add Entity", 'N');
		btnEdit = new ToolbarIconButton("Icons/DeleteMenuItem.png", "Edit Entity", '[');
		btnDelete = new ToolbarIconButton("Icons/EditMenuitem.png", "Delete Entity", ']');
		btnSearch = new ToolbarIconButton("Icons/SearchIconItem.png", "Search", 'Y');
		searchField = new ToolbarSearch();
		btnNew.addActionListener(ListenerHandler.openWindowListener(btnNew));
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
