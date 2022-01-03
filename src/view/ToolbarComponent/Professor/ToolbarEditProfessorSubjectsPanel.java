package view.ToolbarComponent.Professor;

import model.TableModel.ProfessorSubjectsTableModel;
import view.EditCustomComponents.ProfessorSubjectsButtons;
import view.TablesComponent.Tables;

import javax.swing.*;
import java.awt.*;

public class ToolbarEditProfessorSubjectsPanel extends JPanel {
    private Tables professorSubjectsTable;
    private ProfessorSubjectsButtons professorSubjectsButtons;

    public ToolbarEditProfessorSubjectsPanel() {
        super();
        setPreferredSize(new Dimension(200, 800));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        professorSubjectsButtons = new ProfessorSubjectsButtons();
        professorSubjectsTable = new Tables(new ProfessorSubjectsTableModel());
        add(Box.createVerticalStrut(10));
        add(professorSubjectsButtons);
        add(Box.createVerticalStrut(10));
        add(new JScrollPane(professorSubjectsTable));
        setVisible(true);
    }
}
