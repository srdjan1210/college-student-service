package view.ToolbarComponent.Professor;

import java.awt.Dimension;
import java.util.Vector;

import javax.swing.*;

import utils.Constants;
import view.ToolbarComponent.ToolbarCustomComponents.*;

public class ToolbarNewProfessor extends JDialog {
	
	String[] labelNames = { "Ime*", "Prezime*", "Datum rodjenja*", "Adresa stanovanja*", "Broj telefona*",
			"E-mail adresa*", "Adresa kancelarije*", "Broj licne karte*", "Zvanje*", "Godine iskustva*" };
	Vector<JComponent> fieldsReferences;
	Vector<ToolbarWinLabel> labelReferences;
	ToolbarEnterExitPanel tenex;

	public ToolbarNewProfessor() {
		super();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		BoxLayout layout = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
		setLayout(layout);
		setTitle("Dodavanje Profesora");
		setSize(new Dimension(Constants.SCREEN_WIDTH * 2 / 5, Constants.SCREEN_HEIGHT * 3 / 4));
		setLocationRelativeTo(null);
		fieldsReferences = new Vector<JComponent>();
		labelReferences = new Vector<ToolbarWinLabel>();

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
		fieldsReferences.add(new ToolbarWinTxtField());

		row.add(lbl);
		row.add(fieldsReferences.get(fieldsReferences.size() - 1));
		return row;
	
	}

	public Vector<JComponent> getFieldsReferences() {
		return fieldsReferences;
	}

	public Vector<ToolbarWinLabel> getLabelReferences() {
		return labelReferences;
	}

}
