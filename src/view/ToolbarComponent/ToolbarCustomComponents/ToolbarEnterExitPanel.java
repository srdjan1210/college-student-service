package view.ToolbarComponent.ToolbarCustomComponents;


import controller.ListenerHandler;

import javax.swing.*;


public class ToolbarEnterExitPanel extends JPanel{

	private JButton buttonConfirm;
	private JButton buttonCancel;
	public ToolbarEnterExitPanel() {
		super();
		BoxLayout layout = new BoxLayout(this, BoxLayout.X_AXIS);
		setLayout(layout);


		buttonConfirm = new JButton("Potvrdi");
		buttonConfirm.setEnabled(false);
		buttonCancel = new JButton("Otkazi");

		buttonConfirm.addActionListener(ListenerHandler.getButtonConfirmListener(buttonConfirm));
		buttonCancel.addActionListener(ListenerHandler.getButtonCancelListener(buttonCancel));

		add(buttonConfirm);
		add(Box.createHorizontalStrut(50));
		add(buttonCancel);
	}
	
	
	public JButton getButtonConfirm() {
		return buttonConfirm; 
	}
	
	public JButton getButtonCancel() {
		return buttonCancel;
	}
}
