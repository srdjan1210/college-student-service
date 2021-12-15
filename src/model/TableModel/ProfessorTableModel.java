package model.TableModel;

import model.Database.DataModel;
import utils.Constants;

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

    @Override
    public String getColumnName(int column) {
        return Constants.professorColumnNames[column];
    }
}
