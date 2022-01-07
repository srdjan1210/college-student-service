package view.ToolbarComponent;

import view.ToolbarComponent.ToolbarCustomComponents.ToolbarEnterExitPanel;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarWinLabel;

import javax.swing.*;
import java.util.ArrayList;

public abstract class AddingScreen extends JDialog {

    protected ArrayList<JComponent> fieldsReferences;

    public abstract JTextField getTextField(int index);

    public abstract JComboBox getComboBox(int index);

    public abstract ArrayList<JComponent> getFieldsReferences();

    public abstract ToolbarEnterExitPanel getTenex();

    public abstract ArrayList<ToolbarWinLabel> getLabelReferences();

    public void dispose() {
        super.dispose();
    }
}
