package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Professor {
	private String lastName;
	private String firstName;
	private LocalDate birthDay;
	private String address;
	private String phoneNumber;
	private String emailAddress;
	private String officeAddress;
	private String idNumber;
	private String title;
	private int workingYears;
	private ArrayList<Subject> subjects;
	
	public Professor(String lastName, String firstName, LocalDate birthDay, String address, String phoneNumber,
			String emailAddress, String officeAddress, String idNumber, String title, int workingYears) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.birthDay = birthDay;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.officeAddress = officeAddress;
		this.idNumber = idNumber;
		this.title = title;
		this.workingYears = workingYears;
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

	public String getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getWorkingYears() {
		return workingYears;
	}

	public void setWorkingYears(int workingYears) {
		this.workingYears = workingYears;
	}

	public ArrayList<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(ArrayList<Subject> subjects) {
		this.subjects = subjects;
	}
	
	
	
	
	
	
}
