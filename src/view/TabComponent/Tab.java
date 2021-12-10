package view.TabComponent;

import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import interfaces.IAddingController;
import interfaces.IEditingController;
import controller.TableViewController;
import model.DataModel;
import model.Professor;
import model.Student;
import model.Subject;
import view.ToolbarComponent.AddingScreen;
import view.ToolbarComponent.EditingScreen;
import view.TablesComponent.Tables;

public class Tab extends JTabbedPane {

	private IAddingController addingController;
	private IEditingController editingController;
	public static int selectedrow = -1;
	private static String selectedStudentIndex = "";
	private static String selectedProfessorId = "";
	private static String selectedSubjectId = "";
	private Tables studentTable;

	public Tab(IAddingController addingController,IEditingController editingController) {
		super();
		this.addingController = addingController;
		this.editingController = editingController;
		String[] studentColumnNames = { "Indeks", "Ime", "Prezime", "Godina studija", "Status", "Prosek" };
		String[] professorColumnNames = { "Ime", "Prezime", "Titula", "E-mail adresa" };
		String[] subjectColumnNames = { "�ifra predmeta", "Naziv predmeta", "Broj ESPB bodova",
				"Godina na kojoj se predmet izvodi", "Semestar u kome se predmet izvodi" };

		DataModel dataModel = DataModel.getInstance();
		ArrayList<Student> students = dataModel.getStudents();
		ArrayList<Professor> professors = dataModel.getProfessors();
		ArrayList<Subject> subjects = dataModel.getSubjects();
		String[][] studentsData = TableViewController.getStudentsData(students);
		String[][] professorsData = TableViewController.getProfessorsData(professors);
		String[][] subjectsData = TableViewController.geSubjectsData(subjects);
		Vector<Vector<String>> studentData = new Vector<>();
		for (int i = 0; i < studentsData.length; i++) {
			Vector<String> vector = new Vector<>(Arrays.asList(studentsData[i]));
			studentData.add(vector);
		}

		studentTable = new Tables(new Vector<>(Arrays.asList(studentColumnNames)), studentData);
		addingController.addObserver(studentTable);
		editingController.addObserver(studentTable);
		studentTable.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				selectedrow = studentTable.getSelectedRow();
				selectedStudentIndex = studentData.get(selectedrow).get(0);
			}

			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				selectedrow = studentTable.getSelectedRow();
//				selectedStudentIndex = studentsData[selectedrow][0];
				selectedStudentIndex = studentData.get(selectedrow).get(0);
			}

			@Override
			public void mouseReleased(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				selectedrow = studentTable.getSelectedRow();
				selectedStudentIndex = studentData.get(selectedrow).get(0);
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
//		Tables professorTable = new Tables(professorColumnNames, professorsData);
//		Tables subjectTable = new Tables(subjectColumnNames, subjectsData);

		add("Student", new JScrollPane(studentTable));
//		add("Profesor", new JScrollPane(professorTable));
//		add("Predmeti", new JScrollPane(subjectTable));
	}

	public Tables getStudentTable() {
		return studentTable;
	}

	public static String getSelectedStudentIndex() {
		return selectedStudentIndex;
	}

	public static String getSelectedProfessorId() {
		return selectedProfessorId;
	}

	public static String getSelectedSubjectId() {
		return selectedSubjectId;
	}

	public void addNewEntity(AddingScreen dialog) {
		this.addingController.addNewEntity(dialog);
	}
	
	public void editNewEntity(EditingScreen dialog) {
		this.editingController.editEntity(dialog);
	}

	public void setAddingController(IAddingController controller) {
		this.addingController = controller;
	}

	public void setEditingController(IEditingController controller) {
		this.editingController = controller;
	}

}
