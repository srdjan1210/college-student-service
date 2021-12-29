package view;

import controller.*;
import model.Database.DataModel;
import utils.Constants;
import view.MenuBarComponent.MenuBar;
import view.StatusBarComponent.StatusBar;
import view.TabComponent.Tab;
import view.ToolbarComponent.Toolbar;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Screen extends JFrame {
	private int selectedTab = 0;
	private Tab studentTab;
	private static Screen instance;

	private Screen() {
		super();

		setSize(Constants.SCREEN_WIDTH * 3 / 4, Constants.SCREEN_HEIGHT * 3 / 4);
		setLocation(Constants.SCREEN_WIDTH / 8, Constants.SCREEN_HEIGHT / 8);

		// Screen body
		Toolbar toolbar = new Toolbar();
		MenuBar menu = new MenuBar();
		StatusBar statusBar = new StatusBar(this);

		setJMenuBar(menu);

		setLayout(new BorderLayout());
		add(toolbar, BorderLayout.PAGE_START);
		add(statusBar, BorderLayout.SOUTH);

		// Tables

		studentTab = new Tab(new AddStudentController(), new EditingStudentController(), new DeleteStudentController());

		studentTab.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				selectedTab = studentTab.getSelectedIndex();
				if (studentTab.getSelectedIndex() == 0) {
					studentTab.setAddingController(new AddStudentController());
					studentTab.setDeleteController(new DeleteStudentController());
					studentTab.setEditingController(new EditingStudentController());
					DataModel.getInstance().setTableObserver(studentTab.getStudentTable());
					statusBar.setTabName("Student");
				} else if (studentTab.getSelectedIndex() == 1) {
					studentTab.setAddingController(new AddProfessorController());
					studentTab.setDeleteController(new DeleteProfessorController());
					studentTab.setEditingController(new EditingProfessorController());
					DataModel.getInstance().setTableObserver(studentTab.getProfessorTable());
					statusBar.setTabName("Profesor");
				} else {
					studentTab.setAddingController(new AddSubjectController());
					studentTab.setDeleteController(new DeleteSubjectController());
					studentTab.setEditingController(new EditingSubjectController());
					DataModel.getInstance().setTableObserver(studentTab.getSubjectTable());
					statusBar.setTabName("Predmet");
				}
			}
		});
		add(studentTab);

		// Screen title and close operation
		setTitle("Studentska Slu�ba");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);

	}

	public int getSelectedTab() {
		return selectedTab;
	}

	public Tab getStudentTab() {
		return studentTab;
	}

	public static Screen getInstance() {
		if (instance == null) {
			instance = new Screen();
		}
		return instance;
	}

}
