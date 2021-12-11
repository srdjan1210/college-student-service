package controller;

import view.Screen;
import view.ToolbarComponent.AddingScreen;
import view.ToolbarComponent.EditingScreen;
import view.ToolbarComponent.Professor.ToolbarNewProfessor;
import view.ToolbarComponent.Student.ToolbarEditStudent;
import view.ToolbarComponent.Student.ToolbarNewStudent;
import view.ToolbarComponent.Subject.ToolbarNewSubject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                // TODO Auto-generated method stub
                if (!Screen.getInstance().getStudentTab().getSelectedStudentIndex().equals("")) {
                    ToolbarEditStudent editDialog = new ToolbarEditStudent();
                    editDialog.setVisible();
                } else
                    JOptionPane.showMessageDialog(null, "Morate odabrati studenta kog menjate!", "InfoBox: " + "Problem sa izmenom studenta!", JOptionPane.INFORMATION_MESSAGE);

            }

        };
    }

}
