package view.ToolbarComponent;

import view.ToolbarComponent.ToolbarCustomComponents.ToolbarEnterExitPanel;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class AddingScreen extends JDialog {

    protected ArrayList<JComponent> fieldsReferences;

    public abstract JTextField getTextField(int index);

    public abstract JComboBox getComboBox(int index);

    public abstract ArrayList<JComponent> getFieldsReferences();

    public abstract ToolbarEnterExitPanel getTenex();

    public void dispose() {
        super.dispose();
    }
}
