package controller;

import javax.swing.JOptionPane;

import model.Database.DataModel;
import view.Screen;
import view.TablesComponent.Tables;
import view.ToolbarComponent.Professor.ToolbarEditProfessorSubjectsPanel;

public class DeleteSubjectFromProfessorController {
	public static Tables professorSubjectsTable;
	public DeleteSubjectFromProfessorController(ToolbarEditProfessorSubjectsPanel editProfessorSubjectsPanel) {
		int resp = JOptionPane.showConfirmDialog(null, Screen.getInstance().getResourceBundle().getString("areYouSure")
				,Screen.getInstance().getResourceBundle().getString("btnRemoveSubject"),JOptionPane.YES_NO_OPTION);
		if(editProfessorSubjectsPanel.getProfessorSubjectsTable().getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, Screen.getInstance().getResourceBundle().getString("notSelectedSubject"));
			return;
		}
		if (resp == 1)
			return;
		String selectedSubjectId = editProfessorSubjectsPanel.getSelectedSubjectId();
		DataModel model = DataModel.getInstance();
		Boolean success = model.removeSubjectFromProfessorSubjects(selectedSubjectId,
				Screen.getInstance().getStudentTab().getSelectedProfessorId());
		DataModel.getInstance().deleteProfessorFromSubject(Screen.getInstance().getStudentTab().getSelectedProfessorId(),selectedSubjectId);
		if(success)
			JOptionPane.showMessageDialog(null, Screen.getInstance().getResourceBundle().getString("tabSubject") + " " +selectedSubjectId + 
					Screen.getInstance().getResourceBundle().getString("successDelete"));
		else
			JOptionPane.showMessageDialog(null, Screen.getInstance().getResourceBundle().getString("tabSubject") + " " +selectedSubjectId +
					Screen.getInstance().getResourceBundle().getString("notFounded"));
	}
}
