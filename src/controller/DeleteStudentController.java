package controller;

import interfaces.IDeleteController;
import model.DataModel;

import javax.swing.*;

public class DeleteStudentController implements IDeleteController {
    @Override
    public void deleteEntity(String id) {
        boolean success = DataModel.getInstance().removeStudentByIndex(id);
        if(success)
            JOptionPane.showMessageDialog(null, "Student " + id + " uspjesno uklonjen!");
        else
            JOptionPane.showMessageDialog(null, "Student " + id + " nije pronadjen!");
    }
}
