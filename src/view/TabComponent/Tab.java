package view.TabComponent;

import interfaces.IAddingController;
import model.DataModel;
import model.ProfessorTableModel;
import model.StudentTableModel;
import model.SubjectTableModel;
import view.TablesComponent.Tables;
import view.ToolbarComponent.AddingScreen;

import javax.swing.*;
import java.awt.event.MouseListener;

public class Tab extends JTabbedPane {

    private IAddingController addingController;
    public static int selectedrow = -1;
    private static String selectedStudentIndex = "";
    private static String selectedProfessorId = "";
    private static String selectedSubjectId = "";
    private Tables studentTable;
    private Tables professorTable;
    private Tables subjectTable;

    public Tab(IAddingController controller) {
        super();
        this.addingController = controller;
//		StudentTable studentTable = new StudentTable();
//		ProfessorTable professorTable = new ProfessorTable();
//		SubjectTable subjectTable = new SubjectTable();
//
//		DataModel.getInstance().setStudentObserver(studentTable);
//		DataModel.getInstance().setProfessorObserver(professorTable);
//		DataModel.getInstance().setSubjectObserver(subjectTable);

        studentTable = new Tables(new StudentTableModel());
        professorTable = new Tables(new ProfessorTableModel());
        subjectTable = new Tables(new SubjectTableModel());
        DataModel.getInstance().setTableObserver(studentTable);

//		String[] studentColumnNames = { "Indeks", "Ime", "Prezime", "Godina studija", "Status", "Prosek" };
//		String[] professorColumnNames = { "Ime", "Prezime", "Titula", "E-mail adresa" };
//		String[] subjectColumnNames = { "�ifra predmeta", "Naziv predmeta", "Broj ESPB bodova",
//				"Godina na kojoj se predmet izvodi", "Semestar u kome se predmet izvodi" };
//
//		DataModel dataModel = DataModel.getInstance();
//		ArrayList<Student> students = dataModel.getStudents();
//		ArrayList<Professor> professors = dataModel.getProfessors();
//		ArrayList<Subject> subjects = dataModel.getSubjects();
//		String[][] studentsData = TableViewController.getStudentsData(students);
//		String[][] professorsData = TableViewController.getProfessorsData(professors);
//		String[][] subjectsData = TableViewController.geSubjectsData(subjects);
//		Vector<Vector<String>> studentData = new Vector<>();
//		for(int i = 0; i < studentsData.length; i++) {
//			Vector<String> vector = new Vector<>(Arrays.asList(studentsData[i]));
//			studentData.add(vector);
//		}

//		studentTable = new Tables(new Vector<>(Arrays.asList(studentColumnNames)), studentData);
//		controller.addObserver(studentTable);
//		DeleteEntityController.studentTable = studentTable;
        studentTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub
                StudentTableModel model = (StudentTableModel) studentTable.getModel();
                selectedrow = studentTable.getSelectedRow();
                selectedStudentIndex = (String) model.getValueAt(selectedrow, 0);
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub
                StudentTableModel model = (StudentTableModel) studentTable.getModel();
                selectedrow = studentTable.getSelectedRow();
                selectedStudentIndex = (String) model.getValueAt(selectedrow, 0);
////				selectedStudentIndex = studentsData[selectedrow][0];
//				selectedStudentIndex = studentTable.
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
                // TODO Auto-generated method stub
                StudentTableModel model = (StudentTableModel) studentTable.getModel();
                selectedrow = studentTable.getSelectedRow();
                selectedStudentIndex = (String) model.getValueAt(selectedrow, 0);
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
        add("Profesor", new JScrollPane(professorTable));
        add("Predmeti", new JScrollPane(subjectTable));
    }


    public String getSelectedStudentIndex() {
        StudentTableModel model = (StudentTableModel) studentTable.getModel();
        return (String)model.getValueAt(studentTable.getSelectedRow(), 0);
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

    public void setAddingController(IAddingController controller) {
        this.addingController = controller;
    }

    public Tables getStudentTable() {
        return studentTable;
    }

    public Tables getProfessorTable() {
        return professorTable;
    }

    public Tables getSubjectTable() {
        return subjectTable;
    }

}
