package view.ToolbarComponent.ToolbarCustomComponents;

import model.Subject;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.ArrayList;

public class SubjectListModel implements ListModel {
    private ArrayList<Subject> subjects;
    public SubjectListModel(ArrayList<Subject> subjects) {
        this.subjects = subjects;

    }

    public Subject getSelectedSubject(int index) {
        return subjects.get(index);
    }

    @Override
    public int getSize() {
        return subjects.size();
    }

    @Override
    public Object getElementAt(int index) {
        return subjects.get(index).getSubjectName();
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }
}
