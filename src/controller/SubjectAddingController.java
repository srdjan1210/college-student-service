package controller;

import Exceptions.InvalidFieldException;
import model.DataModel;
import model.Professor;
import model.Subject;
import utils.Constants;
import utils.EnumConversion;
import view.ToolbarComponent.Subject.ToolbarNewSubject;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class SubjectAddingController {

    public static void addSubject(ToolbarNewSubject tns) {
        try {
            checkIfFieldsEmpty(tns);
            Subject subject = createSubjectObjectFromFields(tns);
            DataModel.getInstance().addSubjectToList(subject);
            JOptionPane.showMessageDialog(tns, "Predmet uspjesno dodan u listu!");
            tns.dispose();
        } catch(InvalidFieldException e) {
            JOptionPane.showMessageDialog(tns, e.getMessage(), "Greska", JOptionPane.WARNING_MESSAGE);
        }
    }

    private static Subject createSubjectObjectFromFields(ToolbarNewSubject subWin) {
        String id = subWin.getTextField(0).getText();
        String name = subWin.getTextField(1).getText();
        Constants.Semester semester = EnumConversion.stringToSemester(subWin.getComboBox(2).getSelectedItem().toString());
        String professorId = subWin.getTextField(3).getText();
        Professor professor = DataModel.getInstance().getProfessorById(professorId);
        int espb = Integer.parseInt(subWin.getTextField(4).getText());
        int studyYear = Integer.parseInt(subWin.getTextField(5).getText());
        return new Subject(id, name, semester, studyYear, professor, espb);
    }

    private static void checkIfFieldsEmpty(ToolbarNewSubject window) throws InvalidFieldException {
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


    private static boolean isValidDate(JTextField dateField) {
        try {
            LocalDate.parse(dateField.getText());
        } catch(Exception e) {
            return false;
        }
        return true;
    }
}
