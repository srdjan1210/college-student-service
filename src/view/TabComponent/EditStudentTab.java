package view.TabComponent;

import javax.swing.JTabbedPane;

import controller.AddFailedSubjectController;
import controller.AddPassedSubjectController;
import controller.DeleteFailedSubjectController;
import controller.EditingStudentController;
import controller.TakingExamController;
import model.Database.DataModel;
import model.Student;
import view.Screen;
import view.ToolbarComponent.Student.ToolbarEditStudentFailedPanel;
import view.ToolbarComponent.Student.ToolbarEditStudentInfoPanel;
import view.ToolbarComponent.Student.ToolbarEditStudentPassedPanel;

public class EditStudentTab extends JTabbedPane {
	private ToolbarEditStudentInfoPanel editInfo;
	private ToolbarEditStudentFailedPanel editFailed;
	private ToolbarEditStudentPassedPanel editPassed;

	public EditStudentTab(AddPassedSubjectController addPassedSubjectController,AddFailedSubjectController addingController,DeleteFailedSubjectController deleteController,TakingExamController examController) {
		super();
		editInfo = new ToolbarEditStudentInfoPanel();
		editFailed = new ToolbarEditStudentFailedPanel(addingController,deleteController,examController);
		editPassed = new ToolbarEditStudentPassedPanel(addPassedSubjectController);
		String studentIndex = Screen.getInstance().getStudentTab().getSelectedStudentIndex();
		DataModel instance = DataModel.getInstance();
		Student student = instance.getStudentById(studentIndex);
		String studentData[] = EditingStudentController.findStudentDataForFields(student);
		for (int i = 0; i < 8; i++)
			editInfo.setTextField(i, studentData[i]);

		editInfo.setComboBox(8, studentData[8]);
		editInfo.setComboBox(9, studentData[9]);
		add("Informacije", editInfo);
		add("Polozeni", editPassed);
		add("Nepolozeni", editFailed);

	}

	public ToolbarEditStudentInfoPanel getToolbarEditStudentInfo() {
		return editInfo;
	}

	public ToolbarEditStudentFailedPanel getToolbarEditStudentFailed() {
		return editFailed;
	}

	public ToolbarEditStudentPassedPanel getToolbarEditStudentPassed() { return editPassed; }
}
