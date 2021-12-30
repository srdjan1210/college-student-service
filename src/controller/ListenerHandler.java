package controller;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;

import view.Screen;
import view.ToolbarComponent.AddingScreen;
import view.ToolbarComponent.EditingScreen;
import view.ToolbarComponent.Professor.ToolbarEditProfessor;
import view.ToolbarComponent.Professor.ToolbarNewProfessor;
import view.ToolbarComponent.Student.ToolbarEditStudent;
import view.ToolbarComponent.Student.ToolbarEditStudentFailedPanel;
import view.ToolbarComponent.Student.ToolbarNewStudent;
import view.ToolbarComponent.Subject.ToolbarEditSubject;
import view.ToolbarComponent.Subject.ToolbarNewSubject;

public class ListenerHandler {

	public static ActionListener openWindowListener() {
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
				if (parent instanceof AddingScreen) {
					Screen.getInstance().getStudentTab().addNewEntity((AddingScreen) parent);
				} else if (parent instanceof EditingScreen) {
					Screen.getInstance().getStudentTab().editNewEntity((EditingScreen) parent);
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
				} else if (parent instanceof ToolbarEditStudent) {
					ToolbarEditStudent dialog = (ToolbarEditStudent) parent;
					dialog.dispose();
				} else if (parent instanceof ToolbarEditSubject) {
					ToolbarEditSubject dialog = (ToolbarEditSubject) parent;
					dialog.dispose();
				}
			}
		};
	}

	public static ActionListener getButtonDeleteListener() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Screen.getInstance().getStudentTab().deleteEntity();
			}
		};
	}

	public static ActionListener openEditDialogListener() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Screen frame = Screen.getInstance();
				if (frame.getSelectedTab() == 0) {
					if(Screen.getInstance().getStudentTab().getStudentTable().getSelectedRow() == -1) {
			            JOptionPane.showMessageDialog(null, "Student nije selektovan!", "Izmena studenta",JOptionPane.WARNING_MESSAGE);
			            return;
			        }
					ToolbarEditStudent editDialog = new ToolbarEditStudent();
					editDialog.setVisible();
					return;
				}

				if (frame.getSelectedTab() == 1) {
					if(Screen.getInstance().getStudentTab().getProfessorTable().getSelectedRow() == -1) {
			            JOptionPane.showMessageDialog(null, "Profesor nije selektovan!", "Izmena profesora",JOptionPane.WARNING_MESSAGE);
			            return;
			        }
					ToolbarEditProfessor editDialog = new ToolbarEditProfessor();
					editDialog.setVisible();
					return;
				}

				if (frame.getSelectedTab() == 2) {
					if(Screen.getInstance().getStudentTab().getSubjectTable().getSelectedRow() == -1) {
			            JOptionPane.showMessageDialog(null, "Predmet nije selektovan!", "Izmena predmeta",JOptionPane.WARNING_MESSAGE);
			            return;
			        }
					ToolbarEditSubject editDialog = new ToolbarEditSubject();
					editDialog.setVisible();
					return;
				}
				// TODO Auto-generated method stub

			}

		};
	}

	public static ActionListener getButtonDeleteFailedSubjectListener(ToolbarEditStudentFailedPanel failedPanel) {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				failedPanel.setDeleteController(new DeleteFailedSubjectController(failedPanel));
				return;
			}

		};
	}

	public static FocusListener getAdressScreenListener() {
		return new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if(!((JTextField)e.getSource()).getText().trim().equals("")) return;
				JTextField countryName = new JTextField();
				JTextField cityName = new JTextField();
				JTextField streetName = new JTextField();
				JTextField streetNumber = new JTextField();

				final JComponent[] inputs = new JComponent[] {
						new JLabel("Drzava"),
						countryName,
						new JLabel("Grad"),
						cityName,
						new JLabel("Ulica"),
						streetName,
						new JLabel("Broj"),
						streetNumber

				};
				String resultText = "";
				int result = JOptionPane.showConfirmDialog(null, inputs, "Unesite Adresu", JOptionPane.PLAIN_MESSAGE);
				if (result == JOptionPane.OK_OPTION) {
					resultText =
							countryName.getText() + ":" +
									cityName.getText() + ":" +
									streetName.getText() + ":" +
									streetNumber.getText();
					JTextField field = ((JTextField)e.getSource());
					field.setText(resultText);
					field.getParent().requestFocus();
				}


			}

			@Override
			public void focusLost(FocusEvent e) {

			}
		};
	}

}
