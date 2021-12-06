package view.ToolbarComponent.Student;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.TableViewController;
import model.DataModel;
import model.Student;
import model.Subject;
import view.EditStudentCustomComponents.FailedSubjectsButtons;
import view.TabComponent.Tab;
import view.TablesComponent.Tables;

public class ToolbarEditStudentFailed extends JPanel{
	public ToolbarEditStudentFailed() {
		super();
		setPreferredSize(new Dimension(200, 800));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		FailedSubjectsButtons buttons = new FailedSubjectsButtons();
		add(buttons);
		
		String[] columnNames = {"Sifra predmeta","Naziv predmeta","ESPB","Godina studija","Semestar"};
		Student student = DataModel.getInstance().getStudentById(Tab.getSelectedStudentIndex());
		ArrayList<Subject>failedSubjects = student.getFailedSubjects();
		String[][] data = TableViewController.geSubjectsData(failedSubjects);
		
//		Tables failedSubjectsTable = new Tables(columnNames,data);
//		add(new JScrollPane(failedSubjectsTable));
		setVisible(true);
	}
}
