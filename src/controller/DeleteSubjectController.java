package controller;

import interfaces.IDeleteController;
import model.Database.DataModel;
import view.Screen;

import javax.swing.*;

public class DeleteSubjectController implements IDeleteController {
    @Override
    public void deleteEntity() {
        int resp = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite obrisati predmet?", "Obrisi predmet?", JOptionPane.YES_NO_OPTION);
        if(resp == 1) return;
        String id = Screen.getInstance().getStudentTab().getSelectedSubjectId();
        boolean success = DataModel.getInstance().removeSubjecById(id);
        if(success)
            JOptionPane.showMessageDialog(null, "Predmet " + id + " uspjesno uklonjen!");
        else
            JOptionPane.showMessageDialog(null, "Predmet " + id + " nije pronadjen!");
    }
}
