package view.entity.abstract_model.list_model;

import model.database.DataModel;
import model.Professor;
import view.Screen;

import javax.swing.*;

public class DepartmentListModel extends AbstractListModel {
    @Override
    public int getSize() {
        String depId = Screen.getInstance().getMainTab().getSelectedDepartmentId();
        return DataModel.getInstance().filterProfessorForHeadOfDep(depId).size();
    }

    public Professor getObjectAt(int index) {
        String depId = Screen.getInstance().getMainTab().getSelectedDepartmentId();
        return DataModel.getInstance().filterProfessorForHeadOfDep(depId).get(index);
    }

    @Override
    public Object getElementAt(int index) {
        String depId = Screen.getInstance().getMainTab().getSelectedDepartmentId();
        Professor professor = DataModel.getInstance().filterProfessorForHeadOfDep(depId).get(index);
        return professor.getFirstName() + " " + professor.getLastName();
    }


}
