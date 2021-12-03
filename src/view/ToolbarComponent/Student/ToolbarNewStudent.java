package view.ToolbarComponent.Student;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;

import utils.Constants;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarEnterExitPanel;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarWinCombo;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarWinLabel;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarWinTxtField;

public class ToolbarNewStudent extends JDialog {

	private String[] labelNames = { "Ime*", "Prezime*", "Datum rodjenja*", "Adresa stanovanja*", "Broj telefona*",
			"E-mail adresa*", "Broj indeksa*", "Godina upisa*", "Trenutna godina studija*", "Nacin finansiranja" };
	private String[] finansingWay = { "B", "S" };
	private String[] years = { "1", "2", "3", "4" };

	private ArrayList<JComponent> fieldsReferences;
	private ArrayList<ToolbarWinLabel> labelReferences;
	
	public ToolbarNewStudent() {
		super();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
		BoxLayout layout = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
		setLayout(layout);
		setTitle("Dodavanje studenta");
		setSize(new Dimension(Constants.SCREEN_WIDTH * 2 / 5, Constants.SCREEN_HEIGHT * 3 / 4));
		setLocationRelativeTo(null);
		fieldsReferences = new ArrayList<>();
		labelReferences = new ArrayList<>();
		
		
		for(int i = 0; i < labelNames.length; i++) {
			String name = labelNames[i];
			if(i >= 9) 
				add(createRow(name, "ComboFinancing"));
			else if(i >= 8) 
				add(createRow(name, "ComboYears"));
			else
				add(createRow(name, "Text"));
		}
		add(new ToolbarEnterExitPanel());
		setVisible(true);
	}
	
	
	
	private JPanel createRow(String name, String fieldType) {
		JPanel row = new JPanel();
		ToolbarWinLabel lbl = new ToolbarWinLabel(name);
		labelReferences.add(lbl);
		row.add(lbl);
		
		if(fieldType.equals("Text"))
			fieldsReferences.add(new ToolbarWinTxtField());
		else if(fieldType.equals("ComboYears")) 
			fieldsReferences.add(new ToolbarWinCombo(years));
		else if(fieldType.equals("ComboFinancing")) 
			fieldsReferences.add(new ToolbarWinCombo(finansingWay));
		
		row.add(fieldsReferences.get(fieldsReferences.size() - 1));
		return row;
	
	}

	public JTextField getTextField(int index) {
		return (JTextField) fieldsReferences.get(index);
	}

	public JComboBox getComboBox(int index) {
		return (JComboBox) fieldsReferences.get(index);
	}

	public ArrayList<JComponent> getFieldsReferences() {
		return fieldsReferences;
	}
}
