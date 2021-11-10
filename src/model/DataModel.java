package model;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import utils.Constants.Status;;

public class DataModel {
	
	public static ArrayList<Student> readStudentsFromFile() {
		ArrayList<Student> studenti = new ArrayList<Student>();
		File studentFile = new File("resources/studenti.txt");
		Scanner scanner = new Scanner(studentFile);
		
		
		while(scanner.hasNextLine()) {
			String studentData = scanner.nextLine();
			String[] data = studentData.split(",");
			Status skolovanje;
			
			if(data[7] == "B")
				skolovanje = Status.BUDZET;
			else
				skolovanje = Status.SAMOFINANSIRANJE;
			Student student = new Student(data[0], data[1], new Date(data[2]), data[3], data[4], data[5], Integer.parseInt(data[6]), Integer.parseInt(data[7]) ); 
		}
		
		return studenti;
		
	}
	

}
