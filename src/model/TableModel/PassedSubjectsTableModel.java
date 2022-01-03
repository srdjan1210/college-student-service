package model.TableModel;

import model.Database.DataModel;
import model.Mark;
import model.Subject;
import utils.Constants;
import view.Screen;

import javax.swing.table.AbstractTableModel;

public class PassedSubjectsTableModel extends AbstractTableModel {
    @Override
    public int getRowCount() {

        int selectedRow = Screen.getInstance().getStudentTab().getStudentTable().getSelectedRow();
        int length = DataModel.getInstance().getStudents().get(selectedRow).getPassedSubjects().size();
        return length;
    }

    @Override
    public int getColumnCount() {
        return Constants.passedExamsColumnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        int selectedRow = Screen.getInstance().getStudentTab().getStudentTable().getSelectedRow();
        String studIndex = Screen.getInstance().getStudentTab().getSelectedStudentIndex();
        Subject subject = DataModel.getInstance().getStudents().get(selectedRow).getPassedSubjects().get(rowIndex);
        Mark mark = DataModel.getInstance().getMarkByStudentAndSubject(studIndex, subject.getSubjectId());
        return mark.getDataAt(columnIndex);
    }

    public String getSelectedSubjectId(int rowIndex) {
        int selectedRow = Screen.getInstance().getStudentTab().getStudentTable().getSelectedRow();
        Subject subject = DataModel.getInstance().getStudents().get(selectedRow).getPassedSubjects().get(rowIndex);
        return subject.getSubjectId();
    }

    @Override
    public String getColumnName(int column) {
        return Constants.passedExamsColumnNames[column];
    }
}
