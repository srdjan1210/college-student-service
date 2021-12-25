package view.ToolbarComponent.Student;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import view.ListenerHandler;
import utils.Constants;
import view.ToolbarComponent.AddingScreen;
import view.ToolbarComponent.ToolbarCustomComponents.*;

public class ToolbarNewStudent extends AddingScreen {
	private String[] labelNames = Constants.studentLabelNames;
	private String[] finansingWay = Constants.finansingWayLabels;
	private String[] years = Constants.yearsLabels;
	private ArrayList<ToolbarWinLabel> labelReferences;
	private ToolbarEnterExitPanel tenex;
	
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
		tenex = new ToolbarEnterExitPanel();
		add(tenex);
		setVisible(true);

	}
	
	
	
	private JPanel createRow(String name, String fieldType) {
		JPanel row = new JPanel();
		ToolbarWinLabel lbl = new ToolbarWinLabel(name);
		labelReferences.add(lbl);
		row.add(lbl);
		
		if(fieldType.equals("Text")) {
			ToolbarWinTxtField field = new ToolbarWinTxtField(name);
			PanelFieldError errPanel = new PanelFieldError(field, new ErrorMessageLabel("", field.getPreferredSize().width, 20));
			row.add(errPanel);
			fieldsReferences.add(field);
		}
		else if(fieldType.equals("ComboYears")) {
			fieldsReferences.add(new ToolbarWinCombo(years));
			row.add(fieldsReferences.get(fieldsReferences.size() - 1));
		}
		else if(fieldType.equals("ComboFinancing")) {
			fieldsReferences.add(new ToolbarWinCombo(finansingWay));
			row.add(fieldsReferences.get(fieldsReferences.size() - 1));
		}


		if(fieldsReferences.size() == 4) {
			fieldsReferences.get(3).addFocusListener(ListenerHandler.getAdressScreenListener());
		}
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

	@Override
	public ToolbarEnterExitPanel getTenex() {
		return tenex;
	}

	@Override
	public ArrayList<ToolbarWinLabel> getLabelReferences() {
		return labelReferences;
	}


}
