package model;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import utils.Constants.Status;
import utils.EnumConversion;;

public class DataModel {
	private ArrayList<Student> students;

	public DataModel() {
		students = readStudentsFromFile();
		System.out.println(students.size());
		System.out.println(students.get(1).getDatumRodjenja());
	}

	private ArrayList<Student> readStudentsFromFile() {
		ArrayList<Student> students = new ArrayList<Student>();
		try {
			File studentFile = new File("src/resources/studenti.txt");
			Scanner scanner = new Scanner(studentFile);

			while (scanner.hasNextLine()) {
				String studentData = scanner.nextLine();
				String[] data = studentData.split(",");
				LocalDate date = LocalDate.parse(data[2]);
				Status paymentType = EnumConversion.stringToStatus(data[9]);
				
				Student student = new Student(data[0], data[1], date, data[3], data[4], data[5], data[6],
						Integer.parseInt(data[7]), Integer.parseInt(data[8]), paymentType,
						Double.parseDouble(data[10]));
				
				students.add(student);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return students;

	}

}
