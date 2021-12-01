package controller;

import model.Address;
import model.DataModel;
import model.Professor;
import view.ToolbarComponent.Professor.ToolbarNewProfessor;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ProfessorWindowController {

    public static void addProfessor(ToolbarNewProfessor tnp) {
        if (checkIfFieldsEmpty(tnp)) {
            Professor professor = createProfessorObjectFromFields(tnp);
            DataModel.getInstance().addProfessorToList(professor);
            JOptionPane.showMessageDialog(tnp, "Profesor uspjesno dodan u listu!");
            tnp.dispose();
        } else {
            JOptionPane.showMessageDialog(tnp, "Polja ne smiju biti prazna!");
        }
    }

    private static Professor createProfessorObjectFromFields(ToolbarNewProfessor profWin) {
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

    private static Address createAddressFromAddressString(String addString) {
        String[] addressParts = addString.split(":");
        return new Address(addressParts[0], Integer.parseInt(addressParts[3]), addressParts[1], addressParts[2]);
    }

    private static boolean checkIfFieldsEmpty(ToolbarNewProfessor tnp) {
        ArrayList<JComponent> fields = tnp.getFieldsReferences();
        for (JComponent field : fields) {
            if (((JTextField) field).getText().trim().equals("")) return false;
        }
        return true;
    }
}
