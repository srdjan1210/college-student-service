package view.TablesComponent;

import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tables extends JTable{
	public Tables(String[] columnNames)
	{
		super();
		String[][] data = {};
		int row_num=8;
		DefaultTableModel model=new DefaultTableModel(row_num,columnNames.length);
		model.setColumnIdentifiers(columnNames);
		setModel(model);
	}	
}
