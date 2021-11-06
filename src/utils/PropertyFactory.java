package utils;

import java.awt.Color;
import java.awt.GridBagConstraints;

import javax.swing.BorderFactory;
import javax.swing.JComponent;

public class PropertyFactory {
	public static void addBlackBorder(JComponent comp, int thickness) {
		comp.setBorder(BorderFactory.createLineBorder(Color.black, thickness));
	}
	
	public static GridBagConstraints setConstraintContants(GridBagConstraints c, int gridx, int gridy, double weight, int gridBagConstant) {
		c.fill = gridBagConstant;
		c.gridx = gridx;
		c.gridy = gridy;
		c.weightx = weight;
		return c;
	}
}
