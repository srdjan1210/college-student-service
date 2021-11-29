package view.TabComponent;

import javax.swing.JTabbedPane;

import view.ToolbarComponent.Student.ToolbarEditStudentInfo;

public class EditStudentTab extends JTabbedPane {
	public EditStudentTab() {
		super();
		ToolbarEditStudentInfo editInfo =  new ToolbarEditStudentInfo();
		add("Informacije",editInfo);
	}
}
