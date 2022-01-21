package controller.professor;

import model.database.DataModel;
import model.Subject;
import view.entity.abstract_model.list_model.SubjectListModel;
import view.Screen;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddSubjectToProfessorController {

    public void addNewSubject() {
        String id = Screen.getInstance().getMainTab().getSelectedProfessorId();
        ArrayList<Subject> subjects = DataModel.getInstance().getNewSubjectsForProfessor(id);
        if (subjects.size() == 0) {
            JOptionPane.showMessageDialog(null, Screen.getInstance().getResourceBundle().getString("noSubject"));
            return;
        }
        JList selektor = new JList(new SubjectListModel(subjects));
        selektor.setSelectionBackground(new Color(232,57,95));
        selektor.setSelectionForeground(Color.white);
        selektor.setPreferredSize(new Dimension(100, 300));
        int result = JOptionPane.showConfirmDialog(null, new JScrollPane(selektor), Screen.getInstance().getResourceBundle().getString("chooseSubject"), JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == 0) {
            if (selektor.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, Screen.getInstance().getResourceBundle().getString("notSelectedSubject"));
                return;
            }
            Subject subject = ((SubjectListModel) selektor.getModel()).getSelectedSubject(selektor.getSelectedIndex());
            DataModel.getInstance().addSubjectToProfessor(id, subject);

        }
    }

}
