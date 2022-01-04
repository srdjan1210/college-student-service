package controller;

import exceptions.InvalidFieldException;
import model.Database.DataModel;
import model.Department;
import model.Professor;
import view.Screen;
import view.TablesComponent.Tables;
import view.ToolbarComponent.Department.EditSingleDepartmentDialog;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;


public class DepartmentController {

    public void setProfessorAsHead(EditSingleDepartmentDialog depWin, Tables depTable) {
        try {
            validate(depWin);
            Department department = createDepartmentObject(depWin);
            String depid = (String)depTable.getModel().getValueAt(depTable.getSelectedRow(), 0);
            DataModel.getInstance().editDepartment(department, depid);
            JOptionPane.showMessageDialog(null, Screen.getInstance().getResourceBundle().getString("departmentEditSuccess"));
            AbstractTableModel tm = (AbstractTableModel) depTable.getModel();
            tm.fireTableDataChanged();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void setFieldsValues(EditSingleDepartmentDialog depWin, Tables depTable) {
        Department dep = DataModel.getInstance().getDepartmentById((String)depTable.getValueAt(depTable.getSelectedRow(), 0));
        depWin.getTextField(0).setText(dep.getDepartmentId());
        depWin.getTextField(1).setText(dep.getDepartmentName());
        if(dep.getHeadOfTheDepartment() == null) depWin.getTextField(2).setText("");
        else depWin.getTextField(2).setText(dep.getHeadOfTheDepartment().getIdNumber());
    }

    private Department createDepartmentObject(EditSingleDepartmentDialog depWin) {
        String depId = depWin.getTextField(0).getText();
        String depName = depWin.getTextField(1).getText();
        String depProf = depWin.getTextField(2).getText();

        Professor professor = DataModel.getInstance().getProfessorById(depProf);
        return new Department(depId, depName, professor);
    }


    public void validate(EditSingleDepartmentDialog depWin) throws InvalidFieldException {
        EntityValidator validator = new EntityValidator();
        for(int i = 0; i < depWin.getFieldsReferences().size(); i++) {
            JTextField field = depWin.getTextField(i);
            if(i == 2) continue;
            if (field.getText().trim().equals(""))
            	validator.throwInvalidValidation(field, Screen.getInstance().getResourceBundle().getString("emptyField"));
            validator.setEmptyMessage(field);
        }

    }
}
