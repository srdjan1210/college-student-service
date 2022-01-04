package view.ToolbarComponent.Subject;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;

import controller.EditingStudentController;
import controller.EditingSubjectController;
import model.Student;
import model.Subject;
import model.Database.DataModel;
import utils.Constants;
import view.EditCustomComponents.AddDeleteButtons;
import view.EditCustomComponents.ErrorAddDelPanel;
import view.ListenerHandler;
import view.Screen;
import view.ToolbarComponent.EditingScreen;
import view.ToolbarComponent.ToolbarCustomComponents.ErrorMessageLabel;
import view.ToolbarComponent.ToolbarCustomComponents.PanelFieldError;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarEnterExitPanel;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarWinCombo;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarWinLabel;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarWinTxtField;

public class ToolbarEditSubject extends EditingScreen {
	private String[] labelNames = Constants.getSubjectLabelNames();
	private String[] years = Constants.yearsLabels;
	private String[] semester = Constants.semesterValues;
	private ArrayList<ToolbarWinLabel> labelReferences;
	private Vector<JComponent> fieldsReferences;
	private ToolbarEnterExitPanel enterExit;
	private ErrorAddDelPanel addRemovePanel;

	public ToolbarEditSubject() {
		super();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle(Screen.getInstance().getResourceBundle().getString("editingSubjectTitle"));
		setSize(new Dimension(Constants.SCREEN_WIDTH * 2 / 5, Constants.SCREEN_HEIGHT * 3 / 4));
		setLocationRelativeTo(null);
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
		setVisible(false);
		fieldsReferences = new Vector<>();
		labelReferences = new ArrayList<>();
		String subjectIndex = Screen.getInstance().getStudentTab().getSelectedSubjectId();
		DataModel model = DataModel.getInstance();
		Subject subject = model.getSubjectById(subjectIndex);
		String subjectData[] = EditingSubjectController.findSubjectDataForFields(subject);
		

		for(int i = 0; i < labelNames.length; i++) {
			String name = labelNames[i];
			if(i <= 1 || i==4) 
				add(createOneItem(name, "Text", subjectData[i]));
			else if(i == 2) 
				add(createOneItem(name, "ComboSemester", subjectData[i]));
			else if(i == 5)
				add(createOneItem(name, "ComboYears", subjectData[i]));
			else
				add(createOneItem(name, "Professor", subjectData[i]));
		}
		enterExit = new ToolbarEnterExitPanel();
		enterExit.getButtonConfirm().setEnabled(true);
		add(enterExit);
		switchAddDeleteButtons();
		setVisible(true);
	}
	
	public void setLabelNames(String[] labelNames) {
		this.labelNames = labelNames;
	}

	public void setYears(String[] years) {
		this.years = years;
	}

	public void setSemester(String[] semester) {
		this.semester = semester;
	}

	public void setLabelReferences(ArrayList<ToolbarWinLabel> labelReferences) {
		this.labelReferences = labelReferences;
	}

	public void setFieldsReferences(Vector<JComponent> fieldsReferences) {
		this.fieldsReferences = fieldsReferences;
	}

	public JPanel createOneItem(String labelName, String itemType, String subjectData) {
		JPanel panel = new JPanel();
		ToolbarWinLabel lbl = new ToolbarWinLabel(labelName);
		labelReferences.add(lbl);
		if(itemType.equals("Professor")) panel.add(Box.createHorizontalStrut(75));
		panel.add(lbl);
		
		if(itemType.equals("Text")) {
			ToolbarWinTxtField field = new ToolbarWinTxtField(labelName);
			JTextField fieldTxt =(JTextField) field;
			fieldTxt.setText(subjectData);
			PanelFieldError errPanel = new PanelFieldError(field, new ErrorMessageLabel("", field.getPreferredSize().width, 20));
			panel.add(errPanel);
			fieldsReferences.add(field);
		}
		else if(itemType.equals("ComboSemester")) {
			ToolbarWinCombo combo = new ToolbarWinCombo(semester);
			combo.setSelectedItem(subjectData);
			fieldsReferences.add(combo);
			panel.add(fieldsReferences.get(fieldsReferences.size() - 1));
		}
		else if(itemType.equals("ComboYears")) {
			ToolbarWinCombo combo = new ToolbarWinCombo(years);
			combo.setSelectedItem(subjectData);
			fieldsReferences.add(combo);
			panel.add(fieldsReferences.get(fieldsReferences.size() - 1));
		}
		else if(itemType.equals("Professor")) {
			ToolbarWinTxtField field = new ToolbarWinTxtField(labelName);
			JTextField fieldTxt =(JTextField) field;
			fieldTxt.setText(subjectData);
			addRemovePanel = new ErrorAddDelPanel(field, new ErrorMessageLabel("", field.getPreferredSize().width, 20));
			panel.add(addRemovePanel);
			fieldsReferences.add(field);
		}
		return panel;
	}
	
	public void setVisible() {
		setVisible();
	}

	public void switchAddDeleteButtons() {
		JTextField profTxt = (JTextField) fieldsReferences.get(3);
		if(profTxt.getText().trim().equals("")) {
			addRemovePanel.setEmptyFieldCase();
		} else {
			addRemovePanel.setFullFieldCase();
		}
	}
	
	public void setTextField(int index,String text) {
		JTextField field =(JTextField) fieldsReferences.get(index);
		field.setText(text);
	}
	
	@Override
	public JTextField getTextField(int index) {
		// TODO Auto-generated method stub
		return (JTextField) fieldsReferences.get(index);
	}

	@Override
	public JComboBox getComboBox(int index) {
		// TODO Auto-generated method stub
		return (JComboBox) fieldsReferences.get(index);
	}

	@Override
	public Vector<JComponent> getFieldsReferences() {
		// TODO Auto-generated method stub
		return fieldsReferences;
	}

	@Override
	public ToolbarEnterExitPanel getEnterExit() {
		// TODO Auto-generated method stub
		return enterExit;
	}
	
	public ArrayList<ToolbarWinLabel> getLabelReferences() {
		return labelReferences;
	}

}
