package controller;

import model.Database.DataModel;
import view.Screen;
import view.TablesComponent.Tables;
import view.ToolbarComponent.Student.ToolbarEditStudentFailedPanel;

import javax.swing.*;

public class DeleteFailedSubjectController {
    public static Tables failedSubjectsTable;

    public void deleteFailedSubject(ToolbarEditStudentFailedPanel editFailedPanel) {
        int resp = JOptionPane.showConfirmDialog(null, Screen.getInstance().getResourceBundle().getString("areYouSureProfessor"),
                Screen.getInstance().getResourceBundle().getString("deleteFailedSubject"), JOptionPane.YES_NO_OPTION);
        if (resp == 1)
            return;
        String selectedSubjectId = editFailedPanel.getSelectedSubjectId();
        DataModel model = DataModel.getInstance();
        Boolean success = model.removeFailedSubjectFromStudentSubjects(selectedSubjectId,
                Screen.getInstance().getStudentTab().getSelectedStudentIndex());
        if (success) {
            JOptionPane.showMessageDialog(null, Screen.getInstance().getResourceBundle().getString("tabSubject") + " " + selectedSubjectId +
                    Screen.getInstance().getResourceBundle().getString("successDelete"));
        } else
            JOptionPane.showMessageDialog(null, Screen.getInstance().getResourceBundle().getString("tabSubject") + " " + selectedSubjectId +
                    Screen.getInstance().getResourceBundle().getString("successDelete"));
    }
}