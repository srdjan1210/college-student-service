package view.ToolbarComponent;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import utils.Constants;
import view.ListenerHandler;
import view.ToolbarComponent.Student.ToolbarNewStudent;
import view.ToolbarComponent.ToolbarCustomComponents.CustomSeparator;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarIconButton;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarSearch;

public class Toolbar extends JToolBar {

	private ToolbarIconButton btnNew;
	private ToolbarIconButton btnEdit;
	private ToolbarIconButton btnDelete;
	private ToolbarIconButton btnSearch;
	private ToolbarSearch searchField;
	private ToolbarNewStudent newStudentWin;
	
	public Toolbar() {
		super(SwingConstants.HORIZONTAL);

		setPreferredSize(new Dimension(Constants.SCREEN_WIDTH * 3 / 4, 30));
		setFloatable(false);
		
		btnNew = new ToolbarIconButton("Icons/NewMenuItem.png", "Add Entity");
		btnEdit = new ToolbarIconButton("Icons/DeleteMenuItem.png", "Edit Entity");
		btnDelete = new ToolbarIconButton("Icons/EditMenuitem.png", "Delete Entity");
		btnSearch = new ToolbarIconButton("Icons/SearchIconItem.png", "Search");
		searchField = new ToolbarSearch();
		newStudentWin = new ToolbarNewStudent();
		
	
	

		btnNew.addActionListener(ListenerHandler.openWindowListener(newStudentWin));
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
