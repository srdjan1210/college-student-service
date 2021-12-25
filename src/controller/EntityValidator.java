package controller;

import exceptions.InvalidFieldException;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class EntityValidator {

    public EntityValidator() {

    }

    public void throwInvalidValidation(JTextField field, String message) throws InvalidFieldException {
        field.setBorder(BorderFactory.createLineBorder(Color.red, 1));
        setErrorMessage(field, message);
        throw new InvalidFieldException(message);
    }
    private void setErrorMessage(JTextField field, String message) {
        JPanel panel = (JPanel) field.getParent();
        Component[] children = panel.getComponents();
        ((JLabel)children[2]).setText(message);
    }

    public boolean isValidDate(JTextField dateField) {
        try {
            LocalDate.parse(dateField.getText());
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    public boolean isValidAdressNumber(JTextField adressField) {
        String text = adressField.getText();
        String[] txtSpl = text.split(":");
        if (txtSpl.length != 4
                || txtSpl[0].trim().equals("")
                || txtSpl[1].trim().equals("")
                || txtSpl[2].trim().equals("")
                || txtSpl[3].trim().equals("")) {
            return false;
        }
        try {
            Integer.parseInt(txtSpl[3]);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void setEmptyMessage(JTextField field) {
        field.setBorder(BorderFactory.createLineBorder(Color.gray));
        setErrorMessage(field, "");
    }
}
