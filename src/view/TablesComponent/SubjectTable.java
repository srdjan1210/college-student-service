package view.TablesComponent;

import model.SubjectTableModel;

import javax.swing.*;

public class SubjectTable extends JTable {

    public SubjectTable() {
        super();
        SubjectTableModel model = new SubjectTableModel();
        setModel(model);
    }
}
