package view.ToolbarComponent.ToolbarCustomComponents;

import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;

public class ToolbarWinTxtField extends JTextField implements FocusListener {
	
	
	public ToolbarWinTxtField(String name) {
		super();
		setName(name);
		setPreferredSize(new Dimension(150, 30));
		this.addFocusListener(this);
	}

	@Override
	public void focusGained(FocusEvent e) {
	}

	@Override
	public void focusLost(FocusEvent e) {

	}
}
