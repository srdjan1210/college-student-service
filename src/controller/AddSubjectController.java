package controller;

import Exceptions.InvalidFieldException;
import interfaces.IAddingController;
import model.DataModel;
import model.Professor;
import model.Subject;
import utils.Constants;
import utils.EnumConversion;
import view.ToolbarComponent.AddingScreen;
import view.TablesComponent.Tables;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class AddSubjectController implements IAddingController {
    @Override
    public void addNewEntity(AddingScreen dialog) {
        try {
            checkIfFieldsEmpty(dialog);
            Subject subject = createSubjectObjectFromFields(dialog);
            DataModel.getInstance().addSubjectToList(subject);
            JOptionPane.showMessageDialog((JDialog)dialog, "Predmet uspjesno dodan u listu!");
            dialog.dispose();
        } catch(InvalidFieldException e) {
            JOptionPane.showMessageDialog((JDialog)dialog, e.getMessage(), "Greska", JOptionPane.WARNING_MESSAGE);
        }
    }

    private Subject createSubjectObjectFromFields(AddingScreen subWin) {
        String id = subWin.getTextField(0).getText();
        String name = subWin.getTextField(1).getText();
        Constants.Semester semester = EnumConversion.stringToSemester(subWin.getComboBox(2).getSelectedItem().toString());
        String professorId = subWin.getTextField(3).getText();
        Professor professor = DataModel.getInstance().getProfessorById(professorId);
        int espb = Integer.parseInt(subWin.getTextField(4).getText());
        int studyYear = Integer.parseInt(subWin.getTextField(5).getText());
        return new Subject(id, name, semester, studyYear, professor, espb);
    }

    private void checkIfFieldsEmpty(AddingScreen window) throws InvalidFieldException {
        ArrayList<JComponent> fields = window.getFieldsReferences();
        for (int i = 0; i < fields.size(); i++) {
            if (i == 2) continue;
            JTextField field = (JTextField) fields.get(i);
            if(field.getName().toLowerCase(Locale.ROOT).contains("datum") && !isValidDate(field))
                throw new InvalidFieldException("Format datuma treba da bude yyyy-MM-dd(" + field.getName() +")");
            if (field.getText().trim().equals(""))
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
