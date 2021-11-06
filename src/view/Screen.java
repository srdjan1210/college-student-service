package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import utils.Constants;
import view.MenuBarComponent.MenuBar;
import view.ScreenComponent.Body;
import view.ScreenComponent.Footer;
import view.ToolbarComponents.Toolbar;

public class Screen extends JFrame {

	public Screen() {
		super();

		setSize(Constants.SCREEN_WIDTH / 2, Constants.SCREEN_HEIGHT / 2);
		setLocation(Constants.SCREEN_WIDTH / 4, Constants.SCREEN_HEIGHT / 4);

		// Screen body
		Toolbar toolbar = new Toolbar();
		MenuBar menu = new MenuBar();
		Footer footer = new Footer();
		Body body = new Body();
		
		setJMenuBar(menu);

		setLayout(new BorderLayout());
		add(toolbar, BorderLayout.PAGE_START);
		add(body, BorderLayout.CENTER);
		add(footer, BorderLayout.SOUTH);

		// Screen title and close operation
		setTitle("Studentska Služba");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);

	}

}
