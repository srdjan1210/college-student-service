package view.ToolbarComponent.Student;

import controller.AddFailedSubjectController;
import controller.AddPassedSubjectController;
import controller.DeleteFailedSubjectController;
import controller.TakingExamController;
import model.Database.DataModel;
import utils.Constants;
import view.Screen;
import view.TabComponent.EditStudentTab;
import view.ToolbarComponent.EditingScreen;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarEnterExitPanel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Vector;

public class ToolbarEditStudent extends EditingScreen {
    private EditStudentTab tab;

    public ToolbarEditStudent() {
        super();
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle(Screen.getInstance().getResourceBundle().getString("editingStudentTitle"));
        setSize(new Dimension(Constants.SCREEN_WIDTH * 2 / 5, Constants.SCREEN_HEIGHT * 3 / 4));
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
        tab = new EditStudentTab(new AddPassedSubjectController(), new AddFailedSubjectController(), new DeleteFailedSubjectController(), new TakingExamController());
        tab.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                // TODO Auto-generated method stub
                if (tab.getSelectedIndex() == 0) {
                } else if (tab.getSelectedIndex() == 1) {
                    DataModel.getInstance()
                            .setEditTableObserver(tab.getToolbarEditStudentPassed().getPassedSubjectsTable());
                    DataModel.getInstance().notifyEditTable();
                    tab.getToolbarEditStudentPassed().setESPBAndAverage();
                } else if (tab.getSelectedIndex() == 2) {
                    DataModel.getInstance()
                            .setEditTableObserver(tab.getToolbarEditStudentFailed().getFailedSubjectsTable());
                    DataModel.getInstance().notifyEditTable();

                }

            }
        });
        tab.getToolbarEditStudentPassed().setESPBAndAverage();
        add(tab);
        setVisible(false);
    }

    public EditStudentTab getEditStudentTab() {
        return tab;
    }

    public void setVisible() {
        setVisible(true);
    }

    @Override
    public JTextField getTextField(int index) {
        // TODO Auto-generated method stub
        return tab.getToolbarEditStudentInfo().getTextField(index);
    }

    @Override
    public JComboBox getComboBox(int index) {
        // TODO Auto-generated method stub
        return tab.getToolbarEditStudentInfo().getComboBox(index);
    }

    public Vector<JComponent> getFieldsReferences() {
        return tab.getToolbarEditStudentInfo().getFieldsReferences();
    }

    @Override
    public ToolbarEnterExitPanel getEnterExit() {
        // TODO Auto-generated method stub
        return tab.getToolbarEditStudentInfo().getEnterExit();
    }
}
