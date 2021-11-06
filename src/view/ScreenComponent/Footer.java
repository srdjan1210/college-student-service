package view.ScreenComponent;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import utils.Constants;

public class Footer extends JPanel{
	
	public Footer() {
		super();
		setPreferredSize(new Dimension(Constants.SCREEN_WIDTH / 2, 30));
		setBackground(Color.RED);
	}

}
