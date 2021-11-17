package view.ToolbarComponent.Student;

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

public class ToolbarNewStudent extends JFrame {

	String[] labelNames = { "Ime*", "Prezime*", "Datum rodjenja*", "Adresa stanovanja*", "Broj telefona*",
			"E-mail adresa*", "Broj indeksa*", "Godina upisa*", "Trenutna godina studija*", "Nacin finansiranja" };
	String[] finansingWay = { "BUDZET", "SAMOFINANSIRANJE" };
	String[] years = { "1", "2", "3", "4" };

	Vector<JComponent> fieldsReferences;
	Vector<ToolbarWinLabel> labelReferences;
	ToolbarEnterExitBtn exEn;
	
	public ToolbarNewStudent() {
		
		super();
		BoxLayout layout = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
		setLayout(layout);
		setTitle("Dodavanje studenta");
		setSize(new Dimension(Constants.SCREEN_WIDTH * 2 / 5, Constants.SCREEN_HEIGHT * 3 / 4));
		setLocationRelativeTo(null);
		fieldsReferences = new Vector<JComponent>();
		labelReferences = new Vector<ToolbarWinLabel>();
		
		
		for(int i = 0; i < labelNames.length; i++) {
			String name = labelNames[i];
			if(i >= 9) 
				add(createRow(name, "ComboYears"));
			else if(i >= 8) 
				add(createRow(name, "ComboFinancing"));
			else
				add(createRow(name, "Text"));
		}
		exEn = new ToolbarEnterExitBtn();
		add(exEn);

		//setVisible(true);
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

	public Vector<JComponent> getFieldsReferences() {
		return fieldsReferences;
	}

	public Vector<ToolbarWinLabel> getLabelReferences() {
		return labelReferences;
	}
	
	
}
