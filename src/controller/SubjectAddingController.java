package controller;

import model.DataModel;
import model.Professor;
import model.Subject;
import utils.Constants;
import utils.EnumConversion;
import view.ToolbarComponent.Subject.ToolbarNewSubject;

import javax.swing.*;
import java.util.ArrayList;

public class SubjectAddingController {

    public static void addSubject(ToolbarNewSubject tns) {
        if (checkIfFieldsEmpty(tns)) {
            Subject subject = createSubjectObjectFromFields(tns);
            DataModel.getInstance().addSubjectToList(subject);
            JOptionPane.showMessageDialog(tns, "Predmet uspjesno dodan u listu!");
            tns.dispose();
        } else {
            JOptionPane.showMessageDialog(tns, "Polja ne smiju biti prazna!");
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

    private static boolean checkIfFieldsEmpty(ToolbarNewSubject window) {
        ArrayList<JComponent> fields = window.getFieldsReferences();
        for (int i = 0; i < fields.size(); i++) {
            if (i == 2) continue;
            JTextField field = (JTextField) fields.get(i);
            if (field.getText().trim().equals("")) return false;
        }

        return true;
    }
}
