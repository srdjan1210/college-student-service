package view.ToolbarComponent.Subject;

import utils.Constants;
import view.Screen;
import view.ToolbarComponent.AddingScreen;
import view.ToolbarComponent.ToolbarCustomComponents.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ToolbarNewSubject extends AddingScreen {
    private String[] labelNames = Constants.getSubjectLabelNames();
    private String[] semesterValues = Constants.semesterValues;
    private ArrayList<ToolbarWinLabel> labelsReferences;
    private ToolbarEnterExitPanel tenex;

    public ToolbarNewSubject() {
        super();
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
        BoxLayout layout = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
        setLayout(layout);
        setTitle(Screen.getInstance().getResourceBundle().getString("addingSubjectTitle"));
        setSize(new Dimension(Constants.SCREEN_WIDTH * 2 / 5, Constants.SCREEN_HEIGHT * 3 / 4));
        setLocationRelativeTo(null);
        fieldsReferences = new ArrayList<>();
        labelsReferences = new ArrayList<>();

        for (int i = 0; i < labelNames.length; i++) {
            String labelName = labelNames[i];
            if (i == 2) {
                add(createRow(labelName, "Semester"));
                continue;
            }
            add(createRow(labelName, ""));
        }
        tenex = new ToolbarEnterExitPanel();
        add(tenex);
        setVisible(true);
    }

    private JPanel createRow(String labelName, String compType) {
        JPanel row = new JPanel();
        ToolbarWinLabel label = new ToolbarWinLabel(labelName);
        labelsReferences.add(label);
        row.add(label);

        if (compType.equals("Semester")) {
            fieldsReferences.add(new ToolbarWinCombo(semesterValues));
            row.add(fieldsReferences.get(fieldsReferences.size() - 1));
        }
        else {
            ToolbarWinTxtField field = new ToolbarWinTxtField(labelName);
            PanelFieldError errPanel = new PanelFieldError(field, new ErrorMessageLabel("", field.getPreferredSize().width, 20));
            row.add(errPanel);
            fieldsReferences.add(field);
        }




        return row;
    }

    public JTextField getTextField(int index) {
        return (JTextField) fieldsReferences.get(index);
    }

    public JComboBox getComboBox(int index) {
        return (JComboBox) fieldsReferences.get(index);
    }

    public ArrayList<JComponent> getFieldsReferences() {
        return fieldsReferences;
    }

    @Override
    public ToolbarEnterExitPanel getTenex() {
        return tenex;
    }

    @Override
    public ArrayList<ToolbarWinLabel> getLabelReferences() {
        return labelsReferences;
    }


}
