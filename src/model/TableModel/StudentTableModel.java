package model.TableModel;

import model.Database.DataModel;
import model.Student;
import utils.Constants;
import view.Screen;
import view.TablesComponent.Tables;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;

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
    
    

   @Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
	   switch (columnIndex)
       {
           case 0: return String.class;
           case 1: return String.class;
           case 2: return String.class;
           case 3: return Integer.class;
           case 4: return String.class;
           case 5: return Double.class;
       }
	   return super.getColumnClass(columnIndex);
	}

	public String selectedStudentIndex() {
        Tables table = Screen.getInstance().getStudentTab().getStudentTable();
        if(table.getSelectedRow() == -1) return "";
        return (String) table.getValueAt(table.getSelectedRow(), 0);
    }

}
