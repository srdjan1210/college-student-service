package view.ToolbarComponent.Student;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

import utils.Constants;
import view.ListenerHandler;
import view.ToolbarComponent.ToolbarCustomComponents.ErrorMessageLabel;
import view.ToolbarComponent.ToolbarCustomComponents.PanelFieldError;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarEnterExitPanel;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarWinCombo;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarWinLabel;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarWinTxtField;

public class ToolbarEditStudentInfoPanel extends JPanel {
	private String[] labelNames = Constants.getStudentLabelNames();
	private String[] finansingWay = Constants.finansingWayLabels;
	private String[] yearOfStudy = Constants.yearsLabels;

	private Vector<JComponent> fieldsReferences;
	private ArrayList<ToolbarWinLabel> labelReferences;
	private ToolbarEnterExitPanel enterExit;
	public ToolbarEditStudentInfoPanel() {
		super();
		setPreferredSize(new Dimension(200, 800));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		fieldsReferences = new Vector<JComponent>();
		labelReferences = new ArrayList<>();
		
		for (int i = 0; i < 10; i++) {
			String labelName = labelNames[i];
			if (i == 8)
				add(createOneItem(labelName, "ComboYearOfStudy"));
			else if (i == 9)
				add(createOneItem(labelName, "ComboFinansingWay"));
			else
				add(createOneItem(labelName, "TextField"));
		}
		
		enterExit = new ToolbarEnterExitPanel();
		enterExit.getButtonConfirm().setEnabled(true);
		add(enterExit);
		
		setVisible(true);
	}
	
	public ToolbarEnterExitPanel getEnterExit() {
		return enterExit;
	}
	
	public JPanel createOneItem(String labelName, String itemType) {
		JPanel itemPanel = new JPanel();
		ToolbarWinLabel label = new ToolbarWinLabel(labelName);
		labelReferences.add(label);
		itemPanel.add(label);

		if (itemType.equals("ComboFinansingWay")) {
			fieldsReferences.add(new ToolbarWinCombo(finansingWay));
			itemPanel.add(fieldsReferences.get(fieldsReferences.size()-1));
		}
		else if (itemType.equals("ComboYearOfStudy")) {
			fieldsReferences.add(new ToolbarWinCombo(yearOfStudy));
			itemPanel.add(fieldsReferences.get(fieldsReferences.size()-1));
		}
		else if (itemType.equals("TextField")) {
			ToolbarWinTxtField field = new ToolbarWinTxtField(labelName);
			PanelFieldError errPanel = new PanelFieldError(field, new ErrorMessageLabel("", field.getPreferredSize().width, 20));
			itemPanel.add(errPanel);
			fieldsReferences.add(field);
		}
		
		if(fieldsReferences.size() == 4) {
			fieldsReferences.get(3).addFocusListener(ListenerHandler.getAdressScreenListener());
		}

		return itemPanel;
	}

	public JTextField getTextField(int index) {
		return (JTextField) fieldsReferences.get(index);
	}

	public void setTextField(int index, String value) {
		JTextField field = (JTextField) fieldsReferences.get(index);
		field.setText(value);
	}

	public void setComboBox(int index, String value) {
		JComboBox combo = (JComboBox) fieldsReferences.get(index);
		switch (value) {
		case "1":
			combo.setSelectedItem("1");
			break;
		case "2":
			combo.setSelectedItem("2");
			break;
		case "3":
			combo.setSelectedItem("3");
			break;
		case "4":
			combo.setSelectedItem("4");
			break;
		case "B":
			combo.setSelectedItem("Budzet");
			break;
		case "S":
			combo.setSelectedItem("Samofinansiranje");
			break;
		default:
			break;
		}
	}

	public JComboBox getComboBox(int index) {
		return (JComboBox) fieldsReferences.get(index);
	}

	public Vector<JComponent> getFieldsReferences() {
		return fieldsReferences;
	}
	
	public ArrayList<ToolbarWinLabel> getLabelReferences() {
		return labelReferences;
	}
	
}
