package view.EditStudentCustomComponents;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

public class FailedSubjectsButtons extends JPanel{
	private JButton buttonAdd;
	private JButton buttonDelete;
	private JButton buttonTakingExam;
	public FailedSubjectsButtons() {
		super();
		setMaximumSize(new Dimension(330, 600));
		BoxLayout layout = new BoxLayout(this, BoxLayout.X_AXIS);
		setLayout(layout);
		
		buttonAdd = new JButton("Dodaj");
		buttonDelete = new JButton("Obrisi");
		buttonTakingExam = new JButton("Polaganje");
		
		add(buttonAdd);
		add(Box.createHorizontalStrut(50));
		add(buttonDelete);
		add(Box.createHorizontalStrut(50));
		add(buttonTakingExam);
	}
	public JButton getButtonAdd() {
		return buttonAdd;
	}
	public JButton getButtonDelete() {
		return buttonDelete;
	}
	public JButton getButtonTakingExam() {
		return buttonTakingExam;
	}
	
	
}
