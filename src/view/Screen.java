package view;


import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.*;

import model.Database.DataModel;
import utils.Constants;
import view.MenuBarComponent.MenuBar;
import view.ScreenComponent.Body;
import view.StatusBarComponent.StatusBar;
import view.TabComponent.Tab;
import view.ToolbarComponent.Toolbar;

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
        Body body = new Body();

        setJMenuBar(menu);

        setLayout(new BorderLayout());
        add(toolbar, BorderLayout.PAGE_START);
        add(body, BorderLayout.CENTER);
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
                    DataModel.getInstance().setTableObserver(studentTab.getProfessorTable());
                    statusBar.setTabName("Profesor");
                } else {
                    studentTab.setAddingController(new AddSubjectController());
                    studentTab.setDeleteController(new DeleteSubjectController());
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
    public Tab getStudentTab() { return studentTab; }
    public static Screen getInstance() {
        if(instance == null) {
            instance = new Screen();
        }
        return instance;
    }



}
