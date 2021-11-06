package view.ScreenComponent;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import utils.Constants;

public class Body extends JPanel {

	public Body() {
		super();
		setPreferredSize(new Dimension(Constants.SCREEN_WIDTH / 2, Constants.SCREEN_HEIGHT / 2 - 60));
		setBackground(Color.DARK_GRAY);
	}

}
