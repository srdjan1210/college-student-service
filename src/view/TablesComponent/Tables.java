package view.TablesComponent;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class Tables extends JTable {
	public Tables(AbstractTableModel tableModel) {
		super();
		setModel(tableModel);
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setColumnSelectionAllowed(false);
	}
}
