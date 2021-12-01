package model;

import utils.DataUtils;
import utils.EnumConversion;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class DataModel {

	private ArrayList<Student> students;
	private ArrayList<Professor> professors;
	private ArrayList<Subject> subjects;
	private ArrayList<Department> departments;
	private ArrayList<Mark> marks;
	private ArrayList<Address> addresses;
	private static DataModel instance = null;

	private DataModel() {
		try {
			students = readEntityFromFile("resources/studenti.txt", "Student");
			professors = readEntityFromFile("resources/profesori.txt", "Professor");
			subjects = readEntityFromFile("resources/predmeti.txt", "Subject");
			departments = readEntityFromFile("resources/katedre.txt", "Department");
			marks = readEntityFromFile("resources/ocene.txt", "Mark");
			addresses = readEntityFromFile("resources/adrese.txt", "Address");
		} catch (Exception err) {
			err.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	private <T> ArrayList<T> readEntityFromFile(String fileName, String className) throws FileNotFoundException {
		ArrayList<T> entityList = new ArrayList<T>();
		Scanner scanner = new Scanner(DataUtils.readDataFile(fileName));

		while (scanner.hasNextLine()) {
			String scannedData = scanner.nextLine();
			String[] data = splitScannedData(scannedData);
			T obj = null;
			if (className.equals("Student"))
				obj = (T) loadStudentObject(data);
			else if (className.equals("Professor"))
				obj = (T) loadProfessorObject(data);
			else if (className.equals("Subject"))
				obj = (T) loadSubjectObject(data);
			else if (className.equals("Department"))
				obj = (T) loadDepartmentObject(data);
			else if (className.equals("Mark"))
				obj = (T) loadMarkObject(data);
			else if (className.equals("Address"))
				obj = (T) loadAddressObject(scannedData.split(":"));
			entityList.add(obj);
		}
		return entityList;
	}

	private Professor loadProfessorObject(String[] data) {
		return new Professor(data[0], data[1], LocalDate.parse(data[2]), convertStringToAddress(data[3]), data[4],
				data[5], loadAddressObject(data[6].split(":")), data[7], data[8], Integer.parseInt(data[9]));
	}

	private Student loadStudentObject(String[] data) {
		return new Student(data[0], data[1], LocalDate.parse(data[2]), convertStringToAddress(data[3]), data[4],
				data[5], data[6], Integer.parseInt(data[7]), Integer.parseInt(data[8]),
				EnumConversion.stringToStatus(data[9]), Double.parseDouble(data[10]));
	}

	private Subject loadSubjectObject(String[] data) {
		return new Subject(data[0], data[1], EnumConversion.stringToSemester(data[2]), Integer.parseInt(data[3]),
				getProfessorById(data[4]), Integer.parseInt(data[4]));
	}

	private Department loadDepartmentObject(String[] data) {
		return new Department(data[0], data[1], getProfessorById(data[2]));
	}

	private Mark loadMarkObject(String[] data) {
		return new Mark(getStudentById(data[0]), getSubjectById(data[1]), EnumConversion.stringToMark(data[2]),
				LocalDate.parse(data[3]));
	}

	private Address loadAddressObject(String[] data) {
		return new Address(data[0], Integer.parseInt(data[3]), data[2], data[1]);
	}

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

	private Subject getSubjectById(String id) {
		for (Subject subj : subjects) {
			if (subj.getSubjectId().equals(id)) {
				return subj;
			}
		}
		return null;
	}

	private String[] splitScannedData(String data) {
		return data.split(",");
	}

	private Address convertStringToAddress(String data) {
		String[] addressChunks = data.split(":");
		return new Address(addressChunks[2], Integer.parseInt(addressChunks[3]), addressChunks[1], addressChunks[0]);
	}

	public static DataModel getInstance() {
		if (instance == null) {
			instance = new DataModel();
			return instance;
		}

		return instance;

	}

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

	public void addProfessorToList(Professor newProfessor) {
		professors.add(newProfessor);
	}

	public void addStudentToList(Student newStudent) {
		students.add(newStudent);
	}

	public void addSubjectToList(Subject newSubject) {
		subjects.add(newSubject);
	}
}
