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
	
	public void notifyEditing(Vector<String> row) {
		DefaultTableModel dtm = (DefaultTableModel) this.getModel();
		Vector<Vector> data = dtm.getDataVector();
		int forRemoving = 0;
		for(int i=0;i<data.size();i++) {
			Vector<String> dataTemp = data.get(i);
			if(dataTemp.get(0).equals(row.get(0))) {
				forRemoving = i;
				break;
			}
		}
		dtm.removeRow(forRemoving);
		System.out.println(forRemoving);
	//	dtm.fireTableRowsDeleted(forRemoving, forRemoving);
		dtm.addRow(row);
		dtm.fireTableRowsInserted(dtm.getRowCount() - 1, dtm.getRowCount() - 1);
		System.out.println("EDITUJEEEEEEEM!!!!");
	}

}
