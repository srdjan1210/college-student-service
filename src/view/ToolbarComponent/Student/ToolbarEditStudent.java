package view.ToolbarComponent.Student;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JDialog;

import utils.Constants;
import view.TabComponent.EditStudentTab;

public class ToolbarEditStudent extends JDialog {
	public ToolbarEditStudent() {
		super();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Izmena studenta");
		setSize(new Dimension(Constants.SCREEN_WIDTH * 2 / 5, Constants.SCREEN_HEIGHT * 3 / 4));
		setLocationRelativeTo(null);
		setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
		setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
		EditStudentTab tab=new EditStudentTab();
		add(tab);
		setVisible(false);
	}
	public void setVisible() {
		setVisible(true);
	}
}
