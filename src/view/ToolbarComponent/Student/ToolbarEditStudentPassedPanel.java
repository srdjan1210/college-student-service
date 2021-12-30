package view.ToolbarComponent.Student;

import model.TableModel.PassedSubjectsTableModel;
import view.EditStudentCustomComponents.PassedSubjectsButtons;
import view.TablesComponent.Tables;

import javax.swing.*;
import java.awt.*;

public class ToolbarEditStudentPassedPanel extends JPanel {
    private Tables passedSubjectsTable;

    public ToolbarEditStudentPassedPanel() {
        super();
        passedSubjectsTable = new Tables(new PassedSubjectsTableModel());
        setPreferredSize(new Dimension(200, 800));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        PassedSubjectsButtons buttons = new PassedSubjectsButtons();
        add(buttons);
        add(new JScrollPane(passedSubjectsTable));
        setVisible(true);
    }

    public Tables getPassedSubjectsTable() {
        return passedSubjectsTable;
    }
}
