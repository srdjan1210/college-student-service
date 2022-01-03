package view.ToolbarComponent.ToolbarCustomComponents;

import java.awt.Dimension;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.TableView;

import model.TableModel.ProfessorTableModel;
import model.TableModel.StudentTableModel;
import model.TableModel.SubjectTableModel;
import utils.PropertyFactory;
import view.RowFilters.ProfessorRowFilter;
import view.RowFilters.StudentRowFilter;
import view.RowFilters.SubjectRowFilter;
import view.Screen;

public class ToolbarSearch extends JTextField implements DocumentListener {

	public ToolbarSearch() {
		super();
		setPreferredSize(new Dimension(130, 30));
		setMaximumSize(new Dimension(130, 30));
		PropertyFactory.addBlackBorder(this, 2);
		getDocument().addDocumentListener(this);
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		updateSearch();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		updateSearch();
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		updateSearch();
	}

	private void updateSearch() {
		int currentTab = Screen.getInstance().getSelectedTab();
		String text = getText();

		if(currentTab == 0) {
			StudentTableModel tableModel = (StudentTableModel) Screen.getInstance().getStudentTab().getStudentTable().getModel();
			TableRowSorter<StudentTableModel> rowSorter = (TableRowSorter<StudentTableModel>) Screen.getInstance().getStudentTab().getStudentTable().getRowSorter();
			StudentRowFilter studentRowFilter = (StudentRowFilter) rowSorter.getRowFilter();
			studentRowFilter.setFilterWord(text);
			tableModel.fireTableDataChanged();
		}
		else if(currentTab == 2) {
			SubjectTableModel tableModel = (SubjectTableModel) Screen.getInstance().getStudentTab().getSubjectTable().getModel();
			TableRowSorter<SubjectTableModel> rowSorter = (TableRowSorter<SubjectTableModel>) Screen.getInstance().getStudentTab().getSubjectTable().getRowSorter();
			SubjectRowFilter subjectRowFilter = (SubjectRowFilter) rowSorter.getRowFilter();
			subjectRowFilter.setFilterWord(text);
			tableModel.fireTableDataChanged();
		} else if(currentTab == 1) {
			ProfessorTableModel tableModel = (ProfessorTableModel) Screen.getInstance().getStudentTab().getProfessorTable().getModel();
			TableRowSorter<ProfessorTableModel> rowSorter = (TableRowSorter<ProfessorTableModel>) Screen.getInstance().getStudentTab().getProfessorTable().getRowSorter();
			ProfessorRowFilter subjectRowFilter = (ProfessorRowFilter) rowSorter.getRowFilter();
			subjectRowFilter.setFilterWord(text);
			tableModel.fireTableDataChanged();
		}

	}
}
