package view.TabComponent;

import javax.swing.JTabbedPane;

import controller.DeleteFailedSubjectController;
import controller.EditingStudentController;
import model.Database.DataModel;
import model.Student;
import view.Screen;
import view.ToolbarComponent.Student.ToolbarEditStudentFailed;
import view.ToolbarComponent.Student.ToolbarEditStudentInfo;

public class EditStudentTab extends JTabbedPane {
	private ToolbarEditStudentInfo editInfo;
	private ToolbarEditStudentFailed editFailed;
	private int selectedTab;
	public EditStudentTab() {
		super();
		editInfo = new ToolbarEditStudentInfo();
		editFailed = new ToolbarEditStudentFailed();
		String studentIndex = Screen.getInstance().getStudentTab().getSelectedStudentIndex();
		DataModel instance = DataModel.getInstance();
		Student student = instance.getStudentById(studentIndex);
		String studentData[] = EditingStudentController.findStudentDataForFields(student);
		for (int i = 0; i < 8; i++)
			editInfo.setTextField(i, studentData[i]);
		
		editInfo.setComboBox(8, studentData[8]);
		editInfo.setComboBox(9, studentData[9]);
		add("Informacije", editInfo);
		add("Nepolozeni",editFailed);
	}
	
	public ToolbarEditStudentInfo getToolbarEditStudentInfo() {
		return editInfo;
	}
	
	public ToolbarEditStudentFailed getToolbarEditStudentFailed() {
		return editFailed;
	}
}
