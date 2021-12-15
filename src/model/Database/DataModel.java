package model.Database;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.table.AbstractTableModel;

import model.Address;
import model.Department;
import model.Mark;
import model.Professor;
import model.Student;
import model.Subject;
import view.TablesComponent.Tables;

public class DataModel {

	private ArrayList<Student> students;
	private ArrayList<Professor> professors;
	private ArrayList<Subject> subjects;
	private ArrayList<Department> departments;
	private ArrayList<Mark> marks;
	private ArrayList<Address> addresses;
	private ArrayList<Subject> failedSubjects;
	private Tables tableObserver;
	private Tables editTableObserver;
	private static DataModel instance = null;

	private DataModel() {
		DataReader reader = new DataReader(this);
		try {
			students = reader.readEntityFromFile("resources/studenti.txt", "Student");
			professors = reader.readEntityFromFile("resources/profesori.txt", "Professor");
			subjects = reader.readEntityFromFile("resources/predmeti.txt", "Subject");
			departments = reader.readEntityFromFile("resources/katedre.txt", "Department");
			marks = reader.readEntityFromFile("resources/ocene.txt", "Mark");
			failedSubjects = reader.readStudentSubjectsFromFile("resources/nepolozeni.txt");
		} catch (Exception err) {
			err.printStackTrace();
		}
	}

	// Entity find by unique id methods
	public Professor getProfessorById(String id) {
		for (Professor prof : professors) {
			if (prof.getIdNumber().equals(id)) {
				return prof;
			}
		}

		return null;
	}

	public Student getStudentById(String id) {
		for (Student stud : students) {
			if (stud.getIndexNumber().equals(id)) {
				return stud;
			}
		}
		return null;
	}

	public Subject getSubjectById(String id) {
		for (Subject subj : subjects) {
			if (subj.getSubjectId().equals(id)) {
				return subj;
			}
		}
		return null;
	}

	// Getters and setters
	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	public ArrayList<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(ArrayList<Professor> professors) {
		this.professors = professors;
	}

	public ArrayList<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(ArrayList<Subject> subjects) {
		this.subjects = subjects;
	}

	public ArrayList<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(ArrayList<Department> departments) {
		this.departments = departments;
	}

	public ArrayList<Mark> getMarks() {
		return marks;
	}

	public void setMarks(ArrayList<Mark> marks) {
		this.marks = marks;
	}

	public ArrayList<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(ArrayList<Address> addresses) {
		this.addresses = addresses;
	}

	public String getProfessorIdFromEmail(String email) {
		for (Professor professor : professors) {
			if (professor.getEmailAddress().equals(email)) {
				return professor.getIdNumber();
			}
		}
		return null;
	}

	// Adding entities methods
	public void addProfessorToList(Professor newProfessor) {
		professors.add(newProfessor);
		notifyTable();
	}

	public void addStudentToList(Student newStudent) {
		students.add(newStudent);
		notifyTable();
	}

	public void addSubjectToList(Subject newSubject) {
		subjects.add(newSubject);
		notifyTable();
	}

	// Editing entities methods
	public void setEditedStudent(String oldIndex, Student studentNewInfo) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getIndexNumber().equals(oldIndex)) {
				students.get(i).setFirstName(studentNewInfo.getFirstName());
				students.get(i).setLastName(studentNewInfo.getLastName());
				students.get(i).setBirthDay(studentNewInfo.getBirthDay());
				students.get(i).setAddress(studentNewInfo.getAddress());
				students.get(i).setPhoneNumber(studentNewInfo.getPhoneNumber());
				students.get(i).setEmailAddress(studentNewInfo.getEmailAddress());
				students.get(i).setIndexNumber(studentNewInfo.getIndexNumber());
				students.get(i).setEntryYear(studentNewInfo.getEntryYear());
				students.get(i).setStudyYear(studentNewInfo.getStudyYear());
				students.get(i).setStatus(studentNewInfo.getStatus());
				notifyTable();
			}
		}
	}

	public void setEditedProfessor(String oldId, Professor professorNewInfo) {
		for (int i = 0; i < professors.size(); i++) {
			if (professors.get(i).getIdNumber().equals(oldId)) {
				professors.get(i).setFirstName(professorNewInfo.getFirstName());
				professors.get(i).setLastName(professorNewInfo.getLastName());
				professors.get(i).setBirthDay(professorNewInfo.getBirthDay());
				professors.get(i).setAddress(professorNewInfo.getAddress());
				professors.get(i).setPhoneNumber(professorNewInfo.getPhoneNumber());
				professors.get(i).setEmailAddress(professorNewInfo.getEmailAddress());
				professors.get(i).setOfficeAddress(professorNewInfo.getOfficeAddress());
				professors.get(i).setIdNumber(professorNewInfo.getIdNumber());
				professors.get(i).setTitle(professorNewInfo.getTitle());
				professors.get(i).setWorkingYears(professorNewInfo.getWorkingYears());
				notifyTable();
			}
		}
	}

	// Deleting entities methods
	public boolean removeStudentByIndex(String index) {
		for (Student student : students) {
			if (student.getIndexNumber().equals(index)) {
				students.remove(student);
				removeStudentDependencies(index);
				notifyTable();
				return true;
			}

		}
		return false;
	}

	public boolean removeProfessorById(String id) {
		// Treba dodati uklanjanje svih zavisnosti entiteta u drugim listama
		for (Professor professor : professors) {
			if (professor.getIdNumber().equals(id)) {
				professors.remove(professor);
				notifyTable();
				return true;
			}
		}

		return false;
	}

	public boolean removeSubjectById(String id) {
		// Treba dodati uklanjanje svih zavisnosti entiteta u drugim listama
		for (Subject subject : subjects) {
			if (subject.getSubjectId().equals(id)) {
				subjects.remove(subject);
				notifyTable();
				return true;
			}
		}
		return false;
	}

	private void removeStudentDependencies(String index) {
        removeStudentFromPassed(index);
        removeStudentFromNotPassed(index);
		removeStudentFromMarks(index);
	}

	private void removeStudentFromPassed(String index) {
		for (Subject subject : subjects) {
			ArrayList<Student> passed = subject.getStudentsPassed();
			for(Iterator<Student> studIt = passed.iterator(); studIt.hasNext();){
				Student student = studIt.next();
				if (student.getIndexNumber().equals(index)) {
					students.remove(student);
				}
			}
		}
	}

	private void removeStudentFromNotPassed(String index) {
		for (Subject subject : subjects) {
			ArrayList<Student> failed = subject.getStudentsFailed();
			for(Iterator<Student> studIt = failed.iterator(); studIt.hasNext();) {
				Student student = studIt.next();
				if (student.getIndexNumber().equals(index)) {
					students.remove(student);
				}
			}
		}
	}

	private void removeStudentFromMarks(String index) {
		for (Iterator<Mark> markIt = marks.iterator(); markIt.hasNext();) {
			Mark mark = markIt.next();
			if (mark.getPassedExam().getIndexNumber().equals(index)) {
				markIt.remove();
			}
		}
	}

	public boolean removeFailedSubjectFromStudentSubjects(String subjectId, String studentId) {

			for(Iterator<Student> studentIt = students.iterator(); studentIt.hasNext();) {
				Student student = studentIt.next();
				if(student.getIndexNumber().equals(studentId)) {
					student.removeFailedSubject(subjectId);
					notifyEditTable();
					return true;
				}
			}
		return false;
	}



	public int getLinesOfFailedToWrite() {
		int lines = 0;
		for (Student student : students) {
			lines += student.getFailedSubjects().size();
		}
		return lines;
	}

	// Writing to file methods
	public void writeDataToFiles() {
		DataWriter writer = new DataWriter();
		writer.writeEntitiesToFile("resources/studenti.txt", students);
		writer.writeEntitiesToFile("resources/profesori.txt", professors);
		writer.writeEntitiesToFile("resources/predmeti.txt", subjects);
		writer.writeEntitiesToFile("resources/katedre.txt", departments);
		writer.writeEntitiesToFile("resources/ocene.txt", marks);
		writer.writeEntitiesToFile("resources/profesori.txt", professors);
		writer.writeFailedSubjectsToFile("resources/nepolozeni.txt", failedSubjects, students);
	}

	public static DataModel getInstance() {
		if (instance == null)
			instance = new DataModel();
		return instance;
	}

	public void setTableObserver(Tables table) {
		tableObserver = table;
	}

	public void notifyTable() {
		AbstractTableModel model = (AbstractTableModel) tableObserver.getModel();
		model.fireTableDataChanged();
	}
	
	public void setEditTableObserver(Tables table) {
		editTableObserver = table;
	}
	
	public void notifyEditTable() {
		AbstractTableModel model = (AbstractTableModel) editTableObserver.getModel();
		model.fireTableDataChanged();
	}
}
