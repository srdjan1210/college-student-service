package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import utils.Constants.Status;
import utils.EnumConversion;
import utils.DataUtils;

public class DataModel {

	private ArrayList<Student> students;
	private ArrayList<Professor> professors;
	private ArrayList<Subject> subjects;
	private ArrayList<Department> departments;
	private ArrayList<Mark> marks;
	private ArrayList<Address> addresses;

	public DataModel() {
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
		
		while(scanner.hasNextLine()) {
			String[] data = splitScannedData(scanner.nextLine());
			T obj = null;
			if(className.equals("Student"))
				obj = (T)loadStudentObject(data);
			else if(className.equals("Professor")) 
				obj = (T)loadProfessorObject(data);
			else if(className.equals("Subject"))
				obj = (T)loadSubjectObject(data);
			else if(className.equals("Department"))
				obj = (T)loadDepartmentObject(data);
			else if(className.equals("Mark"))
				obj = (T)loadMarkObject(data);
			else if(className.equals("Address"))
				obj = (T)loadAddressObject(data);
			entityList.add(obj);
		}
		return entityList;
	}
	
	private Professor loadProfessorObject(String[] data) {
		return new Professor(data[0], data[1], LocalDate.parse(data[2]), data[3], data[4], data[5], data[6], data[7],
				data[8], Integer.parseInt(data[9]));
	}
	
	private Student loadStudentObject(String[] data) {
		return new Student(data[0], data[1], LocalDate.parse(data[2]), data[3], data[4], data[5], data[6],
				Integer.parseInt(data[7]), Integer.parseInt(data[8]), EnumConversion.stringToStatus(data[9]), Double.parseDouble(data[10]));
	}
	
	private Subject loadSubjectObject(String[] data) {
		return new Subject(data[0], data[1], EnumConversion.stringToSemester(data[2]),
				getProfessorById(data[3]), Integer.parseInt(data[4]));
	}
	
	private Department loadDepartmentObject(String[] data) {
		return new Department(data[0], data[1], getProfessorById(data[2]));
	}
	
	private Mark loadMarkObject(String[] data) {
		return new Mark(getStudentById(data[0]), getSubjectById(data[1]), EnumConversion.stringToMark(data[2]),
				LocalDate.parse(data[3]));
	}
	
	private Address loadAddressObject(String[] data) {
		return new Address(data[0], Integer.parseInt(data[1]), data[2], data[3]);
	}
	

	private Professor getProfessorById(String id) {
		for (Professor prof : professors) {
			if (prof.getIdNumber().equals(id)) {
				return prof;
			}
		}

		return null;
	}

	private Student getStudentById(String id) {
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
	
}
