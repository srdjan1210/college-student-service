package view.ToolbarComponent.Student;

import controller.AddPassedSubjectController;
import model.TableModel.PassedSubjectsTableModel;
import view.EditCustomComponents.PassedExamInfoPanel;
import view.EditCustomComponents.PassedSubjectsButtons;
import view.Screen;
import view.TablesComponent.Tables;

import javax.swing.*;
import java.awt.*;

public class ToolbarEditStudentPassedPanel extends JPanel {
    private Tables passedSubjectsTable;
    private AddPassedSubjectController addPassedSubjectController;
    private PassedExamInfoPanel infoPanel;

    public ToolbarEditStudentPassedPanel(AddPassedSubjectController addPassedSubjectController) {
        super();
        this.addPassedSubjectController = addPassedSubjectController;
        passedSubjectsTable = new Tables(new PassedSubjectsTableModel());
        infoPanel = new PassedExamInfoPanel();

        setPreferredSize(new Dimension(200, 800));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        PassedSubjectsButtons buttons = new PassedSubjectsButtons(addPassedSubjectController);
        add(buttons);
        add(new JScrollPane(passedSubjectsTable));
        add(infoPanel);
        setVisible(true);
    }

    public AddPassedSubjectController getAddPassedSubjectController() {
        return addPassedSubjectController;
    }

    public void setAddPassedSubjectController(AddPassedSubjectController addPassedSubjectController) {
        this.addPassedSubjectController = addPassedSubjectController;
    }

    public Tables getPassedSubjectsTable() {
        return passedSubjectsTable;
    }

    public void setESPBAndAverage() {
        addPassedSubjectController.setESPBAndAverage(infoPanel);
    }


}
