package controller;

import Exceptions.InvalidFieldException;
import model.Address;
import model.DataModel;
import model.Student;
import utils.Constants;
import utils.EnumConversion;
import view.TablesComponent.Tables;
import view.ToolbarComponent.Student.ToolbarNewStudent;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class StudentAddingController {
    private static ArrayList<Tables> tables = new ArrayList<Tables>();
    public static void addNewStudent(ToolbarNewStudent tns) {
        try {
            checkIfFieldsEmpty(tns);
            Student student = createStudentObjectFromFields(tns);
            DataModel.getInstance().addStudentToList(student);
            JOptionPane.showMessageDialog(tns, "Student uspjesno dodan u listu!");
            tns.dispose();
            notifyObservers(student);
        } catch(InvalidFieldException e) {
            JOptionPane.showMessageDialog(tns, e.getMessage(), "Greska", JOptionPane.WARNING_MESSAGE);
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
        Constants.Status financing = EnumConversion.stringToStatus(studWin.getComboBox(9).getSelectedItem().toString());
        return new Student(firstName, secondName, birthDate, address, phoneNum, email, indexNum, startingYear, currentYear, financing, 0);
    }

    private static Address createAddressFromAddressString(String addString) {
        String[] addressParts = addString.split(":");
        return new Address(addressParts[0], Integer.parseInt(addressParts[3]), addressParts[1], addressParts[2]);
    }

    private static boolean checkIfFieldsEmpty(ToolbarNewStudent window) throws InvalidFieldException{
        ArrayList<JComponent> fields = window.getFieldsReferences();
        for (int i = 0; i < fields.size() - 2; i++) {
            JTextField field = (JTextField) fields.get(i);
            if(field.getName().toLowerCase(Locale.ROOT).contains("datum") && !isValidDate(field))
                throw new InvalidFieldException("Format datuma treba da bude yyyy-MM-dd(" + field.getName() +")");
            if (field.getText().trim().equals(""))
                throw new InvalidFieldException(field.getName() + " polje je prazno ili nevalidno!");
        }

        return true;
    }

    private static boolean isValidDate(JTextField dateField) throws InvalidFieldException {
        try {
            LocalDate.parse(dateField.getText());
        } catch(Exception e) {
            return false;
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
