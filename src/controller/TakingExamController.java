package controller;

import java.time.LocalDate;
import java.util.Locale;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import exceptions.InvalidFieldException;
import model.Mark;
import model.Student;
import model.Subject;
import model.Database.DataModel;
import utils.EnumConversion;
import utils.Constants.MarksValue;
import view.Screen;
import view.ToolbarComponent.Student.ToolbarEnteringMark;

public class TakingExamController{
	public TakingExamController() {
		
	}
	
	public void studentTakingExam(ToolbarEnteringMark dialog) {
		try {
			validate(dialog);
			DataModel dataModel = DataModel.getInstance();
			String subjectId = dialog.getTextField(0).getText();
			String studentIndex = Screen.getInstance().getStudentTab().getSelectedStudentIndex();
			dataModel.removeFailedSubjectFromStudentSubjects(subjectId, studentIndex);
			dataModel.addPassedSubjectToStudent(studentIndex, subjectId);
			Mark newMark = createMarkForStudent(dialog,subjectId,studentIndex);
			dataModel.addMarkToList(newMark);
			System.out.println(dataModel.getMarks());
			
			JOptionPane.showMessageDialog(dialog, Screen.getInstance().getResourceBundle().getString("takingExamSuccess"));
			dialog.dispose();
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog((JDialog) dialog, e.getMessage(), Screen.getInstance().getResourceBundle().getString("error"), JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	public Mark createMarkForStudent(ToolbarEnteringMark dialog,String subjectId,String studentId) {
			Student student = DataModel.getInstance().getStudentById(studentId);
			Subject subject = DataModel.getInstance().getSubjectById(subjectId);
			MarksValue markValue = EnumConversion.stringToMark(dialog.getComboBox(2).getSelectedItem().toString());
			LocalDate date = LocalDate.parse(dialog.getTextField(3).getText());
			return new Mark(student,subject,markValue,date);
	}
	
	public static String[] findSubjectDataForFields(Subject subject) {
		String data[] = { "", "", "", ""};
		data[0] = subject.getSubjectId();
		data[1] = subject.getSubjectName();
		return data;
	}
	
	public void printSOmething(){
		System.out.println("Something");
	}

	public void validate(ToolbarEnteringMark dialog) throws InvalidFieldException {
		// TODO Auto-generated method stub
		 EntityValidator validator = new EntityValidator();
	    	 JTextField field = dialog.getTextField(3);
	    	 if (field.getText().trim().equals(""))
                 validator.throwInvalidValidation(field, Screen.getInstance().getResourceBundle().getString("emptyField"));
	    	 if ((field.getName().toLowerCase(Locale.ROOT).contains("datum") || field.getName().toLowerCase(Locale.ROOT).contains("date"))
	    			 && !validator.isValidDate(field))
	    		 validator.throwInvalidValidation(field, Screen.getInstance().getResourceBundle().getString("dateFormat"));
	    	 validator.setEmptyMessage(field);
	     }
}
