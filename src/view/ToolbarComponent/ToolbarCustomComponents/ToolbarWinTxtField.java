package view.ToolbarComponent.ToolbarCustomComponents;

import java.awt.Dimension;

import javax.swing.JTextField;

public class ToolbarWinTxtField extends JTextField{
	
	
	public ToolbarWinTxtField(String name) {
		super();
		setName(name);
		setPreferredSize(new Dimension(150, 30));
		
	}

}
