package view.TabComponent;



import javax.swing.JTabbedPane;
import javax.swing.*;

import controller.EditingProfessorController;
import model.Database.DataModel;
import model.Professor;
import model.TableModel.ProfessorSubjectsTableModel;
import view.Screen;
import view.TablesComponent.Tables;
import view.ToolbarComponent.Professor.ToolbarEditProfessorInfoPanel;
import view.ToolbarComponent.Professor.ToolbarEditProfessorSubjectsPanel;

public class EditProfessorTab extends JTabbedPane {
	private ToolbarEditProfessorInfoPanel editInfo;
	private ToolbarEditProfessorSubjectsPanel editSubjects;
	
	public EditProfessorTab() {
		super();
		editInfo = new ToolbarEditProfessorInfoPanel();
		editSubjects = new ToolbarEditProfessorSubjectsPanel();
		String professorId = Screen.getInstance().getStudentTab().getSelectedProfessorId();
		DataModel instance = DataModel.getInstance();
		Professor professor = instance.getProfessorById(professorId);
		String[] professorData = EditingProfessorController.findProfessorDataForFields(professor);
		for (int i = 0; i < 10; i++)
			editInfo.setTextField(i, professorData[i]);
		add("Informacije", editInfo);
		add("Predmeti", new ToolbarEditProfessorSubjectsPanel());
	}

	public ToolbarEditProfessorInfoPanel getToolbarEditProfessorInfo() {
		return editInfo;
	}
	
	

}
