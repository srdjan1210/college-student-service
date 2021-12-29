package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import exceptions.InvalidFieldException;
import interfaces.IAddingController;
import interfaces.IEditingController;
import model.Address;
import model.Student;
import model.Subject;
import model.Database.DataModel;
import utils.Constants;
import utils.EnumConversion;
import view.Screen;
import view.ToolbarComponent.EditingScreen;

public class EditingSubjectController  implements IEditingController {

	@Override
	public void editEntity(EditingScreen dialog) {
		// TODO Auto-generated method stub
		try {
			validate(dialog);
			String studentIndexBeforeEdit = Screen.getInstance().getStudentTab().getSelectedStudentIndex();
			String subjectIndexBeforeEdit = Screen.getInstance().getStudentTab().getSelectedSubjectId();
			//Subject subject = getEditedSubject(dialog);
			DataModel model = DataModel.getInstance();
			//model.setEditedStudent(studentIndexBeforeEdit, student);
			JOptionPane.showMessageDialog(dialog, "Informacije o studentu uspesno izmenjene!");
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
	//	data[3] = subject.getProfessor().getFirstName() + " " + subject.getProfessor().getLastName();	//TODO : DODATI PROFESORA KADA BUDE GOTOVO DODAVANJE PROFESORA PREDMETU
		data[3] = "";
		data[4] = Integer.toString(subject.getEspb());
		data[5] = Integer.toString(subject.getYearOfStudy());
		return data;
	}
	
	/*public Subject getEditedSubject(EditingScreen dialog) {
			String subjectId = dialog.getTextField(0).getText();
	}*/
	
	/*
	 	public Student getEditedStudent(EditingScreen dialog) {
		String firstName = dialog.getTextField(0).getText();
		String lastName = dialog.getTextField(1).getText();
		LocalDate birthDate = LocalDate.parse(dialog.getTextField(2).getText());
		Address address = createAddressFromAddressString(dialog.getTextField(3).getText());
		String phoneNum = dialog.getTextField(4).getText();
		String email = dialog.getTextField(5).getText();
		String indexNum = dialog.getTextField(6).getText();
		int startingYear = Integer.parseInt(dialog.getTextField(7).getText());
		int currentYear = Integer.parseInt(dialog.getComboBox(8).getSelectedItem().toString());
		Constants.Status financing = EnumConversion.stringToStatus(dialog.getComboBox(9).getSelectedItem().toString());
		return new Student(firstName, lastName, birthDate, address, phoneNum, email, indexNum, startingYear,
				currentYear, financing, 0);
	}
	 */

	@Override
	public void validate(EditingScreen dialog) throws InvalidFieldException {
		// TODO Auto-generated method stub
		
	}

}
