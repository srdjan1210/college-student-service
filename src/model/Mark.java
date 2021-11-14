package model;

import java.time.LocalDate;

import utils.Constants.MarksValue;

public class Mark {
	private Student passedExam;
	private Subject subject;
	private MarksValue mark;
	private LocalDate dateOfExam;
	public Mark(Student passedExam, Subject subject, MarksValue mark, LocalDate dateOfExam) {
		super();
		this.passedExam = passedExam;
		this.subject = subject;
		this.mark = mark;
		this.dateOfExam = dateOfExam;
	}
	public Student getPassedExam() {
		return passedExam;
	}
	public void setPassedExam(Student passedExam) {
		this.passedExam = passedExam;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public MarksValue getMark() {
		return mark;
	}
	public void setMark(MarksValue mark) {
		this.mark = mark;
	}
	public LocalDate getDateOfExam() {
		return dateOfExam;
	}
	public void setDateOfExam(LocalDate dateOfExam) {
		this.dateOfExam = dateOfExam;
	}
	
	
}
