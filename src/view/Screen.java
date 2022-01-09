package view;

import java.awt.BorderLayout;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.department.DeleteDepartmentController;
import controller.professor.AddProfessorController;
import controller.student.AddStudentController;
import controller.subject.AddSubjectController;
import controller.professor.DeleteProfessorController;
import controller.student.DeleteStudentController;
import controller.subject.DeleteSubjectController;
import controller.professor.EditingProfessorController;
import controller.student.EditingStudentController;
import controller.subject.EditingSubjectController;
import controller.department.AddDepartmentController;
import controller.department.EditDepartmentController;
import model.database.DataModel;
import utils.Constants;
import view.menubar.MenuBar;
import view.statusbar.StatusBar;
import view.tabs.MainTab;
import view.toolbar.Toolbar;

public class Screen extends JFrame {
    private int selectedTab = 0;
    private MainTab mainTab;
    private static Screen instance;
    private ResourceBundle resourceBundle;
    private Toolbar toolbar;
    private MenuBar menu;
    private StatusBar statusBar;
    private String tabName, activeTab;

    private Screen() {
        super();
        Locale.setDefault(new Locale("sr", "RS"));
        resourceBundle = ResourceBundle.getBundle("view.localization.language", Locale.getDefault());

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

        mainTab = new MainTab(new AddStudentController(), new EditingStudentController(), new DeleteStudentController());

        mainTab.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                // TODO Auto-generated method stub
                selectedTab = mainTab.getSelectedIndex();
                if (mainTab.getSelectedIndex() == 0) {
                    activeTab = "Studenti";
                    mainTab.setAddingController(new AddStudentController());
                    mainTab.setDeleteController(new DeleteStudentController());
                    mainTab.setEditingController(new EditingStudentController());
                    DataModel.getInstance().setTableObserver(mainTab.getStudentTable());
                    tabName = getTabName("Studenti");
                    statusBar.setTabName(tabName);
                } else if (mainTab.getSelectedIndex() == 1) {
                    activeTab = "Profesori";
                    mainTab.setAddingController(new AddProfessorController());
                    mainTab.setDeleteController(new DeleteProfessorController());
                    mainTab.setEditingController(new EditingProfessorController());
                    DataModel.getInstance().setTableObserver(mainTab.getProfessorTable());
                    tabName = getTabName("Profesori");
                    statusBar.setTabName(tabName);
                } else if(mainTab.getSelectedIndex() == 2) {
                    activeTab = "Predmeti";
                    mainTab.setAddingController(new AddSubjectController());
                    mainTab.setDeleteController(new DeleteSubjectController());
                    mainTab.setEditingController(new EditingSubjectController());
                    DataModel.getInstance().setTableObserver(mainTab.getSubjectTable());
                    tabName = getTabName("Predmeti");
                    statusBar.setTabName(tabName);
                } else {
                    activeTab="Department";
                    mainTab.setAddingController(new AddDepartmentController());
                    mainTab.setDeleteController(new DeleteDepartmentController());
                    mainTab.setEditingController(new EditDepartmentController());
                    DataModel.getInstance().setTableObserver(mainTab.getDepartmentTable());
                    tabName = getTabName("Katedre");
                    statusBar.setTabName("Katedre");
                }
            }
        });
        add(mainTab);

        // Screen title and close operation
        setTitle("Studentska Sluzba");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }

    public void changeLanguage() {
        resourceBundle = ResourceBundle.getBundle("view.localization.language", Locale.getDefault());
        //statusBar.setTabName(getTabName(activeTab));
        setTitle(resourceBundle.getString("naslovAplikacije"));
        menu.changeLanguage();
        toolbar.changeLanguage();
        statusBar.changeLanguage(getTabName(activeTab));
        mainTab.changeLanguage();

        UIManager.put("OptionPane.yesButtonText", resourceBundle.getObject("yesOption"));
        UIManager.put("OptionPane.noButtonText", resourceBundle.getObject("noOption"));
        UIManager.put("OptionPane.okButtonText", resourceBundle.getObject("okOption"));
        UIManager.put("OptionPane.cancelButtonText", resourceBundle.getObject("cancelOption"));
    }

    public String getTabName(String name) {
        if (name.equals("Studenti")) {
            if (Locale.getDefault().getCountry() == "US")
                return "Students";
            else
                return "Studenti";

        } else if (name.equals("Profesori")) {
            if (Locale.getDefault().getCountry() == "US")
                return "Professors";
            else
                return "Profesori";

        } else if (name.equals("Predmeti")) {
            if (Locale.getDefault().getCountry() == "US")
                return "Subjects";
            else
                return "Predmeti";
        }
        return "";
    }

    public int getSelectedTab() {
        return selectedTab;
    }

    public MainTab getMainTab() {
        return mainTab;
    }

    public static Screen getInstance() {
        if (instance == null) {
            instance = new Screen();
        }
        return instance;
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

}
