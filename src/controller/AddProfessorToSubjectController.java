package controller;

import model.Professor;
import view.JListModels.ProfessorListModel;
import view.JListModels.SubjectListModel;
import view.ToolbarComponent.Subject.ToolbarEditSubject;

import javax.swing.*;

public class AddProfessorToSubjectController {

    public AddProfessorToSubjectController() {

    }

    public void addNewProfessorToSubject(ToolbarEditSubject editDialog) {
        JList selection = new JList(new ProfessorListModel());
        int result = JOptionPane.showConfirmDialog(null, new JScrollPane(selection),"Izaberite predmet!", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if(result == 0) {
            Professor professor = ((ProfessorListModel)selection.getModel()).getObjectAt(selection.getSelectedIndex());
            ((JTextField) editDialog.getFieldsReferences().get(3)).setText(professor.getIdNumber());
            editDialog.switchAddDeleteButtons();
        }
    }
}
