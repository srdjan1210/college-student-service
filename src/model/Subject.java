package model;

import java.util.ArrayList;

import utils.Constants.Semester;

public class Subject {
	private String subjectId;
	private String subjectName	;
	private Semester semester;
	private Professor professor;
	private int espb;
	private ArrayList<Student> studentsPassed;
	private ArrayList<Student> studentsFailed;
	public Subject(String subjectId, String subjectName, Semester semester, Professor professor, int espb,
			ArrayList<Student> studentsPassed, ArrayList<Student> studentsFailed) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.semester = semester;
		this.professor = professor;
		this.espb = espb;
		this.studentsPassed = studentsPassed;
		this.studentsFailed = studentsFailed;
	}
	public String getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public Semester getSemester() {
		return semester;
	}
	public void setSemester(Semester semester) {
		this.semester = semester;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public int getEspb() {
		return espb;
	}
	public void setEspb(int espb) {
		this.espb = espb;
	}
	public ArrayList<Student> getStudentsPassed() {
		return studentsPassed;
	}
	public void setStudentsPassed(ArrayList<Student> studentsPassed) {
		this.studentsPassed = studentsPassed;
	}
	public ArrayList<Student> getStudentsFailed() {
		return studentsFailed;
	}
	public void setStudentsFailed(ArrayList<Student> studentsFailed) {
		this.studentsFailed = studentsFailed;
	}
	
	
}
