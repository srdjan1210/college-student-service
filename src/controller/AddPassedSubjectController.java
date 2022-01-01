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
        DataModel model = DataModel.getInstance();
        Student student = model.getStudentById(studId);
        ArrayList<Subject> subjectsPassed = student.getPassedSubjects();
        ArrayList<Mark> allMarks = model.getMarks();
        double averageMark = 0;
        for(Mark mark: allMarks) {
            for(Subject subject: subjectsPassed) {
                if(mark.getSubject().getSubjectId().equals(subject.getSubjectId())
                        && mark.getPassedExam().getIndexNumber().equals(student.getIndexNumber())) {
                    averageMark += mark.getMark().getValue();
                }
            }
        }
        return averageMark/(double) subjectsPassed.size();
    }

    public int calculateSumOfESPB(String studId) {
        Student student = DataModel.getInstance().getStudentById(studId);
        int count = 0;
        for(Subject subject: student.getPassedSubjects())
            count += subject.getEspb();
        return count;
    }
}
