package view.TablesComponent;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class Tables extends JTable {
	public Tables(Vector<String> columnNames, Vector<Vector<String>> data) {
		super();
		DefaultTableModel dtm = new DefaultTableModel(data, columnNames);
		setModel(dtm);
		setAutoCreateRowSorter(true);
	}

	public void notifyInserted(Vector<String> row) {
		DefaultTableModel dtm = (DefaultTableModel) this.getModel();
		dtm.addRow(row);
	}

	public void notifyDeleted(String index) {
		DefaultTableModel dtm = (DefaultTableModel) this.getModel();
		Vector<Vector> data = dtm.getDataVector();
		int rowIndex = 0;
		for(Vector<String> row: data) {
			if(row.get(0).equals(index)) break;
			rowIndex++;
		}
		dtm.removeRow(rowIndex);

	}
}
