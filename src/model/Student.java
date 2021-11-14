package model;

import java.time.LocalDate;
import java.util.ArrayList;

import utils.Constants.Status;

public class Student {
	
	private String lastName;
	private String firstName;
	private LocalDate birthDay;
	private String address;
	private String phoneNumber;
	private String emailAddress;
	private String indexNumber;
	private int entryYear;
	private int studyYear;
	private Status  status;
	private double averageMark;
	private ArrayList<Mark> passedSubjects;
	private ArrayList<Subject> failedSubjects;
	
	public Student(String lastName, String firstName, LocalDate birthDay, String address, String phoneNumber,
			String emailAddress, String indexNumber, int entryYear, int studyYear, Status status, double averageMark) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.birthDay = birthDay;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.indexNumber = indexNumber;
		this.entryYear = entryYear;
		this.studyYear = studyYear;
		this.status = status;
		this.averageMark = averageMark;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getIndexNumber() {
		return indexNumber;
	}

	public void setIndexNumber(String indexNumber) {
		this.indexNumber = indexNumber;
	}

	public int getEntryYear() {
		return entryYear;
	}

	public void setEntryYear(int entryYear) {
		this.entryYear = entryYear;
	}

	public int getStudyYear() {
		return studyYear;
	}

	public void setStudyYear(int studyYear) {
		this.studyYear = studyYear;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public double getAverageMark() {
		return averageMark;
	}

	public void setAverageMark(double averageMark) {
		this.averageMark = averageMark;
	}

	public ArrayList<Mark> getPassedSubjects() {
		return passedSubjects;
	}

	public void setPassedSubjects(ArrayList<Mark> passedSubjects) {
		this.passedSubjects = passedSubjects;
	}

	public ArrayList<Subject> getFailedSubjects() {
		return failedSubjects;
	}

	public void setFailedSubjects(ArrayList<Subject> failedSubjects) {
		this.failedSubjects = failedSubjects;
	}
	
	
	
	
	

	
	
	
}
