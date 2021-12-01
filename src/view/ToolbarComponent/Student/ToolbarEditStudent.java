package view.ToolbarComponent.Student;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JDialog;

import utils.Constants;
import view.TabComponent.EditStudentTab;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarEnterExitPanel;

public class ToolbarEditStudent extends JDialog {
	private EditStudentTab tab;
	public ToolbarEditStudent() {
		super();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Izmena studenta");
		setSize(new Dimension(Constants.SCREEN_WIDTH * 2 / 5, Constants.SCREEN_HEIGHT * 3 / 4));
		setLocationRelativeTo(null);
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
		tab = new EditStudentTab();
		add(tab);
		add(new ToolbarEnterExitPanel());
		setVisible(false);
	}
	
	public EditStudentTab getEditStudentTab(){
		return tab;
	}

	public void setVisible() {
		setVisible(true);
	}
}
