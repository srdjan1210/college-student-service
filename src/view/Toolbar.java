package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextField;

import view.ToolbarComponents.ToolbarLeftSide;

public class Toolbar extends JPanel {
	
	public Toolbar() {
		super();
		JTextField searchField = new JTextField();
		ToolbarLeftSide tls = new ToolbarLeftSide();
		setPreferredSize(new Dimension(500, 40));
		setBackground(Color.DARK_GRAY);
		setLayout(new BorderLayout());
		add(tls, BorderLayout.LINE_START);
		add(searchField, BorderLayout.LINE_END);
		
		setPreferredSize(new Dimension(100, 40));
	}

}
