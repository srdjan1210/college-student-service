package view;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;

import controller.ProfessorWindowController;
import controller.StudentWindowController;
import controller.SubjectWindowController;
import view.ToolbarComponent.Professor.ToolbarNewProfessor;
import view.ToolbarComponent.Student.ToolbarEditStudent;
import view.ToolbarComponent.Student.ToolbarEditStudentInfo;
import view.ToolbarComponent.Student.ToolbarNewStudent;
import view.ToolbarComponent.Subject.ToolbarNewSubject;

public class ListenerHandler {

	public static ActionListener openWindowListener(JComponent tib) {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Screen frame = (Screen) SwingUtilities.getWindowAncestor(tib);
				if (frame.getSelectedTab() == 0) {
					new ToolbarNewStudent();
					return;
				}

				if (frame.getSelectedTab() == 1) {
					new ToolbarNewProfessor();
					return;
				}

				if (frame.getSelectedTab() == 2) {
					new ToolbarNewSubject();
					return;
				}

			}

		};
	}

	public static ActionListener getButtonConfirmListener(JButton btnConfirm) {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Window parent = SwingUtilities.getWindowAncestor(btnConfirm);
				if (parent instanceof ToolbarNewStudent) {
					ToolbarNewStudent dialog = (ToolbarNewStudent) parent;
					StudentWindowController.addNewStudent(dialog);
				} else if (parent instanceof ToolbarNewProfessor) {
					ToolbarNewProfessor dialog = (ToolbarNewProfessor) parent;
					ProfessorWindowController.addProfessor(dialog);
				} else if (parent instanceof ToolbarNewSubject) {
					ToolbarNewSubject dialog = (ToolbarNewSubject) parent;
					SubjectWindowController.addSubject(dialog);
				}

			}
		};
	}

	public static ActionListener getButtonCancelListener(JButton cancelButton) {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Window parent = SwingUtilities.getWindowAncestor(cancelButton);
				if (parent instanceof ToolbarNewStudent) {
					ToolbarNewStudent dialog = (ToolbarNewStudent) parent;
					dialog.dispose();
				} else if (parent instanceof ToolbarNewProfessor) {
					ToolbarNewProfessor dialog = (ToolbarNewProfessor) parent;
					dialog.dispose();
				} else if (parent instanceof ToolbarNewSubject) {
					ToolbarNewSubject dialog = (ToolbarNewSubject) parent;
					dialog.dispose();
				}
			}
		};
	}

	public static ActionListener openEditDialogListener(JButton btnEdit) {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ToolbarEditStudent editDialog = new ToolbarEditStudent();
				editDialog.setVisible();

			}

		};
	}

}
