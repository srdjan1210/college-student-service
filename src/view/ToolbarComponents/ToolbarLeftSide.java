package view.ToolbarComponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import utils.ImageUtils;

public class ToolbarLeftSide extends JPanel {
	
	public ToolbarLeftSide() {
		super();
		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(300, 40));
		ImageIcon iconNew = ImageUtils.scaleImage(new ImageIcon("./src/Icons/NewMenuItem.png"));
		ImageIcon iconEdit = ImageUtils.scaleImage(new ImageIcon("./src/Icons/EditMenuItem.png"));
		ImageIcon iconDelete = ImageUtils.scaleImage(new ImageIcon("./src/Icons/DeleteMenuItem.png"));
		
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
	
	public void setButtonProperties(JButton button) {
		button.setSize(20, 20);
		button.setBackground(Color.WHITE);
	}

}
