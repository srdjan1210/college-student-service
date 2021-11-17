package view.ToolbarComponent.ToolbarCustomComponents;

import java.awt.Dimension;

import javax.swing.JTextField;

import utils.PropertyFactory;

public class ToolbarSearch extends JTextField {

	public ToolbarSearch() {
		super();
		setPreferredSize(new Dimension(130, 30));
		setMaximumSize(new Dimension(130, 30));
		PropertyFactory.addBlackBorder(this, 2);
	}
}
