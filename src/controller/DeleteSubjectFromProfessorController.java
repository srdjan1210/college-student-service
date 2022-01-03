package controller;

import javax.swing.JOptionPane;

import model.Database.DataModel;
import view.Screen;
import view.TablesComponent.Tables;
import view.ToolbarComponent.Professor.ToolbarEditProfessorSubjectsPanel;

public class DeleteSubjectFromProfessorController {
	public static Tables professorSubjectsTable;
	public DeleteSubjectFromProfessorController(ToolbarEditProfessorSubjectsPanel editProfessorSubjectsPanel) {
		int resp = JOptionPane.showConfirmDialog(null, "Da li ste sigurni?","Ukloni predmet",JOptionPane.YES_NO_OPTION);
		if (resp == 1)
			return;
		String selectedSubjectId = editProfessorSubjectsPanel.getSelectedSubjectId();
		DataModel model = DataModel.getInstance();
		Boolean success = model.removeSubjectFromProfessorSubjects(selectedSubjectId,
				Screen.getInstance().getStudentTab().getSelectedProfessorId());
		if(success)
			JOptionPane.showMessageDialog(null, "Predmet " + selectedSubjectId + " uspjesno uklonjen!");
		else
			JOptionPane.showMessageDialog(null, "Predmet " + selectedSubjectId + " nije pronadjen!");
	}
}
