package model;

import javax.swing.table.AbstractTableModel;

import utils.Constants;

public class FailedSubjectsTableModel extends AbstractTableModel {

	private String[][] data;
	public FailedSubjectsTableModel(){
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return Constants.subjectColumnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return data[rowIndex][columnIndex];
	}
	
    @Override
    public String getColumnName(int column) {
        return Constants.subjectColumnNames[column];
    }

}
