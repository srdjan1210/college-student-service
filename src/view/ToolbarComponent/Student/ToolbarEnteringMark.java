package view.ToolbarComponent.Student;

import controller.TakingExamController;
import model.Database.DataModel;
import model.Subject;
import utils.Constants;
import view.Screen;
import view.ToolbarComponent.ToolbarCustomComponents.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

public class ToolbarEnteringMark extends JDialog {

    private String[] labelNames = Constants.getTakingExamLabelNames();
    private String[] markValue = Constants.marksLabels;
    private String[] subjectData;
    private ArrayList<ToolbarWinLabel> labelReferences;
    private Vector<JComponent> fieldsReferences;
    private ToolbarEnterExitPanel enterExit;
    private ToolbarEditStudentFailedPanel failedSubjectsPanel;

    public TakingExamController getExamController() {
        return failedSubjectsPanel.getExamController();

    }


    public ToolbarEnteringMark(ToolbarEditStudentFailedPanel failedPanel) {
        super();
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle(Screen.getInstance().getResourceBundle().getString("takingExamTitle"));
        setSize(new Dimension(Constants.SCREEN_WIDTH * 2 / 8, Constants.SCREEN_HEIGHT * 3 / 6));
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
        fieldsReferences = new Vector<>();
        labelReferences = new ArrayList<>();
        failedSubjectsPanel = failedPanel;
        String failedSubjectIndex = failedSubjectsPanel.getSelectedSubjectId();
        Subject subject = DataModel.getInstance().getSubjectById(failedSubjectIndex);
        String subjectData[] = TakingExamController.findSubjectDataForFields(subject);
        for (int i = 0; i < 4; i++) {
            String labelName = labelNames[i];
            if (i < 2) {
                add(createOneItem(labelName, "ProtectedTextField", subjectData[i]));
            } else if (i == 2)
                add(createOneItem(labelName, "ComboBox", ""));
            else
                add(createOneItem(labelName, "Date", ""));
        }

        enterExit = new ToolbarEnterExitPanel();
        add(enterExit);
        setVisible(true);

    }

    public JPanel createOneItem(String labelName, String itemType, String subjectData) {
        JPanel itemPanel = new JPanel();
        ToolbarWinLabel label = new ToolbarWinLabel(labelName);
        labelReferences.add(label);
        itemPanel.add(label);

        if (itemType.equals("ProtectedTextField")) {
            ToolbarWinTxtField field = new ToolbarWinTxtField(labelName);
            field.setText(subjectData);
            field.setEdit(false);
            PanelFieldError errPanel = new PanelFieldError(field, new ErrorMessageLabel("", field.getPreferredSize().width, 20));
            itemPanel.add(errPanel);
            fieldsReferences.add(field);
        } else if (itemType.equals("ComboBox")) {
            fieldsReferences.add(new ToolbarWinCombo(markValue));
            itemPanel.add(fieldsReferences.get(fieldsReferences.size() - 1));
        } else if (itemType.equals("Date")) {
            ToolbarWinTxtField field = new ToolbarWinTxtField(labelName);
            field.setText("");
            PanelFieldError errPanel = new PanelFieldError(field, new ErrorMessageLabel("", field.getPreferredSize().width, 20));
            itemPanel.add(errPanel);
            fieldsReferences.add(field);
        }
        return itemPanel;
    }

    public JTextField getTextField(int index) {
        // TODO Auto-generated method stub
        return (JTextField) fieldsReferences.get(index);
    }

    public JComboBox getComboBox(int index) {
        // TODO Auto-generated method stub
        return (JComboBox) fieldsReferences.get(index);
    }

    public Vector<JComponent> getFieldsReferences() {
        // TODO Auto-generated method stub
        return fieldsReferences;
    }

    public ArrayList<ToolbarWinLabel> getLabelReferences() {
        return labelReferences;
    }

    public ToolbarEnterExitPanel getEnterExit() {
        // TODO Auto-generated method stub
        return enterExit;
    }

}
