package view.ToolbarComponent;

import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import view.ToolbarComponent.ToolbarCustomComponents.ToolbarEnterExitPanel;

public abstract class EditingScreen extends JDialog {

	public abstract JTextField getTextField(int index);

	public abstract JComboBox getComboBox(int index);

	public abstract Vector<JComponent> getFieldsReferences();
	
	public abstract ToolbarEnterExitPanel getEnterExit();

	public void dispose() {
		super.dispose();
	}
}
