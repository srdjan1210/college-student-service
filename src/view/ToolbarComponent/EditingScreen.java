package view.ToolbarComponent;

import view.ToolbarComponent.ToolbarCustomComponents.ToolbarEnterExitPanel;

import javax.swing.*;
import java.util.Vector;

public abstract class EditingScreen extends JDialog {

    public abstract JTextField getTextField(int index);

    public abstract JComboBox getComboBox(int index);

    public abstract Vector<JComponent> getFieldsReferences();

    public abstract ToolbarEnterExitPanel getEnterExit();

    public void dispose() {
        super.dispose();
    }
}
