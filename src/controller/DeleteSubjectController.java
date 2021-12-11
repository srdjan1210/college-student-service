package controller;

import interfaces.IDeleteController;
import model.DataModel;

import javax.swing.*;

public class DeleteSubjectController implements IDeleteController {
    @Override
    public void deleteEntity(String id) {
        boolean success = DataModel.getInstance().removeSubjecById(id);
        if(success)
            JOptionPane.showMessageDialog(null, "Predmet " + id + " uspjesno uklonjen!");
        else
            JOptionPane.showMessageDialog(null, "Predmet " + id + " nije pronadjen!");
    }
}
