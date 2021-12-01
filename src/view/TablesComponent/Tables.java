package view.TablesComponent;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tables extends JTable {
	public Tables(String[] columnNames, String[][] data) {
		super();
		DefaultTableModel dtm = new DefaultTableModel(data, columnNames);
		dtm.setColumnIdentifiers(columnNames);
		setModel(dtm);
		setAutoCreateRowSorter(true);
	}
}
