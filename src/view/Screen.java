package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import utils.Constants;
import view.MenuBarComponent.MenuBar;
import view.ScreenComponent.Body;
import view.StatusBarComponent.StatusBar;
import view.TabComponent.Tab;
import view.ToolbarComponent.Toolbar;

public class Screen extends JFrame {

	public Screen() {
		super();

		setSize(Constants.SCREEN_WIDTH * 3 / 4, Constants.SCREEN_HEIGHT * 3 / 4);
		setLocation(Constants.SCREEN_WIDTH / 8, Constants.SCREEN_HEIGHT / 8);

		// Screen body
		Toolbar toolbar = new Toolbar();
		MenuBar menu = new MenuBar();
		StatusBar statusBar = new StatusBar(this);
		Body body = new Body();

		setJMenuBar(menu);

		setLayout(new BorderLayout());
		add(toolbar, BorderLayout.PAGE_START);
		add(body, BorderLayout.CENTER);
		add(statusBar, BorderLayout.SOUTH);
		
		// Tables
		Tab studentTab=new Tab();
		add(studentTab);

		// Screen title and close operation
		setTitle("Studentska Služba");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
		
		

	}

}
