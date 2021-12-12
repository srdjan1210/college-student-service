package view.TabComponent;

import javax.swing.JTabbedPane;

import controller.EditingProfessorController;
import model.Database.DataModel;
import model.Professor;
import view.Screen;
import view.ToolbarComponent.Professor.ToolbarEditProfessorInfo;
import view.ToolbarComponent.Student.ToolbarEditStudentInfo;

public class EditProfessorTab extends JTabbedPane {
	private ToolbarEditProfessorInfo editInfo;
	public EditProfessorTab() {
		super();
		editInfo = new ToolbarEditProfessorInfo();
		String professorId = Screen.getInstance().getStudentTab().getSelectedProfessorId();
		DataModel instance = DataModel.getInstance();
		Professor professor = instance.getProfessorById(professorId);
		String[] professorData = EditingProfessorController.findProfessorDataForFields(professor);
		for (int i = 0; i < 10; i++)
			editInfo.setTextField(i, professorData[i]);
		add("Informacije", editInfo);
	}
	
	public ToolbarEditProfessorInfo getToolbarEditProfessorInfo() {
		return editInfo;
	}

}
