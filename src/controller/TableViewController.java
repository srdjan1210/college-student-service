package controller;

import java.util.ArrayList;

import model.Professor;
import model.Student;
import model.Subject;

public class TableViewController {
	public TableViewController() {
		
	}
	
	public static String[][] getStudentsData(ArrayList<Student> students){
		String[][] data= new String[students.size()][6];
		int i=0;
		for(Student student : students) {
			data[i][0]=student.getIndexNumber();
			data[i][1]=student.getFirstName();
			data[i][2]=student.getLastName();
			data[i][3]=Integer.toString(student.getStudyYear());
			data[i][4]=student.getStatus().getValue();
			data[i][5]=Double.toString(student.getAverageMark());
			i++;
		}
		return data;
	}
	
	public static String[][] getProfessorsData(ArrayList<Professor> professors){
		String[][] data= new String[professors.size()][4];
		int i=0;
		for (Professor professor : professors) {
			data[i][0]=professor.getFirstName();
			data[i][1]=professor.getLastName();
			data[i][2]=professor.getTitle();
			data[i][3]=professor.getEmailAddress();
			i++;
			}
		return data;
	}
	
	public static String[][] geSubjectsData(ArrayList<Subject> subjects){
		String[][] data= new String[subjects.size()][5];
		int i=0;
		for (Subject subject : subjects) {
			data[i][0]=subject.getSubjectId();
			data[i][1]=subject.getSubjectName();
			data[i][2]=Integer.toString(subject.getEspb());
			data[i][3]=Integer.toString(subject.getYearOfStudy());
			data[i][4]=subject.getSemester().getValue();
			i++;
			}
		return data;
	}
}
