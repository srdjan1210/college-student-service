package controller;

import interfaces.IDeleteController;
import model.DataModel;
import view.Screen;

import javax.swing.*;

public class DeleteStudentController implements IDeleteController {
    @Override
    public void deleteEntity() {
        int resp = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite obrisati studenta?", "Obrisi studenta?", JOptionPane.YES_NO_OPTION);
        if(resp == 1) return;
        String id = Screen.getInstance().getStudentTab().getSelectedStudentIndex();
        boolean success = DataModel.getInstance().removeStudentByIndex(id);
        if(success)
            JOptionPane.showMessageDialog(null, "Student " + id + " uspjesno uklonjen!");
        else
            JOptionPane.showMessageDialog(null, "Student " + id + " nije pronadjen!");
    }
}
