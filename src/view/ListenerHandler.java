package view;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import controller.DeleteSubjectFromProfessorController;
import view.ToolbarComponent.AddingScreen;
import view.ToolbarComponent.Department.DepartmentEditWindow;
import view.ToolbarComponent.EditingScreen;
import view.ToolbarComponent.Professor.ToolbarEditProfessor;
import view.ToolbarComponent.Professor.ToolbarEditProfessorSubjectsPanel;
import view.ToolbarComponent.Professor.ToolbarNewProfessor;
import view.ToolbarComponent.Student.ToolbarEditStudent;
import view.ToolbarComponent.Student.ToolbarEditStudentFailedPanel;
import view.ToolbarComponent.Student.ToolbarEnteringMark;
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
    
    public static ActionListener getChangeToSerbianListener() {
    	return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Locale.setDefault(new Locale("sr","RS"));
				Screen.getInstance().changeLanguage();
			}
    		
    	};
    }
    
    public static ActionListener getChangeToUsListener() {
    	return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Locale.setDefault(new Locale("en","US"));
				Screen.getInstance().changeLanguage();
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
                } else if (parent instanceof ToolbarEditStudent || parent instanceof ToolbarEditProfessor || parent instanceof ToolbarEditSubject) {
                    Screen.getInstance().getStudentTab().editNewEntity((EditingScreen) parent);
                } else if (parent instanceof ToolbarEnteringMark) {
                	ToolbarEnteringMark enteringMark = (ToolbarEnteringMark) parent;
                	enteringMark.getExamController().studentTakingExam(enteringMark);
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
                } else if (parent instanceof ToolbarEditProfessor) {
                	ToolbarEditSubject dialog = (ToolbarEditSubject) parent;
                	dialog.dispose();
                } else if (parent instanceof ToolbarEnteringMark) {
                	ToolbarEnteringMark dialog = (ToolbarEnteringMark) parent;
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

    public static ActionListener getAddFailedSubjectListener(ToolbarEditStudentFailedPanel studentFailedPanel) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentFailedPanel.addFailedSubject();
            }
        };
    }
    
    public static ActionListener getAddSubjectToProfessorListener(ToolbarEditProfessorSubjectsPanel professorSubjectsPanel) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	professorSubjectsPanel.addSubject();
            }
        };
    }

    public static ActionListener openEditDialogListener() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Screen frame = Screen.getInstance();
                if (frame.getSelectedTab() == 0) {
                    if (Screen.getInstance().getStudentTab().getStudentTable().getSelectedRow() == -1) {
                        JOptionPane.showMessageDialog(null, Screen.getInstance().getResourceBundle().getString("notSelectedStudent"),
                        		Screen.getInstance().getResourceBundle().getString("editingStudentTitle"), JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    ToolbarEditStudent editDialog = new ToolbarEditStudent();
                    editDialog.setVisible();
                    return;
                }

                if (frame.getSelectedTab() == 1) {
                    if (Screen.getInstance().getStudentTab().getProfessorTable().getSelectedRow() == -1) {
                        JOptionPane.showMessageDialog(null, Screen.getInstance().getResourceBundle().getString("notSelectedProfessor"),
                        		Screen.getInstance().getResourceBundle().getString("editingProfessorTitle"), JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    ToolbarEditProfessor editDialog = new ToolbarEditProfessor();
                    editDialog.setVisible();
                    return;
                }

                if (frame.getSelectedTab() == 2) {
                    if (Screen.getInstance().getStudentTab().getSubjectTable().getSelectedRow() == -1) {
                        JOptionPane.showMessageDialog(null, Screen.getInstance().getResourceBundle().getString("notSelectedSubject"),
                        		Screen.getInstance().getResourceBundle().getString("editingSubjectTitle"), JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    new ToolbarEditSubject();
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
            	if(failedPanel.getFailedSubjectsTable().getSelectedRow() == -1) {
            		JOptionPane.showMessageDialog(null, Screen.getInstance().getResourceBundle().getString("notSelectedSubject"),
            				Screen.getInstance().getResourceBundle().getString("deletingSubjectTitle"), JOptionPane.INFORMATION_MESSAGE);
                    return;
            	}
                failedPanel.getDeleteController().deleteFailedSubject(failedPanel);
                return;
            }

        };
    }
    
    public static ActionListener getDeleteSubjectFromProfessorListener(ToolbarEditProfessorSubjectsPanel professorSubjectsPanel) {
    	return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(professorSubjectsPanel.getProfessorSubjectsTable().getSelectedRow() == -1){
					JOptionPane.showMessageDialog(null, Screen.getInstance().getResourceBundle().getString("notSelectedSubject"),
							Screen.getInstance().getResourceBundle().getString("notice"), JOptionPane.INFORMATION_MESSAGE);
                    return;
				}
				professorSubjectsPanel.setDeleteController(new DeleteSubjectFromProfessorController(professorSubjectsPanel));
                return;
			}
    		
    	};
    }
    
    public static ActionListener getButtonTakingExamListener(ToolbarEditStudentFailedPanel failedPanel) {
    	return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(failedPanel.getFailedSubjectsTable().getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, Screen.getInstance().getResourceBundle().getString("notSelectedSubject"),
							Screen.getInstance().getResourceBundle().getString("takingExam"), JOptionPane.INFORMATION_MESSAGE);
                    return;
				}
				new ToolbarEnteringMark(failedPanel);
				return;
			}
    		
    	};
    }

    public static ActionListener getDepartmentWindowListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DepartmentEditWindow();
            }
        };
    }


    public static FocusListener getAdressScreenListener() {
        return new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (!((JTextField) e.getSource()).getText().trim().equals("")) return;
                JTextField countryName = new JTextField();
                JTextField cityName = new JTextField();
                JTextField streetName = new JTextField();
                JTextField streetNumber = new JTextField();

                final JComponent[] inputs = new JComponent[]{
                        new JLabel(Screen.getInstance().getResourceBundle().getString("country")),
                        countryName,
                        new JLabel(Screen.getInstance().getResourceBundle().getString("city")),
                        cityName,
                        new JLabel(Screen.getInstance().getResourceBundle().getString("street")),
                        streetName,
                        new JLabel(Screen.getInstance().getResourceBundle().getString("streetNumber")),
                        streetNumber
                };
                String resultText = "";
                JTextField field = ((JTextField) e.getSource());
                int result = JOptionPane.showConfirmDialog(null, inputs, Screen.getInstance().getResourceBundle().getString("enterAddress"), JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION)
                    resultText = countryName.getText() + ":" + cityName.getText() + ":" + streetName.getText() + ":" + streetNumber.getText();
                else
                    resultText = Screen.getInstance().getResourceBundle().getString("addressResult");

                field.setText(resultText);
                field.getParent().requestFocus();
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        };
    }

}
