package view.TablesComponent;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class Tables extends JTable {
	public Tables(AbstractTableModel tableModel) {
		super();
		setModel(tableModel);
	}
}
