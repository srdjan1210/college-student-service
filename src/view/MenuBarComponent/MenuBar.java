package view.MenuBarComponent;

import java.awt.Image;

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

		ImageIcon imageIcon = new ImageIcon("Icons/OpenMenuItem.png");
		Image image = imageIcon.getImage().getScaledInstance(13, 13, Image.SCALE_SMOOTH);
		openMenuButton.setIcon(new ImageIcon(image));

		MenuItems studentsItem = new MenuItems("Studenti", null, null);

		MenuItems subjectsItem = new MenuItems("Predmeti", null, null);
		MenuItems professorsItem = new MenuItems("Profesori", null, null);
		MenuItems departmentsItem = new MenuItems("Katedre", null, null);
		openMenuButton.add(studentsItem);
		openMenuButton.add(subjectsItem);
		openMenuButton.add(professorsItem);

		openMenuButton.add(departmentsItem);

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
