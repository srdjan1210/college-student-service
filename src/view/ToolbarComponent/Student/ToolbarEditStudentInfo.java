package view.ToolbarComponent.Student;

import java.awt.Dimension;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

import view.ToolbarComponent.ToolbarCustomComponents.ToolbarEnterExitPanel;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarWinCombo;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarWinLabel;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarWinTxtField;

public class ToolbarEditStudentInfo extends JPanel {
	String[] labelNames = { "Ime*", "Prezime*", "Datum rodjenja*", "Adresa stanovanja*", "Broj telefona*",
			"Email adresa*", "Broj indexa*", "Godina upisa*", "Trenutna godina studija*", "Nacin finansiranja*" };
	String[] finansingWay = { "BUDZET", "SAMOFINANSIRANJE" };
	String[] yearOfStudy = { "1", "2", "3", "4" };

	Vector<JComponent> fieldsReferences;

	public ToolbarEditStudentInfo() {
		super();
		setPreferredSize(new Dimension(200, 800));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		fieldsReferences = new Vector<JComponent>();

		for (int i = 0; i < 10; i++) {
			String labelName = labelNames[i];
			if (i == 8)
				add(createOneItem(labelName, "ComboYearOfStudy"));
			else if (i == 9)
				add(createOneItem(labelName, "ComboFinansingWay"));
			else
				add(createOneItem(labelName, "TextField"));
		}
		setVisible(true);
	}

	public JPanel createOneItem(String labelName, String itemType) {
		JPanel itemPanel = new JPanel();
		ToolbarWinLabel label = new ToolbarWinLabel(labelName);
		itemPanel.add(label);

		if (itemType.equals("ComboFinansingWay"))
			fieldsReferences.add(new ToolbarWinCombo(finansingWay));
		else if (itemType.equals("ComboYearOfStudy"))
			fieldsReferences.add(new ToolbarWinCombo(yearOfStudy));
		else if (itemType.equals("TextField"))
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
}
