package view.TabComponent;

import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import org.w3c.dom.events.MouseEvent;

import controller.TableViewController;
import model.DataModel;
import model.Professor;
import model.Student;
import model.Subject;
import view.TablesComponent.Tables;

public class Tab extends JTabbedPane {
	public static int selectedrow = -1;
	public static String selectedStudentIndex = "";

	public Tab() {
		super();
		String[] studentColumnNames = { "Indeks", "Ime", "Prezime", "Godina studija", "Status", "Prosek" };
		String[] professorColumnNames = { "Ime", "Prezime", "Titula", "E-mail adresa" };
		String[] subjectColumnNames = { "Šifra predmeta", "Naziv predmeta", "Broj ESPB bodova",
				"Godina na kojoj se predmet izvodi", "Semestar u kome se predmet izvodi" };

		DataModel dataModel = DataModel.getInstance();
		ArrayList<Student> students = dataModel.getStudents();
		ArrayList<Professor> professors = dataModel.getProfessors();
		ArrayList<Subject> subjects = dataModel.getSubjects();
		String[][] studentsData = TableViewController.getStudentsData(students);
		String[][] professorsData = TableViewController.getProfessorsData(professors);
		String[][] subjectsData = TableViewController.geSubjectsData(subjects);

		Tables studentTable = new Tables(studentColumnNames, studentsData);
		studentTable.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				selectedrow = studentTable.getSelectedRow();
				selectedStudentIndex = studentsData[selectedrow][0];
			}

			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				selectedrow = studentTable.getSelectedRow();
				selectedStudentIndex = studentsData[selectedrow][0];
			}

			@Override
			public void mouseReleased(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				selectedrow = studentTable.getSelectedRow();
				selectedStudentIndex = studentsData[selectedrow][0];
			}

			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		Tables professorTable = new Tables(professorColumnNames, professorsData);
		Tables subjectTable = new Tables(subjectColumnNames, subjectsData);

		add("Student", new JScrollPane(studentTable));
		add("Profesor", new JScrollPane(professorTable));
		add("Predmeti", new JScrollPane(subjectTable));
	}
	

	public static String getSelectedStudentIndex() {
		return selectedStudentIndex;
	}
}
