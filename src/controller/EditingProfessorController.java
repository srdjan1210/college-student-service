package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import interfaces.IEditingController;
import model.Address;
import model.Database.DataModel;
import model.Professor;
import view.Screen;
import view.ToolbarComponent.EditingScreen;

public class EditingProfessorController implements IEditingController {

	@Override
	public void editEntity(EditingScreen dialog) {
		// TODO Auto-generated method stub
		if(checkIfFieldsIsEmpty(dialog)) {
			String professorIdBeforeEdit = Screen.getInstance().getStudentTab().getSelectedProfessorId();
			
			Professor professor = getEditedProfessor(dialog);
			DataModel model = DataModel.getInstance();
			model.setEditedProfessor(professorIdBeforeEdit, professor);
			JOptionPane.showMessageDialog(dialog, "Informacije o profesoru uspesno izmenjene!");
			dialog.dispose();
		}
		else {
			JOptionPane.showMessageDialog(dialog, "Polja ne smiju biti prazna!");
		}
		
	}
//	String lastName, String firstName, LocalDate birthDay, Address address, String phoneNumber,
//    String emailAddress, Address officeAddress, String idNumber, String title, int workingYears
	public Professor getEditedProfessor(EditingScreen dialog) {
		String firstName = dialog.getTextField(0).getText();
		String lastName = dialog.getTextField(1).getText();
		LocalDate birthDate = LocalDate.parse(dialog.getTextField(2).getText());
		Address address = createAddressFromAddressString(dialog.getTextField(3).getText());
		String phoneNum = dialog.getTextField(4).getText();
		String email = dialog.getTextField(5).getText();
		Address officeAddress = createAddressFromAddressString(dialog.getTextField(6).getText());
		String idNumber = dialog.getTextField(7).getText();
		String title = dialog.getTextField(8).getText();
		int workingYears = Integer.parseInt(dialog.getTextField(9).getText());
		return new Professor(lastName,firstName,birthDate,address,phoneNum,email,officeAddress,idNumber,title,workingYears);
	}
	
	public Address createAddressFromAddressString(String addressString) {
        String[] addressParts = addressString.split("-");
        return new Address(addressParts[0], Integer.parseInt(addressParts[1]), addressParts[2], addressParts[3]);
    }
	
	public boolean checkIfFieldsIsEmpty(EditingScreen dialog) {
		Vector<JComponent> fields = dialog.getFieldsReferences();
		for(int i=0;i<fields.size()-2;i++) {
			JTextField textField = (JTextField)fields.get(i);
			if(textField.getText().trim().equals(""))
				return false;
		}
		return true;
	}
	
	
	
	public static String[] findProfessorDataForFields(Professor professor) {
		String data[] = { "", "", "", "", "", "", "", "", "", "" };
		data[0] = professor.getFirstName();
		data[1] = professor.getLastName();
		data[2] = professor.getBirthDay().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		data[3] = addressToString(professor.getAddress());
		data[4] = professor.getPhoneNumber();
		data[5] = professor.getEmailAddress();
		data[6] = addressToString(professor.getOfficeAddress());
		data[7] = professor.getIdNumber();
		data[8] = professor.getTitle();
		data[9] = Integer.toString(professor.getWorkingYears());
		return data;
	}
	
	public static String addressToString(Address address) {
		String data = "";
		data = address.getStreet() + "-" + Integer.toString(address.getStreetNumber()) + "-" + address.getCity() + "-"
				+ address.getCountry();
		return data;
	}
	

}
