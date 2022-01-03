package model.TableModel;

import model.Database.DataModel;
import model.Student;
import utils.Constants;
import view.Screen;
import view.TablesComponent.Tables;

import javax.swing.table.AbstractTableModel;
import java.util.HashMap;

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

    public String selectedStudentIndex() {
        Tables table = Screen.getInstance().getStudentTab().getStudentTable();
        System.out.println((String) table.getValueAt(table.getSelectedRow(), 0));
        return (String) table.getValueAt(table.getSelectedRow(), 0);
    }

}
