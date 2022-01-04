package model.TableModel;

import javax.swing.table.AbstractTableModel;

import model.Database.DataModel;
import utils.Constants;
import view.Screen;
import view.ToolbarComponent.Student.ToolbarEditStudentFailedPanel;

public class FailedSubjectsTableModel extends AbstractTableModel {

	public FailedSubjectsTableModel() {
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return ToolbarEditStudentFailedPanel.getSubjectsData(DataModel.getInstance()
				.getStudentById(Screen.getInstance().getStudentTab().getSelectedStudentIndex()).getFailedSubjects()).length;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return Constants.subjectColumnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return ToolbarEditStudentFailedPanel.getSubjectsData(DataModel.getInstance()
				.getStudentById(Screen.getInstance().getStudentTab().getSelectedStudentIndex()).getFailedSubjects())[rowIndex][columnIndex];
	}

	@Override
	public String getColumnName(int column) {
		//return Constants.subjectColumnNames[column];
		return Constants.getFailedColumnName(column);
	}

}
