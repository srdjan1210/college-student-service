package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Professor {
    private String lastName;
    private String firstName;
    private LocalDate birthDay;
    private Address address;
    private String phoneNumber;
    private String emailAddress;
    private Address officeAddress;
    private String idNumber;
    private String title;
    private int workingYears;
    private ArrayList<Subject> subjects;

    public Professor(String firstName, String lastName, LocalDate birthDay, Address address, String phoneNumber,
                     String emailAddress, Address officeAddress, String idNumber, String title, int workingYears) {
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
        this.subjects = new ArrayList<Subject>();
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
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

    public Address getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(Address officeAddress) {
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

    public void addSubject(Subject subject) {
        this.subjects.add(subject);
    }

    public void removeSubject(String subjectId) {
        for (int i = 0; i < subjects.size(); i++) {
            if (subjects.get(i).getSubjectId().equals(subjectId)) {
                subjects.remove(i);
                return;
            }
        }
    }

    public Object getDataAt(int index) {
        switch (index) {
            case 0:
                return firstName;
            case 1:
                return lastName;
            case 2:
                return title;
            case 3:
                return emailAddress;
            default:
                return "";
        }
    }

    @Override
    public String toString() {
        return firstName + "," + lastName + "," + birthDay + "," + address + ","
                + phoneNumber + "," + emailAddress + "," + officeAddress + "," + idNumber + "," + title + "," + workingYears;
    }
}
