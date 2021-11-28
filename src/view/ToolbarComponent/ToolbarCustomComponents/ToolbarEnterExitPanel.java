package view.ToolbarComponent.ToolbarCustomComponents;


import controller.StudentWindowController;
import view.ToolbarComponent.Student.ToolbarNewStudent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ToolbarEnterExitPanel extends JPanel{

	private JButton buttonConfirm;
	private JButton buttonExit;
	public ToolbarEnterExitPanel() {
		super();
		BoxLayout layout = new BoxLayout(this, BoxLayout.X_AXIS);
		setLayout(layout);


		buttonConfirm = new JButton("Potvrdi");
		buttonConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//StudentWindowController.createStudentObjectFromFields((ToolbarNewStudent) buttonConfirm.getParent().getParent().getParent().getParent());
				ToolbarNewStudent dialog = (ToolbarNewStudent) SwingUtilities.getWindowAncestor(buttonConfirm);
				StudentWindowController.addNewStudent(dialog);
			}
		});
		buttonExit = new JButton("Otkazi");
		buttonExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Clicked");
				//((ToolbarNewStudent)buttonExit.getParent().getParent().getParent().getParent()).dispose();
				if(buttonExit.getParent().getParent() instanceof ToolbarNewStudent) {
					System.out.println("This his toolbar new student");
				} else {
					System.out.println(buttonExit.getParent().getParent().getParent());
				}
			}
		});;

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
