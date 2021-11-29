package view.ToolbarComponent.Student;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

import view.ToolbarComponent.ToolbarCustomComponents.ToolbarEnterExitPanel;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarWinCombo;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarWinLabel;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarWinTxtField;

public class ToolbarEditStudentInfo extends JPanel
{
	String[] labelNames= {"Ime*","Prezime*","Datum rodjenja*","Adresa stanovanja*","Broj telefona*","Email adresa*","Broj indexa*","Godina upisa*","Trenutna godina studija*","Nacin finansiranja*"};
	String[] finansingWay= {"Budzet","Samofinansiranje"};
	String[] yearOfStudy = {"1","2","3","4"};
	
	Vector<JComponent> fieldsReferences;
	public ToolbarEditStudentInfo() {
		super();
		setPreferredSize(new Dimension(20, 100));
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		fieldsReferences = new Vector<JComponent>();
		
		for(int i=0;i<10;i++) {
			String labelName = labelNames[i];
			if(i==8)
				add(createOneItem(labelName,"ComboYearOfStudy"));
			else if(i==9)
				add(createOneItem(labelName,"ComboFinansingWay"));
			else
				add(createOneItem(labelName,"TextField"));
		}
		add(new ToolbarEnterExitPanel());
		setVisible(true);
	}
	
	public JPanel createOneItem(String labelName,String itemType) { 
		JPanel itemPanel = new JPanel();
		ToolbarWinLabel label=new ToolbarWinLabel(labelName);
		itemPanel.add(label);
		
		if(itemType.equals("ComboFinansingWay"))
			fieldsReferences.add(new ToolbarWinCombo(finansingWay));
		else if(itemType.equals("ComboYearOfStudy"))
			fieldsReferences.add(new ToolbarWinCombo(yearOfStudy));
		else if(itemType.equals("TextField"))
			fieldsReferences.add(new ToolbarWinTxtField());
		
		itemPanel.add(fieldsReferences.get(fieldsReferences.size()-1));
		return itemPanel;
	}
}
