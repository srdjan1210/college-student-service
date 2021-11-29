package view.ToolbarComponent.ToolbarCustomComponents;


import controller.ProfessorWindowController;
import controller.StudentWindowController;
import controller.SubjectWindowController;
import view.ToolbarComponent.Professor.ToolbarNewProfessor;
import view.ToolbarComponent.Student.ToolbarNewStudent;
import view.ToolbarComponent.Subject.ToolbarNewSubject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ToolbarEnterExitPanel extends JPanel{

	private JButton buttonConfirm;
	private JButton buttonExit;
	public ToolbarEnterExitPanel() {
		super();
		BoxLayout layout = new BoxLayout(this, BoxLayout.X_AXIS);
		setLayout(layout);


		buttonConfirm = new JButton("Potvrdi");
		buttonConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Window parent = SwingUtilities.getWindowAncestor(buttonConfirm);
				if(parent instanceof ToolbarNewStudent) {
					ToolbarNewStudent dialog = (ToolbarNewStudent) parent;
					StudentWindowController.addNewStudent(dialog);
				} else if(parent instanceof ToolbarNewProfessor) {
					ToolbarNewProfessor dialog = (ToolbarNewProfessor) parent;
					ProfessorWindowController.addProfessor(dialog);
				} else if(parent instanceof ToolbarNewSubject) {
					ToolbarNewSubject dialog = (ToolbarNewSubject) parent;
					SubjectWindowController.addSubject(dialog);
				}

			}
		});
		buttonExit = new JButton("Otkazi");
		buttonExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Window parent = SwingUtilities.getWindowAncestor(buttonConfirm);
				if(parent instanceof ToolbarNewStudent) {
					ToolbarNewStudent dialog = (ToolbarNewStudent) parent;
					dialog.dispose();
				} else if(parent instanceof ToolbarNewProfessor) {
					ToolbarNewProfessor dialog = (ToolbarNewProfessor) parent;
					dialog.dispose();
				}
			}
		});;

		add(buttonConfirm);
		add(Box.createHorizontalStrut(50));
		add(buttonExit);
	}
	
	
	public JButton getButtonConfirm() {
		return buttonConfirm; 
	}
	
	public JButton getButtonExit() {
		return buttonExit;
	}
}
