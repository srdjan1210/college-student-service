package view.TabComponent;

import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import controller.TableViewController;
import model.DataModel;
import model.Professor;
import model.Student;
import model.Subject;
import view.TablesComponent.Tables;

public class Tab extends JTabbedPane{
	public Tab()
	{
		super();
		String[] studentColumnNames = {"Indeks","Ime","Prezime","Godina studija","Status","Prosek"};
		String[] professorColumnNames = {"Ime","Prezime","Titula","E-mail adresa"};
		String[] subjectColumnNames = {"Šifra predmeta","Naziv predmeta","Broj ESPB bodova","Godina na kojoj se predmet izvodi","Semestar u kome se predmet izvodi"};
		
		DataModel dataModel=DataModel.getInstance();
		ArrayList<Student>students=dataModel.getStudents();
		ArrayList<Professor>professors=dataModel.getProfessors();
		ArrayList<Subject>subjects=dataModel.getSubjects();
		String[][] studentsData=TableViewController.getStudentsData(students);
		String[][] professorsData=TableViewController.getProfessorsData(professors);
		String[][] subjectsData=TableViewController.geSubjectsData(subjects);
		
		Tables studentTable=new Tables(studentColumnNames,studentsData);
		Tables professorTable=new Tables(professorColumnNames,professorsData);
		Tables subjectTable=new Tables(subjectColumnNames,subjectsData);
		
		add("Student",new JScrollPane(studentTable));
		add("Profesor",new JScrollPane(professorTable));
		add("Predmeti",new JScrollPane(subjectTable));

	}
}
