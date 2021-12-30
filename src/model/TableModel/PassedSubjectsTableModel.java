package model.TableModel;

import model.Database.DataModel;
import model.Subject;
import utils.Constants;
import view.Screen;

import javax.swing.table.AbstractTableModel;

public class PassedSubjectsTableModel extends AbstractTableModel {
    @Override
    public int getRowCount() {

        int selectedRow = Screen.getInstance().getStudentTab().getStudentTable().getSelectedRow();
        int length = DataModel.getInstance().getStudents().get(selectedRow).getPassedSubjects().size();
        System.out.println(length);
        return length;
    }

    @Override
    public int getColumnCount() {
        return Constants.subjectColumnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        int selectedRow = Screen.getInstance().getStudentTab().getStudentTable().getSelectedRow();
        Subject subject = DataModel.getInstance().getStudents().get(selectedRow).getPassedSubjects().get(rowIndex);
        return subject.getDataAt(columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return Constants.subjectColumnNames[column];
    }
}
