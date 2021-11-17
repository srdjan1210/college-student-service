package view.TabComponent;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import view.TablesComponent.Tables;

public class Tab extends JTabbedPane{
	public Tab()
	{
		super();
		String[] studentColumnNames = {"Indeks","Ime","Prezime","Godina studija","Status","Prosek"};
		String[] professorColumnNames = {"Ime","Prezime","Titula","Zvanje"};
		String[] subjectColumnNames = {"Šifra predmeta","Naziv predmeta","Broj ESPB bodova","Godina na kojoj se predmet izvodi","Status","Semestar u kome se predmet izvodi"};
		Tables studentTable=new Tables(studentColumnNames);
		Tables professorTable=new Tables(professorColumnNames);
		Tables subjectTable=new Tables(subjectColumnNames);
		add("Student",new JScrollPane(studentTable));
		add("Profesor",new JScrollPane(professorTable));
		add("Predmeti",new JScrollPane(subjectTable));
		
	}
}
