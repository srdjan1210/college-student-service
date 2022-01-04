package view.ToolbarComponent.ToolbarCustomComponents;
import controller.DepartmentController;
import exceptions.InvalidFieldException;
import interfaces.IAddingController;
import interfaces.IEditingController;
import view.Screen;
import view.ToolbarComponent.AddingScreen;
import view.ToolbarComponent.Department.EditSingleDepartmentDialog;
import view.ToolbarComponent.EditingScreen;
import view.ToolbarComponent.Student.ToolbarEnteringMark;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controller.TakingExamController;

public class ToolbarWinTxtField extends JTextField implements DocumentListener {
	
	
	public ToolbarWinTxtField(String name) {
		super();
		setName(name);
		setPreferredSize(new Dimension(150, 30));
		this.getDocument().addDocumentListener(this);
	}
	
	public void setEdit(Boolean trueOrFalse) {
		this.setEditable(trueOrFalse);
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
		
		else if(window instanceof ToolbarEnteringMark) {
			ToolbarEnteringMark editingScreen = (ToolbarEnteringMark) window;
			TakingExamController controller = editingScreen.getExamController();
			try {
				controller.validate(editingScreen);
				editingScreen.getEnterExit().getButtonConfirm().setEnabled(true);
			}
			catch(InvalidFieldException excpetion) {
				editingScreen.getEnterExit().getButtonConfirm().setEnabled(false);
			}
		} else if (window instanceof EditSingleDepartmentDialog) {
			EditSingleDepartmentDialog editingScreen = (EditSingleDepartmentDialog) window;
			DepartmentController controller = editingScreen.getDepartmentController();
			try {
				controller.validate(editingScreen);
				editingScreen.getButtonConfirm().setEnabled(true);
			} catch(InvalidFieldException exception) {
				editingScreen.getButtonConfirm().setEnabled(false);
			}
		}
	}
}
