package view;

import view.ToolbarComponent.Professor.ToolbarNewProfessor;
import view.ToolbarComponent.Student.ToolbarNewStudent;
import view.ToolbarComponent.Subject.ToolbarNewSubject;
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
				if(frame.getSelectedTab() == 0) {
					new ToolbarNewStudent();
					return;
				}

				if(frame.getSelectedTab() == 1) {
					new ToolbarNewProfessor();
					return;
				}

				if(frame.getSelectedTab() == 2) {
					new ToolbarNewSubject();
					return;
				}

			}
			
		};
	}

}
