package model;

import utils.Constants;

import javax.swing.table.AbstractTableModel;

public class SubjectTableModel extends AbstractTableModel {
    @Override
    public int getRowCount() {
        return DataModel.getInstance().getSubjects().size();
    }

    @Override
    public int getColumnCount() {
        return Constants.subjectColumnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return DataModel.getInstance().getSubjects().get(rowIndex).getDataAt(columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return Constants.subjectColumnNames[column];
    }
}
