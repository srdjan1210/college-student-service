package view.JListModels;

import model.Subject;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.AbstractList;
import java.util.ArrayList;

public class SubjectListModel extends AbstractListModel<String> {
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
    public String getElementAt(int index) {
        return subjects.get(index).getSubjectName();
    }

}