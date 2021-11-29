package view.ToolbarComponent.Subject;

import utils.Constants;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarEnterExitPanel;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarWinCombo;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarWinLabel;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarWinTxtField;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class ToolbarNewSubject extends JDialog {
    String[] labelNames = {"Id predmeta*", "Naziv predmeta*", "Semestar*", "Profesor*", "Espb*", "Godina studija*"};
    String[] semesterValues = {"ZIMSKI", "LETNJI"};
    Vector<JComponent> fieldsReferences;

    public ToolbarNewSubject() {
        super();
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
        BoxLayout layout = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
        setLayout(layout);
        setTitle("Dodavanje Predmeta");
        setSize(new Dimension(Constants.SCREEN_WIDTH * 2 / 5, Constants.SCREEN_HEIGHT * 3 / 4));
        setLocationRelativeTo(null);
        fieldsReferences = new Vector<JComponent>();

        for(int i = 0; i < labelNames.length; i++) {
            String labelName = labelNames[i];
            if(i == 2) {
                add(createRow(labelName, "Semester"));
                continue;
            }
            add(createRow(labelName, ""));
        }
        add(new ToolbarEnterExitPanel());
        setVisible(true);
    }

    private JPanel createRow(String labelName, String compType) {
        JPanel row = new JPanel();
        ToolbarWinLabel label = new ToolbarWinLabel(labelName);
        row.add(label);

        if(compType.equals("Semester"))
            fieldsReferences.add(new ToolbarWinCombo(semesterValues));
        else
            fieldsReferences.add(new ToolbarWinTxtField());

        row.add(fieldsReferences.get(fieldsReferences.size() - 1));

        return row;
    }

    public JTextField getTextField(int index) {
        return (JTextField) fieldsReferences.get(index);
    }

    public JComboBox getComboBox(int index) {
        return (JComboBox) fieldsReferences.get(index);
    }

    public Vector<JComponent> getFieldsReferences() {
        return fieldsReferences;
    }
}
