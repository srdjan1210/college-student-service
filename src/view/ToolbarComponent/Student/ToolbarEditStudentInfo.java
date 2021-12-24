package view.ToolbarComponent.Student;

import java.awt.Dimension;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controller.ListenerHandler;
import utils.Constants;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarEnterExitPanel;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarWinCombo;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarWinLabel;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarWinTxtField;

public class ToolbarEditStudentInfo extends JPanel {
	String[] labelNames = Constants.studentLabelNames;
	String[] finansingWay = Constants.finansingWayLabels;
	String[] yearOfStudy = Constants.yearsLabels;

	Vector<JComponent> fieldsReferences;
	DocumentListener myDocListener;
	ToolbarEnterExitPanel enterExit;
	JButton buttonConfirm;
	JButton buttonCancel;
	public ToolbarEditStudentInfo() {
		super();
		setPreferredSize(new Dimension(200, 800));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		fieldsReferences = new Vector<JComponent>();
		myDocListener = new MyDocListener();
		
		for (int i = 0; i < 10; i++) {
			String labelName = labelNames[i];
			if (i == 8)
				add(createOneItem(labelName, "ComboYearOfStudy",myDocListener));
			else if (i == 9)
				add(createOneItem(labelName, "ComboFinansingWay",myDocListener));
			else
				add(createOneItem(labelName, "TextField",myDocListener));
		}
		
		enterExit = new ToolbarEnterExitPanel();
		add(enterExit);
		/*buttonConfirm = new JButton("Potvrdi");
		buttonCancel = new JButton("Otkazi");

		buttonConfirm.addActionListener(ListenerHandler.getButtonConfirmListener(buttonConfirm));
		buttonCancel.addActionListener(ListenerHandler.getButtonCancelListener(buttonCancel));*/
		
	/*	JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
	    panel.add(buttonConfirm);
	    panel.add(Box.createHorizontalStrut(20));
	    panel.add(buttonCancel);
	    add(panel);*/
		
		setVisible(true);
	}
	
	public ToolbarEnterExitPanel getEnterExit() {
		return enterExit;
	}

	public void setEnterExit(ToolbarEnterExitPanel enterExit) {
		this.enterExit = enterExit;
	}

	public void addExit(ToolbarEnterExitPanel enterExit) {
		add(enterExit);
	}

	public JPanel createOneItem(String labelName, String itemType,DocumentListener docListener) {
		JPanel itemPanel = new JPanel();
		ToolbarWinLabel label = new ToolbarWinLabel(labelName);
		itemPanel.add(label);

		if (itemType.equals("ComboFinansingWay"))
			fieldsReferences.add(new ToolbarWinCombo(finansingWay));
		else if (itemType.equals("ComboYearOfStudy"))
			fieldsReferences.add(new ToolbarWinCombo(yearOfStudy));
		else if (itemType.equals("TextField")) {
			ToolbarWinTxtField field = new ToolbarWinTxtField(labelName);
			//field.getDocument().addDocumentListener(myDocListener);
			fieldsReferences.add(field);
		}

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
	
	private void checkFieldsFull()
	  {
		for(int i=0;i<8;i++) {
			JTextField field = (JTextField) fieldsReferences.get(i);
			if (field.getText().trim().isEmpty())
		      {
		        buttonConfirm.setEnabled(false);
		        return;
		      }
		}
		buttonConfirm.setEnabled(true);
	  }
	
	private class MyDocListener implements DocumentListener
	  {

		@Override
		public void insertUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			checkFieldsFull();
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			checkFieldsFull();
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			checkFieldsFull();
		}
	 
	 
	  }
}
