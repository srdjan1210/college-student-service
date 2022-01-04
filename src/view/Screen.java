package view;

import java.awt.BorderLayout;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.AddProfessorController;
import controller.AddStudentController;
import controller.AddSubjectController;
import controller.DeleteProfessorController;
import controller.DeleteStudentController;
import controller.DeleteSubjectController;
import controller.EditingProfessorController;
import controller.EditingStudentController;
import controller.EditingSubjectController;
import model.Database.DataModel;
import utils.Constants;
import view.MenuBarComponent.MenuBar;
import view.StatusBarComponent.StatusBar;
import view.TabComponent.Tab;
import view.ToolbarComponent.Toolbar;

public class Screen extends JFrame {
	private int selectedTab = 0;
	private Tab studentTab;
	private static Screen instance;
	private ResourceBundle resourceBundle;
	private Toolbar toolbar;
	private MenuBar menu;
	private StatusBar statusBar;
	private String tabName,activeTab;

	private Screen() {
		super();
		Locale.setDefault(new Locale("sr","RS"));
		resourceBundle = ResourceBundle.getBundle("view.MessageResources.language",Locale.getDefault());

		setSize(Constants.SCREEN_WIDTH * 3 / 4, Constants.SCREEN_HEIGHT * 3 / 4);
		setLocation(Constants.SCREEN_WIDTH / 8, Constants.SCREEN_HEIGHT / 8);

		// Screen body
		toolbar = new Toolbar();
		menu = new MenuBar();
		statusBar = new StatusBar(this);

		setJMenuBar(menu);

		setLayout(new BorderLayout());
		add(toolbar, BorderLayout.PAGE_START);
		add(statusBar, BorderLayout.SOUTH);
		activeTab = "Studenti";

		// Tables

		studentTab = new Tab(new AddStudentController(), new EditingStudentController(), new DeleteStudentController());

		studentTab.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				selectedTab = studentTab.getSelectedIndex();
				if (studentTab.getSelectedIndex() == 0) {
					activeTab = "Studenti";
					studentTab.setAddingController(new AddStudentController());
					studentTab.setDeleteController(new DeleteStudentController());
					studentTab.setEditingController(new EditingStudentController());
					DataModel.getInstance().setTableObserver(studentTab.getStudentTable());
					tabName = getTabName("Studenti");
					statusBar.setTabName(tabName);
				} else if (studentTab.getSelectedIndex() == 1) {
					activeTab = "Profesori";
					studentTab.setAddingController(new AddProfessorController());
					studentTab.setDeleteController(new DeleteProfessorController());
					studentTab.setEditingController(new EditingProfessorController());
					DataModel.getInstance().setTableObserver(studentTab.getProfessorTable());
					tabName = getTabName("Profesori");
					statusBar.setTabName(tabName);
				} else {
					activeTab = "Predmeti";
					studentTab.setAddingController(new AddSubjectController());
					studentTab.setDeleteController(new DeleteSubjectController());
					studentTab.setEditingController(new EditingSubjectController());
					DataModel.getInstance().setTableObserver(studentTab.getSubjectTable());
					tabName = getTabName("Predmeti");
					statusBar.setTabName(tabName);
				}
			}
		});
		add(studentTab);

		// Screen title and close operation
		setTitle("Studentska Sluzba");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);

	}
	
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}
	
	public void changeLanguage() {
		resourceBundle = ResourceBundle.getBundle("view.MessageResources.language",Locale.getDefault());
		//statusBar.setTabName(getTabName(activeTab));
		setTitle(resourceBundle.getString("naslovAplikacije"));
		menu.changeLanguage();
		toolbar.changeLanguage();
		statusBar.changeLanguage(getTabName(activeTab));
		studentTab.changeLanguage();
		
		UIManager.put("OptionPane.yesButtonText", resourceBundle.getObject("yesOption"));
		UIManager.put("OptionPane.noButtonText", resourceBundle.getObject("noOption"));
		UIManager.put("OptionPane.okButtonText", resourceBundle.getObject("okOption"));
		UIManager.put("OptionPane.cancelButtonText", resourceBundle.getObject("cancelOption"));
	}
	
	public String getTabName(String name) {
		if(name.equals("Studenti")) {
			if(Locale.getDefault().getCountry() == "US")
				return "Students";
			else
				return "Studenti";
				
		}else if (name.equals("Profesori")) {
			if(Locale.getDefault().getCountry() == "US")
				return "Professors";
			else
				return "Profesori";
			
		}else if (name.equals("Predmeti")) {
			if(Locale.getDefault().getCountry() == "US")
				return "Subjects";
			else
				return "Predmeti";		
		}
		return "";
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
