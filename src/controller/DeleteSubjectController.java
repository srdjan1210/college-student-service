package controller;

import interfaces.IDeleteController;
import model.Database.DataModel;
import view.Screen;

import javax.swing.*;

public class DeleteSubjectController implements IDeleteController {
    @Override
    public void deleteEntity() {
        if(Screen.getInstance().getStudentTab().getSubjectTable().getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Predmet nije selektovan!", "Brisanje predmeta",JOptionPane.WARNING_MESSAGE);
            return;
        }
        int resp = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite obrisati predmet?", "Obrisi predmet?", JOptionPane.YES_NO_OPTION);
        if(resp == 1) return;
        String id = Screen.getInstance().getStudentTab().getSelectedSubjectId();
        boolean success = DataModel.getInstance().removeSubjectById(id);
        if(success)
            JOptionPane.showMessageDialog(null, "Predmet " + id + " uspjesno uklonjen!");
        else
            JOptionPane.showMessageDialog(null, "Predmet " + id + " nije pronadjen!");
    }
}
