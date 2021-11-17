package view.ToolbarComponent.Professor;

import java.awt.Dimension;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import utils.Constants;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarEnterExitBtn;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarWinCombo;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarWinLabel;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarWinTxtField;

public class ToolbarNewProfessor extends JFrame {
	
	String[] labelNames = { "Ime*", "Prezime*", "Datum rodjenja*", "Adresa stanovanja*", "Broj telefona*",
			"E-mail adresa*", "Adresa kancelarije*", "Broj licne karte*", "Zvanje*", "Godine iskustva*" };
	Vector<JComponent> fieldsReferences;
	Vector<ToolbarWinLabel> labelReferences;
	ToolbarEnterExitBtn exEn;
	
	public ToolbarNewProfessor() {
		super();
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
		
		exEn = new ToolbarEnterExitBtn();
		add(exEn);
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
