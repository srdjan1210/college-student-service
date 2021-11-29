package view;

import view.ToolbarComponent.Professor.ToolbarNewProfessor;
import view.ToolbarComponent.Student.ToolbarNewStudent;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarIconButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ListenerHandler {
	
	public static ActionListener openWindowListener(JComponent tib) {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Screen frame = (Screen) SwingUtilities.getWindowAncestor(tib);
				System.out.println(frame.getSelectedTab());
				if(frame.getSelectedTab() == 0) {
					new ToolbarNewStudent();
					return;
				}

				if(frame.getSelectedTab() == 1) {
					new ToolbarNewProfessor();
					return;
				}

			}
			
		};
	}

}
