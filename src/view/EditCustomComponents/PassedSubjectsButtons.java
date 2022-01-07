package view.EditCustomComponents;

import controller.AddPassedSubjectController;
import model.Database.DataModel;
import model.TableModel.PassedSubjectsTableModel;
import view.Screen;
import view.TablesComponent.Tables;
import view.ToolbarComponent.Student.ToolbarEditStudentPassedPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PassedSubjectsButtons extends JPanel {
    private JButton removeFromPassed;
    private PassedSubjectsButtons reference = this;

    public PassedSubjectsButtons(AddPassedSubjectController passedSubjectController) {
        super();
        setMaximumSize(new Dimension(Screen.getInstance().getWidth(), 600));
        BoxLayout layout = new BoxLayout(this, BoxLayout.X_AXIS);
        setLayout(layout);

        removeFromPassed = new JButton(Screen.getInstance().getResourceBundle().getString("removeMark"));
        removeFromPassed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passedSubjectController.undoMark(reference);
            }
        });
        add(Box.createHorizontalStrut(20));
        add(removeFromPassed);
    }
}
