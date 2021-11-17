package view.ToolbarComponent.ToolbarCustomComponents;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolbarEnterExitPanel extends JPanel{

	private JButton buttonConfirm;
	private JButton buttonExit;
	public ToolbarEnterExitPanel() {
		super();
		BoxLayout layout = new BoxLayout(this, BoxLayout.X_AXIS);
		setLayout(layout);
		
		buttonConfirm = new JButton("Potvrdi");
		buttonExit = new JButton("Otkazi");
		add(buttonConfirm);
		add(Box.createHorizontalStrut(50));
		add(buttonExit);
	}
	
	
	public JButton getButtonConfirm() {
		return buttonConfirm; 
	}
	
	public JButton getButtonExit() {
		return buttonExit;
	}
}
