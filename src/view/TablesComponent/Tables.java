package view.TablesComponent;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class Tables extends JTable {
	public Tables(AbstractTableModel tableModel) {
		super();
		setModel(tableModel);
	}
}
