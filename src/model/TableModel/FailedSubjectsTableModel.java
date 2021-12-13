package model.TableModel;

import javax.swing.table.AbstractTableModel;

import utils.Constants;

public class FailedSubjectsTableModel extends AbstractTableModel {

	private String[][] data;
	public FailedSubjectsTableModel(String[][] data){
		this.data = data;
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.length;
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
