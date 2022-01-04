package view.EditCustomComponents;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import view.Screen;

public class FailedSubjectsButtons extends JPanel {
	private JButton buttonAdd;
	private JButton buttonDelete;
	private JButton buttonTakingExam;

	public FailedSubjectsButtons() {
		super();
		setMaximumSize(new Dimension(330, 600));
		BoxLayout layout = new BoxLayout(this, BoxLayout.X_AXIS);
		setLayout(layout);

		buttonAdd = new JButton(Screen.getInstance().getResourceBundle().getString("add"));
		buttonDelete = new JButton(Screen.getInstance().getResourceBundle().getString("itemDelete"));
		buttonTakingExam = new JButton(Screen.getInstance().getResourceBundle().getString("takingExam"));

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
