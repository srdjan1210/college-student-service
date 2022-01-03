package model.Database;

import model.*;
import model.Database.DTOs.PassedSubject;
import model.Database.EntityLogic.ProfessorLogic;
import model.Database.EntityLogic.StudentLogic;
import model.Database.EntityLogic.SubjectLogic;
import view.TablesComponent.Tables;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class DataModel {
    //Data lists
    private ArrayList<Student> students;
    private ArrayList<Professor> professors;
    private ArrayList<Subject> subjects;
    private ArrayList<Department> departments;
    private ArrayList<Mark> marks;
    private ArrayList<Address> addresses;
    //Observer tables
    private Tables tableObserver;
    private Tables editTableObserver;
    //Instance
    private static DataModel instance = null;
    //Logic classes
    private StudentLogic studLogic;
    private ProfessorLogic profLogic;
    private SubjectLogic subjLogic;

    private DataModel() {
        DataReader reader = new DataReader(this);
        studLogic = new StudentLogic(this);
        profLogic = new ProfessorLogic(this);
        subjLogic = new SubjectLogic(this);
        try {
            students = reader.readEntityFromFile("resources/studenti.txt", "Student");
            professors = reader.readEntityFromFile("resources/profesori.txt", "Professor");
            subjects = reader.readEntityFromFile("resources/predmeti.txt", "Subject");
            departments = reader.readEntityFromFile("resources/katedre.txt", "Department");
            marks = reader.readEntityFromFile("resources/ocene.txt", "Mark");

            reader.readStudentSubjectsFromFile("resources/nepolozeni.txt", "nepolozeni");
            reader.readStudentSubjectsFromFile("resources/polozeni.txt", "polozeni");
            reader.readProfessorSubjectsFromFile("resources/profesor_predmeti.txt");
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    // Writing data to files
    public void writeDataToFiles() {
        DataWriter writer = new DataWriter();
        writer.writeEntitiesToFile("resources/studenti.txt", students);
        writer.writeEntitiesToFile("resources/profesori.txt", professors);
        writer.writeEntitiesToFile("resources/predmeti.txt", subjects);
        writer.writeEntitiesToFile("resources/katedre.txt", departments);
        writer.writeEntitiesToFile("resources/ocene.txt", marks);
        writer.writeEntitiesToFile("resources/profesori.txt", professors);
        writer.writeFailedSubjectsToFile("resources/nepolozeni.txt", students);
        writer.writePassedSubjectsToFile("resources/polozeni.txt", getAllPassedSubjectsList());
    }

    // Entity find by unique id methods
    public Professor getProfessorById(String id) {
        return profLogic.getProfessorById(id);
    }

    public Student getStudentById(String id) {
        return studLogic.getStudentById(id);
    }

    public Subject getSubjectById(String id) {
        return subjLogic.getSubjectById(id);
    }

    public String getProfessorIdFromEmail(String email) {
        return profLogic.getProfessorIdFromEmail(email);
    }

    // Adding entities methods
    public void addProfessorToList(Professor newProfessor) {
        profLogic.addProfessorToList(newProfessor);
    }

    public void addStudentToList(Student newStudent) {
        studLogic.addStudentToList(newStudent);
    }

    public void addSubjectToList(Subject newSubject) {
        subjLogic.addSubjectToList(newSubject);
    }

    // Editing entities methods
    public void setEditedStudent(String oldIndex, Student studentNewInfo) {
        studLogic.setEditedStudent(oldIndex, studentNewInfo);
    }

    public void setEditedProfessor(String oldId, Professor professorNewInfo) {
        profLogic.setEditedProfessor(oldId, professorNewInfo);
    }

    // Deleting entities methods
    public boolean removeStudentByIndex(String index) {
        return studLogic.removeStudentByIndex(index);
    }

    public boolean removeProfessorById(String id) {
        return profLogic.removeProfessorById(id);
    }

    public boolean removeSubjectById(String id) {
        return subjLogic.removeSubjectById(id);
    }


    public ArrayList<Subject> getNewSubjectsForStudent(String index) {
        return studLogic.getNewSubjectsForStudent(index);
    }
    public int getLinesOfFailedToWrite() {
        int lines = 0;
        for (Student student : students) {
            lines += student.getFailedSubjects().size();
        }
        return lines;
    }

    public ArrayList<PassedSubject> getAllPassedSubjectsList() {
        ArrayList<PassedSubject> passedSubs = new ArrayList<>();
        for(Student student: students) {
            for(Subject subject: student.getPassedSubjects()) {
                passedSubs.add(new PassedSubject(student.getIndexNumber(), subject.getSubjectId()));
            }
        }
        return passedSubs;
    }

    public Mark getMarkByStudentAndSubject(String studId, String subId) {
        for(Mark mark: marks) {
            if(mark.getSubject().getSubjectId().equals(subId) && mark.getPassedExam().getIndexNumber().equals(studId)) {
                return mark;
            }
        }

        return null;
    }

    //Failed subjects logic
    public boolean removeFailedSubjectFromStudentSubjects(String subjectId, String studentId) {
        return studLogic.removeFailedSubjectFromStudentSubjects(subjectId, studentId);
    }

    public void addFailedSubjectToStudent(String index, Subject subject) {
        studLogic.addFailedSubjectToStudent(index, subject);
    }

    public void undoMarkFromStudent(String subId, String studId) {
        studLogic.undoMarkFromStudent(subId, studId);
    }
    //Singleton implementation
    public static DataModel getInstance() {
        if (instance == null)
            instance = new DataModel();
        return instance;
    }

    //Observer methods
    public void setTableObserver(Tables table) {
        tableObserver = table;
    }

    public void notifyTable() {
        AbstractTableModel model = (AbstractTableModel) tableObserver.getModel();
        model.fireTableDataChanged();
    }

    public void setEditTableObserver(Tables table) {
        editTableObserver = table;
    }

    public void notifyEditTable() {
        AbstractTableModel model = (AbstractTableModel) editTableObserver.getModel();
        model.fireTableDataChanged();
    }

    //Search related logic
    public Student findStudentThatContains(String word) {
        return studLogic.findStudentThatContains(word);
    }
    // Getters and setters
    public ArrayList<Student> getStudents() {
        return students;
    }
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Professor> getProfessors() {
        return professors;
    }
    public void setProfessors(ArrayList<Professor> professors) {
        this.professors = professors;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }
    public void setSubjects(ArrayList<Subject> subjects) { this.subjects = subjects; }

    public ArrayList<Department> getDepartments() {
        return departments;
    }
    public void setDepartments(ArrayList<Department> departments) {
        this.departments = departments;
    }

    public ArrayList<Mark> getMarks() {
        return marks;
    }
    public void setMarks(ArrayList<Mark> marks) {
        this.marks = marks;
    }

    public ArrayList<Address> getAddresses() {
        return addresses;
    }
    public void setAddresses(ArrayList<Address> addresses) { this.addresses = addresses; }

}
