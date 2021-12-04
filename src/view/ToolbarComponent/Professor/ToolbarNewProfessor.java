package view.ToolbarComponent.Professor;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;

import utils.Constants;
import view.ToolbarComponent.ToolbarCustomComponents.*;

public class ToolbarNewProfessor extends JDialog {
	
	private String[] labelNames = { "Ime*", "Prezime*", "Datum rodjenja*", "Adresa stanovanja*", "Broj telefona*",
			"E-mail adresa*", "Adresa kancelarije*", "Broj licne karte*", "Zvanje*", "Godine iskustva*" };
	private ArrayList<JComponent> fieldsReferences;
	private ArrayList<ToolbarWinLabel> labelReferences;
	private ToolbarEnterExitPanel tenex;

	public ToolbarNewProfessor() {
		super();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
		BoxLayout layout = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
		setLayout(layout);
		setTitle("Dodavanje Profesora");
		setSize(new Dimension(Constants.SCREEN_WIDTH * 2 / 5, Constants.SCREEN_HEIGHT * 3 / 4));
		setLocationRelativeTo(null);

		fieldsReferences = new ArrayList<JComponent>();
		labelReferences = new ArrayList<ToolbarWinLabel>();

		for(int i = 0; i < labelNames.length; i++) {
			String name = labelNames[i];
			add(createRow(name));
		}
		tenex = new ToolbarEnterExitPanel();
		add(tenex);
		setVisible(true);

	}
	
	private JPanel createRow(String name) {
		JPanel row = new JPanel();
		ToolbarWinLabel lbl = new ToolbarWinLabel(name);
		labelReferences.add(lbl);
		fieldsReferences.add(new ToolbarWinTxtField(name));

		row.add(lbl);
		row.add(fieldsReferences.get(fieldsReferences.size() - 1));
		return row;
	
	}

	public ArrayList<JComponent> getFieldsReferences() {
		return fieldsReferences;
	}

	public ArrayList<ToolbarWinLabel> getLabelReferences() {
		return labelReferences;
	}

	public JTextField getTextField(int index) {
		return (JTextField) fieldsReferences.get(index);
	}

	public JComboBox getComboBox(int index) {
		return (JComboBox) fieldsReferences.get(index);
	}

}
