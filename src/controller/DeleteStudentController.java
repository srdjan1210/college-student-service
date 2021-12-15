package controller;

import interfaces.IDeleteController;
import model.Database.DataModel;
import view.Screen;

import javax.swing.*;

public class DeleteStudentController implements IDeleteController {
    @Override
    public void deleteEntity() {
        if(Screen.getInstance().getStudentTab().getStudentTable().getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Student nije selektovan!", "Brisanje studenta",JOptionPane.WARNING_MESSAGE);
            return;
        }
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
