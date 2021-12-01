package view.MenuBarComponent;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.event.MenuKeyEvent;

import utils.ImageUtils;
import view.ListenerHandler;
import view.Screen;
import view.ToolbarComponent.Student.ToolbarNewStudent;

public class MenuBar extends JMenuBar {
	private MenuBar context = this;

	public MenuBar() {
		super();
		JMenu fileMenuButton = new JMenu("File");
		JMenu editMenuButton = new JMenu("Edit");
		JMenu helpMenuButton = new JMenu("Help");

		fileMenuButton.setMnemonic('F');
		editMenuButton.setMnemonic('E');
		helpMenuButton.setMnemonic('H');

		MenuItems newMenuItem = new MenuItems("New", "Icons/NewMenuItem.png", "CTRL + N", 'N');
		newMenuItem.addActionListener(ListenerHandler.openWindowListener(context));
		MenuItems saveMenuItem = new MenuItems("Save", "Icons/SaveMenuItem.png", "CTRL + S", 'S');
		MenuItems closeMenuItem = new MenuItems("Close", "Icons/CloseMenuItem.png", "CTRL + C", 'C');

		MenuItems editMenuItem = new MenuItems("Edit", "Icons/EditMenuItem.png", "CTRL + E", 'E');
		MenuItems deleteMenuItem = new MenuItems("Delete", "Icons/DeleteMenuItem.png", "CTRL + D", 'D');

		MenuItems helpMenuItem = new MenuItems("Help", "Icons/HelpMenuItem.png", "CTRL + H", 'H');
		MenuItems aboutMenuItem = new MenuItems("About", "Icons/AboutMenuItem.png", "CTRL + A", 'A');

		JMenu openMenuButton = new JMenu("Open");

		ImageIcon imageIcon = ImageUtils.readImageIcon("Icons/OpenMenuItem.png");
		Image image = imageIcon.getImage().getScaledInstance(13, 13, Image.SCALE_SMOOTH);
		openMenuButton.setIcon(new ImageIcon(image));

		MenuItems studentsItem = new MenuItems("Studenti", "Icons/StudentMenuItem.png", "CTRL + Q", 'Q');
		MenuItems subjectsItem = new MenuItems("Predmeti", "Icons/SubjectMenuItem.png", "CTRL + W", 'W');
		MenuItems professorsItem = new MenuItems("Profesori", "Icons/ProfessorMenuItems.png", "CTRL + R", 'R');
		MenuItems departmentsItem = new MenuItems("Katedre", "Icons/DepartmentMenuItem.png", "CTRL + T", 'T');

		openMenuButton.add(studentsItem);
		openMenuButton.add(subjectsItem);
		openMenuButton.add(professorsItem);
		openMenuButton.add(departmentsItem);
		openMenuButton.setMnemonic('O');

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
