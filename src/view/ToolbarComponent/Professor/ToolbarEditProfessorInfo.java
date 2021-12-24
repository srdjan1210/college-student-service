package view.ToolbarComponent.Professor;

import java.awt.Dimension;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

import utils.Constants;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarEnterExitPanel;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarWinLabel;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarWinTxtField;

public class ToolbarEditProfessorInfo extends JPanel {
	String[] labelNames = Constants.professorLabelNames;
	Vector<JComponent> fieldsReferences;
	ToolbarEnterExitPanel enterExit;
	
	public ToolbarEnterExitPanel getEnterExit() {
		return enterExit;
	}

	public ToolbarEditProfessorInfo() {
		super();
		setPreferredSize(new Dimension(200, 800));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		fieldsReferences = new Vector<JComponent>();
		for (int i = 0; i < 10; i++) {
			String labelName = labelNames[i];
			add(createOneItem(labelName));
		}
		enterExit = new ToolbarEnterExitPanel();
		add(enterExit);
		setVisible(true);
	}

	public JPanel createOneItem(String labelName) {
		JPanel itemPanel = new JPanel();
		ToolbarWinLabel label = new ToolbarWinLabel(labelName);
		itemPanel.add(label);
		fieldsReferences.add(new ToolbarWinTxtField(labelName));
		itemPanel.add(fieldsReferences.get(fieldsReferences.size() - 1));
		return itemPanel;
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
