package view.ToolbarComponent.ToolbarCustomComponents;

import java.awt.Dimension;

import javax.swing.JLabel;

public class ToolbarWinLabel extends JLabel{
	
	
	public ToolbarWinLabel(String text) {
		super(text);
		setPreferredSize(new Dimension(150, 30));
	}

}
