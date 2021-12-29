package controller;

import model.Database.DataModel;
import model.Subject;
import view.Screen;
import view.ToolbarComponent.ToolbarCustomComponents.SubjectListModel;

import javax.swing.*;
import java.util.ArrayList;

public class AddFailedSubjectController {


    public void addNewFailedSubject() {
        String index = Screen.getInstance().getStudentTab().getSelectedStudentIndex();
        ArrayList<Subject> subjects = DataModel.getInstance().getNewSubjectsForStudent(index);
        if(subjects.size() == 0) {
            JOptionPane.showMessageDialog(null, "Nema predmeta za dodavanje!");
            return;
        }
        JList selektor = new JList(new SubjectListModel(subjects));
        int result = JOptionPane.showConfirmDialog(null, selektor,"Unesite stydenta", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if(result == 0) {
            Subject subject = ((SubjectListModel) selektor.getModel()).getSelectedSubject(selektor.getSelectedIndex());
            DataModel.getInstance().addFailedSubjectToStudent(index, subject);
        }
    }
}
