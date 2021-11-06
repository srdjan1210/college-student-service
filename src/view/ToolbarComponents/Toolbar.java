package view.ToolbarComponents;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import utils.Constants;
import utils.PropertyFactory;

public class Toolbar extends JPanel {

	public Toolbar() {
		super();

		ToolbarLeftSide tls = new ToolbarLeftSide();
		ToolbarRightSide trs = new ToolbarRightSide();

		setPreferredSize(new Dimension(Constants.SCREEN_WIDTH, 40));
		setLayout(new BorderLayout());
		PropertyFactory.addBlackBorder(this, 1);

		add(tls, BorderLayout.LINE_START);
		add(trs, BorderLayout.LINE_END);

		setPreferredSize(new Dimension(100, 40));
	}

}
