package view.TablesComponent;

import model.StudentTableModel;

import javax.swing.*;

public class StudentTable extends JTable {

    public StudentTable() {
        super();
        StudentTableModel tableModel = new StudentTableModel();
        this.setModel(tableModel);
    }
}
