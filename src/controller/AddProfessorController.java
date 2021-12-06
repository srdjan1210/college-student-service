package controller;

import Exceptions.InvalidFieldException;
import interfaces.IAddingController;
import model.Address;
import model.DataModel;
import model.Professor;
import view.ToolbarComponent.AddingScreen;
import view.TablesComponent.Tables;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class AddProfessorController implements IAddingController {
    @Override
    public void addNewEntity(AddingScreen dialog) {
        try{
            checkIfFieldsEmpty(dialog);
            Professor professor = createProfessorObjectFromFields(dialog);
            DataModel.getInstance().addProfessorToList(professor);
            JOptionPane.showMessageDialog((JDialog)dialog, "Profesor uspjesno dodan u listu!");
            dialog.dispose();
        } catch(InvalidFieldException e) {
            JOptionPane.showMessageDialog((JDialog)dialog, e.getMessage(), "Greska", JOptionPane.WARNING_MESSAGE);
        }
    }

    @Override
    public void addObserver(Tables table) {

    }


    private Professor createProfessorObjectFromFields(AddingScreen profWin) {
        String firstName = profWin.getTextField(0).getText();
        String secondName = profWin.getTextField(1).getText();
        LocalDate birthDate = LocalDate.parse(profWin.getTextField(2).getText());
        Address address = createAddressFromAddressString(profWin.getTextField(3).getText());
        String phone = profWin.getTextField(4).getText();
        String email = profWin.getTextField(5).getText();
        Address office = createAddressFromAddressString(profWin.getTextField(6).getText());
        String id = profWin.getTextField(7).getText();
        String title = profWin.getTextField(8).getText();
        int experience = Integer.parseInt(profWin.getTextField(9).getText());
        return new Professor(firstName, secondName, birthDate, address, phone, email, office, id, title, experience);
    }

    private Address createAddressFromAddressString(String addString) {
        String[] addressParts = addString.split(":");
        return new Address(addressParts[0], Integer.parseInt(addressParts[3]), addressParts[1], addressParts[2]);
    }

    private void checkIfFieldsEmpty(AddingScreen tnp) throws InvalidFieldException {
        ArrayList<JComponent> fields = tnp.getFieldsReferences();
        for (JComponent field : fields) {
            if(field.getName().toLowerCase(Locale.ROOT).contains("datum") && !isValidDate((JTextField)field))
                throw new InvalidFieldException("Format datuma treba da bude yyyy-MM-dd(" + field.getName() +")");
            if (((JTextField) field).getText().trim().equals(""))
                throw new InvalidFieldException(field.getName() + " polje je prazno ili nevalidno!");
        }

    }

    private boolean isValidDate(JTextField dateField) {
        try {
            LocalDate.parse(dateField.getText());
        } catch(Exception e) {
            return false;
        }
        return true;
    }
}
