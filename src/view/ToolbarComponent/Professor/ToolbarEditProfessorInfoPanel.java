package view.ToolbarComponent.Professor;

import utils.Constants;
import view.ListenerHandler;
import view.ToolbarComponent.ToolbarCustomComponents.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

public class ToolbarEditProfessorInfoPanel extends JPanel {
    String[] labelNames = Constants.getProfessorLabelNames();
    String[] finansingWay = Constants.finansingWayLabels;
    String[] yearOfStudy = Constants.yearsLabels;

    Vector<JComponent> fieldsReferences;
    ArrayList<ToolbarWinLabel> labelReferences;
    ToolbarEnterExitPanel enterExit;

    public ToolbarEditProfessorInfoPanel() {
        super();
        setPreferredSize(new Dimension(200, 800));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        fieldsReferences = new Vector<JComponent>();
        labelReferences = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            String labelName = labelNames[i];
            add(createOneItem(labelName));
        }
        enterExit = new ToolbarEnterExitPanel();
        enterExit.getButtonConfirm().setEnabled(true);
        add(enterExit);
        setVisible(true);
    }

    public JPanel createOneItem(String labelName) {
        JPanel itemPanel = new JPanel();
        ToolbarWinLabel label = new ToolbarWinLabel(labelName);
        labelReferences.add(label);
        itemPanel.add(label);

        ToolbarWinTxtField field = new ToolbarWinTxtField(labelName);
        PanelFieldError errPanel = new PanelFieldError(field, new ErrorMessageLabel("", field.getPreferredSize().width, 20));
        itemPanel.add(errPanel);
        fieldsReferences.add(field);

        if (fieldsReferences.size() == 4) {
            fieldsReferences.get(3).addFocusListener(ListenerHandler.getAdressScreenListener());
        }
        if (fieldsReferences.size() == 7)
            fieldsReferences.get(6).addFocusListener(ListenerHandler.getAdressScreenListener());
        return itemPanel;
    }

    public ToolbarEnterExitPanel getEnterExit() {
        return enterExit;
    }

    public JTextField getTextField(int index) {
        return (JTextField) fieldsReferences.get(index);
    }

    public void setTextField(int index, String value) {
        JTextField field = (JTextField) fieldsReferences.get(index);
        field.setText(value);
    }

    public Vector<JComponent> getFieldsReferences() {
        return fieldsReferences;
    }

}
