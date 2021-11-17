package view.ToolbarComponent.ToolbarCustomComponents;

import java.awt.Dimension;

import javax.swing.JComboBox;

public class ToolbarWinCombo extends JComboBox {

	
	public ToolbarWinCombo(String[] dataList) {
		super(dataList);
		setPreferredSize(new Dimension(150, 30));


	}

}
