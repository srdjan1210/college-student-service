package view.ToolbarComponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import utils.ImageUtils;

public class ToolbarLeftSide extends JPanel {
	
	public ToolbarLeftSide() {
		super();
		setLayout(new GridLayout(1, 3));
		setPreferredSize(new Dimension(120, 40));
		ImageIcon iconNew = ImageUtils.scaleImage(new ImageIcon("./src/Icons/NewMenuItem.png"), 20, 20);
		ImageIcon iconEdit = ImageUtils.scaleImage(new ImageIcon("./src/Icons/EditMenuItem.png"), 20, 20);
		ImageIcon iconDelete = ImageUtils.scaleImage(new ImageIcon("./src/Icons/DeleteMenuItem.png"), 20, 20);
		
		JButton btnNew = new JButton(iconNew);
		JButton btnEdit = new JButton(iconEdit);
		JButton btnDelete = new JButton(iconDelete);
		
		setButtonProperties(btnNew);
		setButtonProperties(btnEdit);
		setButtonProperties(btnDelete);
		
		
		add(btnNew);
		add(btnEdit);
		add(btnDelete);
		
	}
	
	protected static void setButtonProperties(JButton button) {
		button.setSize(20, 20);
		button.setBackground(Color.WHITE);
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setContentAreaFilled(false);;
	}

}
