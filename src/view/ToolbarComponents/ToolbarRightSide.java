package view.ToolbarComponents;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import utils.ImageUtils;
import utils.PropertyFactory;

public class ToolbarRightSide extends JPanel {

	public ToolbarRightSide() {
		super();

		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		setPreferredSize(new Dimension(250, 40));

		JTextField searchBar = new JTextField();
		PropertyFactory.addBlackBorder(searchBar, 2);
		searchBar.setSize(new Dimension(30, 60));
		add(searchBar, PropertyFactory.setConstraintContants(c, 0, 0, 0.75, GridBagConstraints.HORIZONTAL));

		ImageIcon searchIcon = ImageUtils.scaleImage(new ImageIcon("./src/Icons/NewMenuItem.png"), 20, 20);
		JButton btnSearch = new JButton(searchIcon);
		ToolbarLeftSide.setButtonProperties(btnSearch);
		add(btnSearch, PropertyFactory.setConstraintContants(c, 1, 0, 0.25, GridBagConstraints.HORIZONTAL));

	}

}
