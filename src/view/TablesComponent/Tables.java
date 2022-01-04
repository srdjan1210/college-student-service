package view.TablesComponent;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.RowSorter.SortKey;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;

import model.TableModel.ProfessorTableModel;
import model.TableModel.StudentTableModel;
import model.TableModel.SubjectTableModel;
import view.RowFilters.ProfessorRowFilter;
import view.RowFilters.StudentRowFilter;
import view.RowFilters.SubjectRowFilter;

public class Tables extends JTable {
	public Tables(AbstractTableModel tableModel) {
		super();
		setModel(tableModel);
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setColumnSelectionAllowed(false);
		centerText();
		if(tableModel instanceof StudentTableModel) {
			setAutoCreateRowSorter(true);
			TableRowSorter<StudentTableModel> rowSorter = new TableRowSorter<StudentTableModel>((StudentTableModel) tableModel);
			rowSorter.setRowFilter(new StudentRowFilter());
			rowSorter.setSortsOnUpdates(true);
			setRowSorter(rowSorter);
			
		} else if(tableModel instanceof SubjectTableModel) {
			TableRowSorter<SubjectTableModel> rowSorter = new TableRowSorter<SubjectTableModel>((SubjectTableModel) tableModel);
			rowSorter.setRowFilter(new SubjectRowFilter<>());
			rowSorter.setSortsOnUpdates(true);
			setRowSorter(rowSorter);
		} else if(tableModel instanceof ProfessorTableModel) {
			TableRowSorter<ProfessorTableModel> rowSorter = new TableRowSorter<>((ProfessorTableModel) tableModel);
			rowSorter.setRowFilter(new ProfessorRowFilter<>());
			rowSorter.setSortsOnUpdates(true);
			setRowSorter(rowSorter);
		}
	}

	private void centerText() {
		for(int i = 0; i < getModel().getColumnCount(); i++) {
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment( JLabel.CENTER );
			getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
		}
	}
}
