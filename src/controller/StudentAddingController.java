package controller;

import model.Address;
import model.DataModel;
import model.Student;
import utils.Constants;
import utils.EnumConversion;
import view.TablesComponent.Tables;
import view.ToolbarComponent.Student.ToolbarNewStudent;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class StudentAddingController {
    private static ArrayList<Tables> tables = new ArrayList<Tables>();
    public static void addNewStudent(ToolbarNewStudent tns) {
        if (checkIfFieldsEmpty(tns)) {
            Student student = createStudentObjectFromFields(tns);
            DataModel.getInstance().addStudentToList(student);
            JOptionPane.showMessageDialog(tns, "Student uspjesno dodan u listu!");
            tns.dispose();
            notifyObservers(student);
        } else {
            JOptionPane.showMessageDialog(tns, "Polja ne smiju biti prazna!");
        }

    }

    private static Student createStudentObjectFromFields(ToolbarNewStudent studWin) {
        String firstName = studWin.getTextField(0).getText();
        String secondName = studWin.getTextField(1).getText();
        LocalDate birthDate = LocalDate.parse(studWin.getTextField(2).getText());
        Address address = createAddressFromAddressString(studWin.getTextField(3).getText());
        String phoneNum = studWin.getTextField(4).getText();
        String email = studWin.getTextField(5).getText();
        String indexNum = studWin.getTextField(6).getText();
        int startingYear = Integer.parseInt(studWin.getTextField(7).getText());
        int currentYear = Integer.parseInt(studWin.getComboBox(8).getSelectedItem().toString());
        Constants.Status financing = EnumConversion.stringToStatus(studWin.getTextField(0).getText());
        return new Student(firstName, secondName, birthDate, address, phoneNum, email, indexNum, startingYear, currentYear, financing, 0);
    }

    private static Address createAddressFromAddressString(String addString) {
        String[] addressParts = addString.split(":");
        return new Address(addressParts[0], Integer.parseInt(addressParts[3]), addressParts[1], addressParts[2]);
    }

    private static boolean checkIfFieldsEmpty(ToolbarNewStudent window) {
        ArrayList<JComponent> fields = window.getFieldsReferences();
        for (int i = 0; i < fields.size() - 2; i++) {
            JTextField field = (JTextField) fields.get(i);
            if (field.getText().trim().equals("")) return false;
        }

        return true;
    }

    public static void addObserver(Tables table) {
        tables.add(table);
    }

    public static void removeObserver(Tables table) {
        tables.remove(table);
    }

    private static void notifyObservers(Student student) {
        String[] array = {student.getIndexNumber(), student.getFirstName(), student.getLastName(), Integer.toString(student.getStudyYear()), student.getStatus().getValue(), Double.toString(student.getAverageMark())};
        for(Tables table: tables) {
            table.notify(array);
        }
    }
}
