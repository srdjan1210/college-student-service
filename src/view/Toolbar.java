package view;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class Toolbar extends JPanel {
	
	public Toolbar() {
		super();
		add(new JButton("dugme1"));
		add(new JButton("dugme2"));
		setBounds(0, 0, 500, 100);
	}

}
