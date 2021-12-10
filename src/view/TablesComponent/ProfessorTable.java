package view.TablesComponent;

import model.ProfessorTableModel;

import javax.swing.*;

public class ProfessorTable extends JTable {
    public ProfessorTable() {
        super();
        ProfessorTableModel model = new ProfessorTableModel();
        setModel(model);
    }
}
