package view;


import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MenuBar extends JMenuBar {

	public MenuBar() {
		super();
		JMenu fileMenuButton = new JMenu("File");
		JMenu editMenuButton = new JMenu("Edit");
		JMenu helpMenuButton = new JMenu("Help");

		MenuItems newMenuItem = new MenuItems("New", "Icons/NewMenuItem.png", "CTRL + N");
		MenuItems saveMenuItem = new MenuItems("Save", "Icons/SaveMenuItem.png", "CTRL + S");
		MenuItems closeMenuItem = new MenuItems("Close", "Icons/CloseMenuItem.png", "CTRL + C");

		MenuItems editMenuItem = new MenuItems("Edit", "Icons/EditMenuItem.png", "CTRL + E");
		MenuItems deleteMenuItem = new MenuItems("Delete", "Icons/DeleteMenuItem.png", "CTRL + D");

		MenuItems helpMenuItem = new MenuItems("Help", "Icons/HelpMenuItem.png", "CTRL + H");
		MenuItems aboutMenuItem = new MenuItems("About", "Icons/AboutMenuItem.png", "CTRL + A");

		JMenu openMenuButton = new JMenu("Open");
		Image icon = Toolkit.getDefaultToolkit().getImage("Icons/OpenMenuItem.png");

		icon = icon.getScaledInstance(13, 13, icon.SCALE_SMOOTH);
		openMenuButton.setIcon(new ImageIcon(icon));

		MenuItems studentiItem = new MenuItems("Studenti", null, null);
		MenuItems predmetiItem = new MenuItems("Predmeti", null, null);
		MenuItems profesoriItem = new MenuItems("Profesori", null, null);
		MenuItems katedreItem = new MenuItems("Katedre", null, null);
		openMenuButton.add(studentiItem);
		openMenuButton.add(predmetiItem);
		openMenuButton.add(profesoriItem);
		openMenuButton.add(katedreItem);

		fileMenuButton.add(newMenuItem);
		fileMenuButton.add(saveMenuItem);
		fileMenuButton.add(openMenuButton);
		fileMenuButton.add(closeMenuItem);

		editMenuButton.add(editMenuItem);
		editMenuButton.add(deleteMenuItem);

		helpMenuButton.add(helpMenuItem);
		helpMenuButton.add(aboutMenuItem);

		this.add(fileMenuButton);
		this.add(editMenuButton);
		this.add(helpMenuButton);

	}
}
