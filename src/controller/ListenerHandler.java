package controller;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import view.Screen;
import view.TabComponent.Tab;
import view.ToolbarComponent.AddingScreen;
import view.ToolbarComponent.EditingScreen;
import view.ToolbarComponent.Professor.ToolbarNewProfessor;
import view.ToolbarComponent.Student.ToolbarEditStudent;
import view.ToolbarComponent.Student.ToolbarNewStudent;
import view.ToolbarComponent.Subject.ToolbarNewSubject;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarIconButton;

public class ListenerHandler {

	public static ActionListener openWindowListener(JComponent tib) {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Screen frame = Screen.getInstance();
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
				if(parent instanceof AddingScreen) {
					Screen.getInstance().getStudentTab().addNewEntity((AddingScreen)parent);
				}
				else if(parent instanceof EditingScreen) {
					Screen.getInstance().getStudentTab().editNewEntity((EditingScreen)parent);
				}
//				if (parent instanceof ToolbarNewStudent) {
//					ToolbarNewStudent dialog = (ToolbarNewStudent) parent;
//					StudentAddingController.addNewStudent(dialog);
//				} else if (parent instanceof ToolbarNewProfessor) {
//					ToolbarNewProfessor dialog = (ToolbarNewProfessor) parent;
//					ProfessorAddingController.addProfessor(dialog);
//				} else if (parent instanceof ToolbarNewSubject) {
//					ToolbarNewSubject dialog = (ToolbarNewSubject) parent;
//					SubjectAddingController.addSubject(dialog);
//				} else if (parent instanceof ToolbarEditStudent) {
//					ToolbarEditStudent dialog = (ToolbarEditStudent) parent;
//					StudentEditController.editStudent(dialog.getEditStudentTab().getEditInfo(),dialog);
//				}

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
				} else if (parent instanceof ToolbarEditStudent) {
					ToolbarEditStudent dialog = (ToolbarEditStudent) parent;
					dialog.dispose();
				}
			}
		};
	}

	public static ActionListener getButtonDeleteListener() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ToolbarIconButton buttonDelete = (ToolbarIconButton) e.getSource();
				Screen screen = (Screen) SwingUtilities.getWindowAncestor(buttonDelete);

				if(screen.getSelectedTab() == 0) {
					DeleteEntityController.deleteStudent(Screen.getInstance().getStudentTab().getSelectedStudentIndex());
					return;
				}

				if(screen.getSelectedTab() == 1) {
					DeleteEntityController.deleteProfessor(Tab.getSelectedProfessorId());
					return;
				}

				if(screen.getSelectedTab() == 2) {
					DeleteEntityController.deleteSubject(Tab.getSelectedSubjectId());
					return;
				}

			}
		};
	}

	public static ActionListener openEditDialogListener(JButton btnEdit) {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!Screen.getInstance().getStudentTab().getSelectedStudentIndex().equals("")) {
				ToolbarEditStudent editDialog = new ToolbarEditStudent();
				editDialog.setVisible();
				}
				else
					JOptionPane.showMessageDialog(null, "Morate odabrati studenta kog menjate!", "InfoBox: " + "Problem sa izmenom studenta!", JOptionPane.INFORMATION_MESSAGE);

			}

		};
	}

}
