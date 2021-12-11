package controller;

import interfaces.IDeleteController;
import model.DataModel;

import javax.swing.*;

public class DeleteProfessorController implements IDeleteController {
    @Override
    public void deleteEntity(String id) {
        boolean success = DataModel.getInstance().removeProfessorById(id);
        if(success)
            JOptionPane.showMessageDialog(null, "Profesor " + id + " uspjesno uklonjen!");
        else
            JOptionPane.showMessageDialog(null, "Profesor " + id + " nije pronadjen!");
    }
}
