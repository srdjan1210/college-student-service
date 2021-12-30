package model.Database.EntityLogic;

import model.Database.DataModel;
import model.Mark;
import model.Student;
import model.Subject;

import java.util.ArrayList;
import java.util.Iterator;

public class StudentLogic {
    private DataModel dataModel;

    public StudentLogic(DataModel dm) {
        dataModel = dm;
    }

    public void addStudentToList(Student newStudent) {
        dataModel.getStudents().add(newStudent);
        dataModel.notifyTable();
    }

    public Student getStudentById(String id) {
        ArrayList<Student> students = dataModel.getStudents();
        for (Student stud : students) {
            if (stud.getIndexNumber().equals(id)) {
                return stud;
            }
        }
        return null;
    }

    public void setEditedStudent(String oldIndex, Student studentNewInfo) {
        ArrayList<Student> students = dataModel.getStudents();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getIndexNumber().equals(oldIndex)) {
                students.get(i).setFirstName(studentNewInfo.getFirstName());
                students.get(i).setLastName(studentNewInfo.getLastName());
                students.get(i).setBirthDay(studentNewInfo.getBirthDay());
                students.get(i).setAddress(studentNewInfo.getAddress());
                students.get(i).setPhoneNumber(studentNewInfo.getPhoneNumber());
                students.get(i).setEmailAddress(studentNewInfo.getEmailAddress());
                students.get(i).setIndexNumber(studentNewInfo.getIndexNumber());
                students.get(i).setEntryYear(studentNewInfo.getEntryYear());
                students.get(i).setStudyYear(studentNewInfo.getStudyYear());
                students.get(i).setStatus(studentNewInfo.getStatus());
                dataModel.notifyTable();
            }
        }
    }

    public boolean removeStudentByIndex(String index) {
        ArrayList<Student> students = dataModel.getStudents();
        for (Student student : students) {
            if (student.getIndexNumber().equals(index)) {
                students.remove(student);
                removeStudentDependencies(index);
                dataModel.notifyTable();
                return true;
            }

        }
        return false;
    }

    private void removeStudentDependencies(String index) {
        removeStudentFromPassed(index);
        removeStudentFromNotPassed(index);
        removeStudentFromMarks(index);
    }

    private void removeStudentFromPassed(String index) {
        ArrayList<Subject> subjects = dataModel.getSubjects();
        ArrayList<Student> students = dataModel.getStudents();
        for (Subject subject : subjects) {
            ArrayList<Student> passed = subject.getStudentsPassed();
            for (Iterator<Student> studIt = passed.iterator(); studIt.hasNext(); ) {
                Student student = studIt.next();
                if (student.getIndexNumber().equals(index)) {
                    students.remove(student);
                }
            }
        }
    }

    private void removeStudentFromNotPassed(String index) {
        ArrayList<Subject> subjects = dataModel.getSubjects();
        ArrayList<Student> students = dataModel.getStudents();
        for (Subject subject : subjects) {
            ArrayList<Student> failed = subject.getStudentsFailed();
            for (Iterator<Student> studIt = failed.iterator(); studIt.hasNext(); ) {
                Student student = studIt.next();
                if (student.getIndexNumber().equals(index)) {
                    students.remove(student);
                }
            }
        }
    }

    private void removeStudentFromMarks(String index) {
        ArrayList<Mark> marks = dataModel.getMarks();
        for (Iterator<Mark> markIt = marks.iterator(); markIt.hasNext(); ) {
            Mark mark = markIt.next();
            if (mark.getPassedExam().getIndexNumber().equals(index)) {
                markIt.remove();
            }
        }
    }

    public void addFailedSubjectToStudent(String index, Subject subject) {
        ArrayList<Student> students = dataModel.getStudents();
        Student student = getStudentById(index);
        student.addFailedSubject(subject);
        dataModel.getFailedSubjects().add(subject);
        dataModel.notifyEditTable();
    }

    public ArrayList<Subject> getNewSubjectsForStudent(String index) {
        Student student = getStudentById(index);
        ArrayList<Subject> subjects = dataModel.getSubjects();
        ArrayList<Subject> failedSubjects = student.getFailedSubjects();
        ArrayList<Subject> passedSubjects = student.getPassedSubjects();
        ArrayList<Subject> resultList = new ArrayList<>();
        for (Subject subject : subjects) {
            if (!isSubjectFoundInList(subject.getSubjectId(), student.getFailedSubjects()) &&
                    !isSubjectFoundInList(subject.getSubjectId(), student.getPassedSubjects()) &&
                    student.getStudyYear() == subject.getYearOfStudy()) {
                resultList.add(subject);
            }
        }
        return resultList;

    }

    public boolean isSubjectFoundInList(String subjectId, ArrayList<Subject> subjects) {
        for (Subject subject : subjects) {
            if (subject.getSubjectId().equals(subjectId))
                return true;
        }
        return false;
    }

    public boolean removeFailedSubjectFromStudentSubjects(String subjectId, String studentId) {
        for (Iterator<Student> studentIt = dataModel.getStudents().iterator(); studentIt.hasNext(); ) {
            Student student = studentIt.next();
            if (student.getIndexNumber().equals(studentId)) {
                student.removeFailedSubject(subjectId);
                dataModel.notifyEditTable();
                return true;
            }
        }
        return false;
    }

}
