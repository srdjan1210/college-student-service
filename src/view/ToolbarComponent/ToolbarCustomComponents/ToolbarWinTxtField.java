package view.ToolbarComponent.ToolbarCustomComponents;
import exceptions.InvalidFieldException;
import interfaces.IAddingController;
import interfaces.IEditingController;
import view.Screen;
import view.ToolbarComponent.AddingScreen;
import view.ToolbarComponent.EditingScreen;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ToolbarWinTxtField extends JTextField implements DocumentListener {
	
	
	public ToolbarWinTxtField(String name) {
		super();
		setName(name);
		setPreferredSize(new Dimension(150, 30));
		this.getDocument().addDocumentListener(this);
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		executeValidation();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		executeValidation();
	}

	@Override

	public void changedUpdate(DocumentEvent e) {
		executeValidation();
	}


	private void executeValidation() {
		Window window = SwingUtilities.getWindowAncestor(this);
		if(window instanceof AddingScreen) {
			AddingScreen addingScreen = (AddingScreen) window;
			IAddingController controller = Screen.getInstance().getStudentTab().getAddingController();
			try {
				controller.validate(addingScreen);
				addingScreen.getTenex().getButtonConfirm().setEnabled(true);
			} catch(InvalidFieldException exception) {
				addingScreen.getTenex().getButtonConfirm().setEnabled(false);
			}
		}
		
		else if(window instanceof EditingScreen) {
			EditingScreen editingScreen = (EditingScreen) window;
			IEditingController controller = Screen.getInstance().getStudentTab().getEditingController();
			try {
				controller.validate(editingScreen);
				editingScreen.getEnterExit().getButtonConfirm().setEnabled(true);
			} catch(InvalidFieldException exception) {
				editingScreen.getEnterExit().getButtonConfirm().setEnabled(false);
			}
		}
	}
}
