package view;


import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
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
		setTitle("Studentska Služba");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
		
	}

}
