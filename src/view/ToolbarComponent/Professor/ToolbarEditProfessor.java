package view.ToolbarComponent.Professor;

import java.awt.Dimension;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JTextField;

import utils.Constants;
import view.TabComponent.EditProfessorTab;
import view.ToolbarComponent.EditingScreen;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarEnterExitPanel;

public class ToolbarEditProfessor extends EditingScreen {
	private EditProfessorTab tab;

	public ToolbarEditProfessor() {
		// TODO Auto-generated constructor stub
		super();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Izmena profesora");
		setSize(new Dimension(Constants.SCREEN_WIDTH * 2 / 5, Constants.SCREEN_HEIGHT * 3 / 4));
		setLocationRelativeTo(null);
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
		tab = new EditProfessorTab();
		add(tab);
		add(new ToolbarEnterExitPanel());
		setVisible(false);
	}

	public EditProfessorTab getEditProfessorTab() {
		return tab;
	}

	public void setVisible() {
		setVisible(true);
	}

	@Override
	public JTextField getTextField(int index) {
		// TODO Auto-generated method stub
		return tab.getToolbarEditProfessorInfo().getTextField(index);
	}

	@Override
	public JComboBox getComboBox(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<JComponent> getFieldsReferences() {
		// TODO Auto-generated method stub
		return tab.getToolbarEditProfessorInfo().getFieldsReferences();
	}

}
