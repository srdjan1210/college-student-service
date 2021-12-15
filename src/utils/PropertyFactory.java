package utils;

import java.awt.Color;
import java.awt.GridBagConstraints;

import javax.swing.BorderFactory;
import javax.swing.JComponent;

public class PropertyFactory {
	public static void addBlackBorder(JComponent comp, int thickness) {
		comp.setBorder(BorderFactory.createLineBorder(Color.black, thickness));
	}
}
