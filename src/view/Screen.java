package view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Screen extends JFrame {
	
	public Screen() {
		super();
		Toolkit toolkit = Toolkit.getDefaultToolkit();

		Dimension scrSize = toolkit.getScreenSize();
		int width = (int)scrSize.getWidth();
		int height = (int)scrSize.getHeight();
		setSize(width / 2, height / 2);
		setLocation(width / 4, height / 4);
		
		
		
		//Screen body
		Toolbar toolbar = new Toolbar();
		MenuBar menu = new MenuBar();
		JPanel footer = new JPanel();
		footer.setPreferredSize(new Dimension(width/2, 30));
		footer.setBackground(Color.WHITE);
		JPanel body = new JPanel();
		body.setPreferredSize(new Dimension(width/2, height/2 - 60));
		body.setBackground(Color.WHITE);
		setJMenuBar(menu);
		
		setLayout(new BorderLayout());
		add(toolbar, BorderLayout.PAGE_START);
		add(body, BorderLayout.CENTER);
		add(footer, BorderLayout.SOUTH);
		
		
		//Screen title and close operation
		setTitle("Studentska Služba");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
		
	}

}
