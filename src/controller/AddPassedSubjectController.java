package controller;

import model.Database.DataModel;
import model.Mark;
import model.Student;
import model.Subject;

import java.util.ArrayList;

public class AddPassedSubjectController {

    public void addNewPassedSubject(Subject subId) {

    }

    public double calculateAverageMarkForStudent(String studId) {
        double averageMark = 0;
        DataModel model = DataModel.getInstance();
        Student student = model.getStudentById(studId);
        ArrayList<Subject> subjectsPassed = student.getPassedSubjects();
        ArrayList<Mark> allMarks = model.getMarks();
        for(Mark mark: allMarks) {
            for(Subject subject: subjectsPassed) {
                System.out.println(mark.getSubject().getSubjectId());
                System.out.println(mark.getPassedExam().getIndexNumber());
                if(mark.getSubject().getSubjectId().equals(subject.getSubjectId()) && mark.getPassedExam().getIndexNumber().equals(student.getIndexNumber())) {
                    System.out.println("tu smo");
                    averageMark += mark.getMark().getValue();
                }
            }
        }
        System.out.println(averageMark);
        return averageMark/(double) subjectsPassed.size();
    }
}
