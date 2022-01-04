package view.ToolbarComponent.Professor;

import view.ListenerHandler;
import view.Screen;
import utils.Constants;
import view.ToolbarComponent.AddingScreen;
import view.ToolbarComponent.ToolbarCustomComponents.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ToolbarNewProfessor extends AddingScreen {
	private String[] labelNames = Constants.getProfessorLabelNames();
	private ArrayList<ToolbarWinLabel> labelReferences;
	private ToolbarEnterExitPanel tenex;

	public ToolbarNewProfessor() {
		super();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
		BoxLayout layout = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
		setLayout(layout);
		setTitle(Screen.getInstance().getResourceBundle().getString("addingProfessorTitle"));
		setSize(new Dimension(Constants.SCREEN_WIDTH * 2 / 5, Constants.SCREEN_HEIGHT * 3 / 4));
		setLocationRelativeTo(null);

		fieldsReferences = new ArrayList<JComponent>();
		labelReferences = new ArrayList<ToolbarWinLabel>();

		for (int i = 0; i < labelNames.length; i++) {
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

		ToolbarWinTxtField field = new ToolbarWinTxtField(name);
		PanelFieldError errPanel = new PanelFieldError(field, new ErrorMessageLabel("", field.getPreferredSize().width, 20));
		fieldsReferences.add(field);

		if(fieldsReferences.size() == 4) {
			fieldsReferences.get(3).addFocusListener(ListenerHandler.getAdressScreenListener());
		}
		if(fieldsReferences.size() == 7) {
			fieldsReferences.get(6).addFocusListener(ListenerHandler.getAdressScreenListener());
		}
		row.add(lbl);
		row.add(errPanel);
		//row.add(fieldsReferences.get(fieldsReferences.size() - 1));
		return row;
	}



	public ArrayList<JComponent> getFieldsReferences() {
		return fieldsReferences;
	}

	@Override
	public ToolbarEnterExitPanel getTenex() {
		return tenex;
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
