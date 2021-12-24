package view.ToolbarComponent.ToolbarCustomComponents;

import java.awt.Dimension;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import view.Screen;
import view.TabComponent.Tab;
import view.ToolbarComponent.EditingScreen;
import view.ToolbarComponent.Student.ToolbarEditStudent;
import view.ToolbarComponent.Student.ToolbarEditStudentInfo;

public class ToolbarWinTxtField extends JTextField implements DocumentListener{
	
	
	public ToolbarWinTxtField(String name) {
		super();
		setName(name);
		this.getDocument().addDocumentListener(this);
		setPreferredSize(new Dimension(150, 30));
		
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		System.out.println("AAAAAA");
		Window parent = SwingUtilities.getWindowAncestor(this);
		if(parent instanceof EditingScreen) {
			if(getText().trim().isEmpty()) {
				((EditingScreen) parent).getEnterExit().getButtonConfirm().setEnabled(false);
				System.out.println("insertUpdate");
				return;
			}
		}
		
		
		/*for(int i=0;i<8;i++) {
			JTextField field = (JTextField) fieldsReferences.get(i);
			if (field.getText().trim().isEmpty())
		      {
		        buttonConfirm.setEnabled(false);
		        return;
		      }
		}
		buttonConfirm.setEnabled(true);*/
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		System.out.println("BBBBBB");
		Window parent = SwingUtilities.getWindowAncestor(this);
		if(parent instanceof EditingScreen) {
			if(getText().trim().isEmpty()) {
				((EditingScreen) parent).getEnterExit().getButtonConfirm().setEnabled(false);
				System.out.println("removeUpdate");
				return;
			}
		}
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		System.out.println("CCCCCC");
		Window parent = SwingUtilities.getWindowAncestor(this);
		if(parent instanceof EditingScreen) {
			if(getText().trim().isEmpty()) {
				((EditingScreen) parent).getEnterExit().getButtonConfirm().setEnabled(false);
				System.out.println("changedUpdate");
				return;
			}
		}
	}

}
