package view.TablesComponent;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class Tables extends JTable {
	public Tables(Vector<String> columnNames, Vector<Vector<String>> data) {
		super();
		DefaultTableModel dtm = new DefaultTableModel(data, columnNames);
		dtm.setColumnIdentifiers(columnNames);
		setModel(dtm);
		setAutoCreateRowSorter(true);
	}

	public void notifyInserted(Vector<String> row) {
		DefaultTableModel dtm = (DefaultTableModel) this.getModel();
		dtm.addRow(row);
		dtm.fireTableRowsInserted(dtm.getRowCount() - 1, dtm.getRowCount() - 1);
	}

}
