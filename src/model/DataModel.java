package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import utils.Constants.Status;
import utils.EnumConversion;;

public class DataModel {

	private ArrayList<Student> students;
	private ArrayList<Profesor> professors;

	public DataModel() {
		try {
			students = readStudentsFromFile();
			professors = readProfessorsFromFile();
		} catch (Exception err) {
			err.printStackTrace();
		}

	}

	private ArrayList<Student> readStudentsFromFile() throws FileNotFoundException {
		ArrayList<Student> students = new ArrayList<Student>();
		File studentFile = new File("src/resources/studenti.txt");
		Scanner scanner = new Scanner(studentFile);

		while (scanner.hasNextLine()) {
			String studentData = scanner.nextLine();
			String[] data = studentData.split(",");
			LocalDate date = LocalDate.parse(data[2]);
			Status paymentType = EnumConversion.stringToStatus(data[9]);

			Student student = new Student(data[0], data[1], date, data[3], data[4], data[5], data[6],
					Integer.parseInt(data[7]), Integer.parseInt(data[8]), paymentType, Double.parseDouble(data[10]));

			students.add(student);
		}
		return students;

	}

	private ArrayList<Profesor> readProfessorsFromFile() throws FileNotFoundException {
		ArrayList<Profesor> professors = new ArrayList<Profesor>();
		File professorFile = new File("src/resources/profesori.txt");
		Scanner scanner = new Scanner(professorFile);

		while (scanner.hasNextLine()) {
			String professorData = scanner.nextLine();
			String[] data = professorData.split(",");
			LocalDate date = LocalDate.parse(data[2]);
			
			Profesor professor = new Profesor(data[0], data[1], date, data[3], data[4], data[5], data[6], data[7],
					data[8], Integer.parseInt(data[9]));
			professors.add(professor);
		}
		return professors;
	}

}
