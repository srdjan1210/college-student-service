package view.ToolbarComponent.Student;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.AbstractTableModel;

import controller.TableViewController;
import model.DataModel;
import model.FailedSubjectsTableModel;
import model.Student;
import model.Subject;
import utils.Constants;
import view.Screen;
import view.EditStudentCustomComponents.FailedSubjectsButtons;
import view.TablesComponent.Tables;

public class ToolbarEditStudentFailed extends JPanel{
	public ToolbarEditStudentFailed() {
		super();
		setPreferredSize(new Dimension(200, 800));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		FailedSubjectsButtons buttons = new FailedSubjectsButtons();
		add(buttons);
		
		String[] columnNames = Constants.subjectColumnNames;
		Student student = DataModel.getInstance().getStudentById(Screen.getInstance().getStudentTab().getSelectedStudentIndex());
		System.out.println(student.getFailedSubjects());
		ArrayList<Subject>failedSubjects = student.getFailedSubjects();
		String[][] data = TableViewController.geSubjectsData(failedSubjects);
		
		Tables failedSubjectsTable = new Tables(new FailedSubjectsTableModel(data));
		add(new JScrollPane(failedSubjectsTable));
		setVisible(true);
	}
}
