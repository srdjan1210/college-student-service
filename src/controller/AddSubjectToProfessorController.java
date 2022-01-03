package controller;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import model.Subject;
import model.Database.DataModel;
import view.Screen;
import view.ToolbarComponent.ToolbarCustomComponents.SubjectListModel;

public class AddSubjectToProfessorController {
	
	public void addNewSubject() {
		String id = Screen.getInstance().getStudentTab().getSelectedProfessorId();
		ArrayList<Subject> subjects = DataModel.getInstance().getNewSubjectsForProfessor(id);
		if(subjects.size() == 0) {
			JOptionPane.showMessageDialog(null, "Nema predmeta za dodavanje");
			return;
		}
		JList selektor = new JList(new SubjectListModel(subjects));
		selektor.setPreferredSize(new Dimension(100,300));
		int result = JOptionPane.showConfirmDialog(null, new JScrollPane(selektor),"Izaberi predmet!", JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
		
		if(result == 0) {
			if(selektor.getSelectedIndex() == -1) {
				JOptionPane.showMessageDialog(null, "Niste selektovali predmet");
				return;
			}
			Subject subject = ((SubjectListModel) selektor.getModel()).getSelectedSubject(selektor.getSelectedIndex());
			DataModel.getInstance().addSubjectToProfessor(id, subject);
			
		}
	}

}
