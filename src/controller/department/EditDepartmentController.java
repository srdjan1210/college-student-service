package controller.department;

import controller.EntityValidator;
import exceptions.InvalidFieldException;
import interfaces.IEditingController;
import model.database.DataModel;
import model.Department;
import model.Professor;
import view.entity.abstract_model.list_model.DepartmentListModel;
import view.Screen;
import view.entity.table.Table;
import view.entity.department.DepartmentEditDialog;
import view.entity.EditingScreen;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class EditDepartmentController implements IEditingController {
    @Override
    public void editEntity(EditingScreen dialog) {
        try {
            validate(dialog);
            Department department = createDepartmentObject(dialog);
            Table depTable = Screen.getInstance().getMainTab().getDepartmentTable();
            String depid = (String) depTable.getModel().getValueAt(depTable.getSelectedRow(), 0);
            DataModel.getInstance().editDepartment(department, depid);
            JOptionPane.showMessageDialog(null, Screen.getInstance().getResourceBundle().getString("departmentEditSuccess"));
            AbstractTableModel tm = (AbstractTableModel) depTable.getModel();
            tm.fireTableDataChanged();
            dialog.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void addDepartmentToField(DepartmentEditDialog departmentEdit) {
        if(departmentEdit.getTextField(2).getText().trim().equals(""))
            chooseHead(departmentEdit);
    }

    public void setFieldsValues(EditingScreen depWin) {
        Table depTable = Screen.getInstance().getMainTab().getDepartmentTable();
        Department dep = DataModel.getInstance().getDepartmentById((String) depTable.getValueAt(depTable.getSelectedRow(), 0));
        depWin.getTextField(0).setText(dep.getDepartmentId());
        depWin.getTextField(1).setText(dep.getDepartmentName());
        if (dep.getHeadOfTheDepartment() == null) depWin.getTextField(2).setText("");
        else depWin.getTextField(2).setText(dep.getHeadOfTheDepartment().getIdNumber());
    }

    private Department createDepartmentObject(EditingScreen depWin) {
        String depId = depWin.getTextField(0).getText();
        String depName = depWin.getTextField(1).getText();
        String depProf = depWin.getTextField(2).getText();

        Professor professor = DataModel.getInstance().getProfessorById(depProf);
        return new Department(depId, depName, professor);
    }

    @Override
    public void validate(EditingScreen dialog) throws InvalidFieldException {
        EntityValidator validator = new EntityValidator();
        for (int i = 0; i < dialog.getFieldsReferences().size(); i++) {
            JTextField field = dialog.getTextField(i);
            if (i == 2) continue;
            if (field.getText().trim().equals(""))
                validator.throwInvalidValidation(field, Screen.getInstance().getResourceBundle().getString("emptyField"));
            validator.setEmptyMessage(field);
        }
    }

    public void chooseHead(DepartmentEditDialog departmentEdit) {
        JList lista = new JList(new DepartmentListModel());
        int result = JOptionPane.showConfirmDialog(null, new JScrollPane(lista), "Izaberite profesora!", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == 0) {
            DepartmentListModel model = (DepartmentListModel) lista.getModel();
            if (lista.getSelectedIndex() == -1) return;
            departmentEdit.getTextField(2).setText(model.getObjectAt(lista.getSelectedIndex()).getIdNumber());
            departmentEdit.switchAddDeleteButtons();
        }
    }
}
