package view.TabComponent;

import javax.swing.JTabbedPane;

import controller.StudentEditController;
import model.DataModel;
import model.Student;
import view.ToolbarComponent.Student.ToolbarEditStudentFailed;
import view.ToolbarComponent.Student.ToolbarEditStudentInfo;

public class EditStudentTab extends JTabbedPane {
	private ToolbarEditStudentInfo editInfo;
	private ToolbarEditStudentFailed editFailed;
	public EditStudentTab() {
		super();
		editInfo = new ToolbarEditStudentInfo();
		editFailed = new ToolbarEditStudentFailed();
		String studentIndex = Tab.getSelectedStudentIndex();
		DataModel instance = DataModel.getInstance();
		Student student = instance.getStudentById(studentIndex);
		String studentData[] = StudentEditController.findStudentDataForFields(student);
		for (int i = 0; i < 8; i++)
			editInfo.setTextField(i, studentData[i]);
		
		editInfo.setComboBox(8, studentData[8]);
		editInfo.setComboBox(9, studentData[9]);
		add("Informacije", editInfo);
		add("Nepolozeni",editFailed);
	}
	
	public ToolbarEditStudentInfo getEditInfo() {
		return editInfo;
	}
}
