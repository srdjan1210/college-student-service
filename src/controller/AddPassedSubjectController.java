package controller;

import model.Database.DataModel;
import model.Mark;
import model.Student;
import model.Subject;
import model.TableModel.PassedSubjectsTableModel;
import view.EditCustomComponents.PassedExamInfoPanel;
import view.EditCustomComponents.PassedSubjectsButtons;
import view.Screen;
import view.TablesComponent.Tables;
import view.ToolbarComponent.Student.ToolbarEditStudentPassedPanel;

import javax.swing.*;
import java.util.ArrayList;

public class AddPassedSubjectController {

    public void addNewPassedSubject(Subject subId) {

    }

    public void setESPBAndAverage(PassedExamInfoPanel infoPanel) {
        JLabel lblAvg = infoPanel.getAverageField();
        JLabel lblEspb = infoPanel.getEspbField();
        String studIndex = Screen.getInstance().getStudentTab().getSelectedStudentIndex();
        double average = calculateAverageMarkForStudent(studIndex);
        int espb = calculateSumOfESPB(studIndex);
        lblAvg.setText(average + "");
        lblEspb.setText(espb + "");
        Student student = DataModel.getInstance().getStudentById(Screen.getInstance().getStudentTab().getSelectedStudentIndex());
        student.setAverageMark(average);
    }

    public void undoMark(PassedSubjectsButtons reference) {
        ToolbarEditStudentPassedPanel studPassedPanel = (ToolbarEditStudentPassedPanel) reference.getParent();
        Tables marksTable = studPassedPanel.getPassedSubjectsTable();
        if (marksTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Predmet nije selektovan!");
            return;
        }
        int result = JOptionPane.showConfirmDialog(null, "Da li zelite ponistiti ocjenu iz obiljezenog predmeta", "Ponistavanje", JOptionPane.YES_NO_OPTION);
        if (result != 0) return;
        PassedSubjectsTableModel pstm = (PassedSubjectsTableModel) marksTable.getModel();
        String subId = pstm.getSelectedSubjectId(marksTable.getSelectedRow());
        String studId = Screen.getInstance().getStudentTab().getSelectedStudentIndex();
        DataModel.getInstance().undoMarkFromStudent(subId, studId);
        ToolbarEditStudentPassedPanel tesp = (ToolbarEditStudentPassedPanel) reference.getParent();
        tesp.setESPBAndAverage();
    }

    public double calculateAverageMarkForStudent(String studId) {
        DataModel model = DataModel.getInstance();
        Student student = model.getStudentById(studId);
        if (student == null) return 0;
        ArrayList<Subject> subjectsPassed = student.getPassedSubjects();
        ArrayList<Mark> allMarks = model.getMarks();
        double averageMark = 0;
        for (Mark mark : allMarks) {
            for (Subject subject : subjectsPassed) {
                if (mark.getSubject().getSubjectId().equals(subject.getSubjectId())
                        && mark.getPassedExam().getIndexNumber().equals(student.getIndexNumber())) {
                    averageMark += mark.getMark().getValue();
                }
            }
        }
        if (subjectsPassed.size() == 0) return 0;
        return averageMark / (double) subjectsPassed.size();
    }

    public int calculateSumOfESPB(String studId) {
        Student student = DataModel.getInstance().getStudentById(studId);
        int count = 0;
        for (Subject subject : student.getPassedSubjects())
            count += subject.getEspb();
        return count;
    }
}
