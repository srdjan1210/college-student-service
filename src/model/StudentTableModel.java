package model;

import utils.Constants;

import javax.swing.table.AbstractTableModel;

public class StudentTableModel extends AbstractTableModel {
    @Override
    public int getRowCount() {
        return DataModel.getInstance().getStudents().size();
    }

    @Override
    public int getColumnCount() {
        return Constants.studentColumnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return DataModel.getInstance().getStudents().get(rowIndex).getDataAt(columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return Constants.studentColumnNames[column];
    }
}
