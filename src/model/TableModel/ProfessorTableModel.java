package model.TableModel;

import model.Database.DataModel;
import model.Professor;
import utils.Constants;
import view.Screen;
import view.TablesComponent.Tables;

import javax.swing.table.AbstractTableModel;

public class ProfessorTableModel extends AbstractTableModel {
    @Override
    public int getRowCount() {
        return DataModel.getInstance().getProfessors().size();
    }

    @Override
    public int getColumnCount() {
        return Constants.professorColumnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return DataModel.getInstance().getProfessors().get(rowIndex).getDataAt(columnIndex);
    }

    public String getSelectedId() {
        Tables table = Screen.getInstance().getStudentTab().getProfessorTable();
        return DataModel.getInstance().getProfessorIdFromEmail((String)table.getValueAt(table.getSelectedRow(), 3));
    }

    @Override
    public String getColumnName(int column) {
        return Constants.professorColumnNames[column];
    }
}
