package controller;

import view.ToolbarComponent.Professor.ToolbarNewProfessor;

import javax.swing.*;
import java.util.Vector;

public class ProfessorWindowController {

    public static void addProfessor(ToolbarNewProfessor tnp) {
            if(checkIfFieldsEmpty(tnp)) {

            } else {
                JOptionPane.showMessageDialog(tnp, "Polja ne smiju biti prazna!");
            }
    }

    private static boolean checkIfFieldsEmpty(ToolbarNewProfessor tnp) {
        Vector<JComponent> fields = tnp.getFieldsReferences();
        for(JComponent field: fields) {
            if(((JTextField)field).getText().trim().equals("")) return false;
        }
        return true;
    }
}
