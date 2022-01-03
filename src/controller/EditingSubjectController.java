package controller;

import java.util.Locale;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import exceptions.InvalidFieldException;
import interfaces.IEditingController;
import model.Professor;
import model.Subject;
import model.Database.DataModel;
import utils.Constants.Semester;
import utils.EnumConversion;
import view.Screen;
import view.ToolbarComponent.EditingScreen;

public class EditingSubjectController  implements IEditingController {

	@Override
	public void editEntity(EditingScreen dialog) {
		// TODO Auto-generated method stub
		try {
			validate(dialog);
			String subjectIndexBeforeEdit = Screen.getInstance().getStudentTab().getSelectedSubjectId();
			Subject subject = getEditedSubject(dialog);
			DataModel model = DataModel.getInstance();
			model.setEditedSubject(subjectIndexBeforeEdit, subject);
			JOptionPane.showMessageDialog(dialog, "Informacije o predmetu uspesno izmenjene!");
			dialog.dispose();
		}
     catch (Exception e) {
        JOptionPane.showMessageDialog((JDialog) dialog, e.getMessage(), "Greska", JOptionPane.WARNING_MESSAGE);
    }
	}
	
	public static String[] findSubjectDataForFields(Subject subject) {
		String data[] = { "", "", "", "", "", ""};
		data[0] = subject.getSubjectId();
		data[1] = subject.getSubjectName();
		data[2] = subject.getSemester().getValue();
		if(subject.getProfessor() != null) data[3] = subject.getProfessor().getIdNumber();
		data[4] = Integer.toString(subject.getEspb());
		data[5] = Integer.toString(subject.getYearOfStudy());
		return data;
	}
	
	public Subject getEditedSubject(EditingScreen dialog) {
		String subjectId = dialog.getTextField(0).getText();
		String subjectName = dialog.getTextField(1).getText();
		Semester semester = EnumConversion.stringToSemester(dialog.getComboBox(2).getSelectedItem().toString());
		int yearOfStudy = Integer.parseInt(dialog.getComboBox(5).getSelectedItem().toString());
		Professor professor = DataModel.getInstance().getProfessorById(dialog.getTextField(3).getText());
		int espb = Integer.parseInt(dialog.getTextField(4).getText());
		
		return new Subject(subjectId,subjectName,semester,yearOfStudy,professor,espb);
	}
	

	@Override
	public void validate(EditingScreen dialog) throws InvalidFieldException {
		// TODO Auto-generated method stub
		 EntityValidator validator = new EntityValidator();
	     Vector<JComponent> fields = dialog.getFieldsReferences();
	     for(int i=0;i<fields.size();i++) {
	    	 if(i==2 || i==3 || i==5)
	    		 continue;
	    	 JTextField field = (JTextField) fields.get(i);
	    	 if (field.getText().trim().equals(""))
	             validator.throwInvalidValidation(field, "Polje mora biti popunjeno!");
	    	 if(!validator.isValidNumberField(field))
                 validator.throwInvalidValidation(field, "Polje treba biti broj!");
	    	 validator.setEmptyMessage(field);
	    	 }
	     }
		
	}

