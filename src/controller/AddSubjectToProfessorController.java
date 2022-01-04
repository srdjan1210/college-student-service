package controller;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import model.Subject;
import model.Database.DataModel;
import view.Screen;
import view.JListModels.SubjectListModel;

public class AddSubjectToProfessorController {
	
	public void addNewSubject() {
		String id = Screen.getInstance().getStudentTab().getSelectedProfessorId();
		ArrayList<Subject> subjects = DataModel.getInstance().getNewSubjectsForProfessor(id);
		if(subjects.size() == 0) {
			JOptionPane.showMessageDialog(null, Screen.getInstance().getResourceBundle().getString("noSubject"));
			return;
		}
		JList selektor = new JList(new SubjectListModel(subjects));
		selektor.setPreferredSize(new Dimension(100,300));
		int result = JOptionPane.showConfirmDialog(null, new JScrollPane(selektor),Screen.getInstance().getResourceBundle().getString("chooseSubject"), JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
		
		if(result == 0) {
			if(selektor.getSelectedIndex() == -1) {
				JOptionPane.showMessageDialog(null, Screen.getInstance().getResourceBundle().getString("notSelectedSubject"));
				return;
			}
			Subject subject = ((SubjectListModel) selektor.getModel()).getSelectedSubject(selektor.getSelectedIndex());
			DataModel.getInstance().addSubjectToProfessor(id, subject);
			
		}
	}

}
