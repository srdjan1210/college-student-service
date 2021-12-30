package controller;

import javax.swing.JOptionPane;

import model.Database.DataModel;
import view.Screen;
import view.TablesComponent.Tables;
import view.ToolbarComponent.Student.ToolbarEditStudentFailedPanel;

public class DeleteFailedSubjectController {
	public static Tables failedSubjectsTable;

	public DeleteFailedSubjectController(ToolbarEditStudentFailedPanel editFailedPanel) {
		int resp = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite ukloniti nepolozeni predmet?",
				"Obrisi nepolozeni predmet?", JOptionPane.YES_NO_OPTION);
		if (resp == 1)
			return;
		String selectedSubjectId = editFailedPanel.getSelectedSubjectId();
		DataModel model = DataModel.getInstance();
		Boolean success = model.removeFailedSubjectFromStudentSubjects(selectedSubjectId,
				Screen.getInstance().getStudentTab().getSelectedStudentIndex());
		if (success) {
			JOptionPane.showMessageDialog(null, "Predmet " + selectedSubjectId + " uspjesno uklonjen!");
		} else
			JOptionPane.showMessageDialog(null, "Predmet " + selectedSubjectId + " nije pronadjen!");
	}
}
