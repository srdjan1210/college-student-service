package controller;

import interfaces.IDeleteController;
import model.Database.DataModel;
import model.Professor;
import view.Screen;

import javax.swing.*;

public class DeleteProfessorController implements IDeleteController {
    @Override
    public void deleteEntity() {
        if (Screen.getInstance().getStudentTab().getProfessorTable().getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Profesor nije selektovan!", "Brisanje profesora", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int resp = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite obrisati profesora?", "Obrisi profesora?", JOptionPane.YES_NO_OPTION);
        if (resp == 1) return;
        String id = Screen.getInstance().getStudentTab().getSelectedProfessorId();
        DataModel dataModel = DataModel.getInstance();
        Professor professor = dataModel.getProfessorById(id);
        boolean success = dataModel.removeProfessorById(id);

        if (success)
            JOptionPane.showMessageDialog(null, "Profesor " + professor.getFirstName() + " " + professor.getLastName() + " uspjesno uklonjen!");
        else
            JOptionPane.showMessageDialog(null, "Profesor " + professor.getFirstName() + " " + professor.getLastName() + " nije pronadjen!");
    }
}
