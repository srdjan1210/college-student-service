package view.JListModels;

import model.Database.DataModel;
import model.Professor;

import javax.swing.*;

public class DepHeadList extends AbstractListModel {
    @Override
    public int getSize() {
        return DataModel.getInstance().filterProfessorForHeadOfDep().size();
    }

    public Professor getObjectAt(int index) {
        return DataModel.getInstance().filterProfessorForHeadOfDep().get(index);
    }

    @Override
    public Object getElementAt(int index) {
        Professor professor = DataModel.getInstance().filterProfessorForHeadOfDep().get(index);
        return professor.getFirstName() + " " + professor.getLastName();
    }


}
