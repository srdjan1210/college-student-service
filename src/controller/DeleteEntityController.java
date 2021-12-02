package controller;

import model.DataModel;
import model.Student;

import javax.swing.*;

public class DeleteEntityController {


    public static void deleteStudent(String index) {
        boolean success = DataModel.getInstance().removeStudentByIndex(index);
        if(success)
            JOptionPane.showMessageDialog(null, "Uspjesno uklonjen student " + index + "!");
        else
            JOptionPane.showMessageDialog(null, "Student nije pronadjen ili selektovan!");
    }

    public static void deleteProfessor(String id) {
        boolean success = DataModel.getInstance().removeProfessorById(id);
        if(success)
            JOptionPane.showMessageDialog(null, "Uspjesno uklonjen profesor iz liste!");
        else
            JOptionPane.showMessageDialog(null, "Profesor nije pronadjen ili selektovan!");
    }

    public static void deleteSubject(String id) {
        boolean success = DataModel.getInstance().removeSubjecById(id);
        if(success)
            JOptionPane.showMessageDialog(null, "Uspjesno uklonjen predmet iz liste!");
        else
            JOptionPane.showMessageDialog(null, "Predmet nije pronadjen ili selektovan!");
    }
}
