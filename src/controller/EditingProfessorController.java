package controller;

import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import exceptions.InvalidFieldException;
import interfaces.IEditingController;
import model.Address;
import model.Database.DataModel;
import model.Professor;
import model.Student;
import view.Screen;
import view.ToolbarComponent.EditingScreen;

public class EditingProfessorController implements IEditingController {

	@Override
	public void editEntity(EditingScreen dialog) {
		// TODO Auto-generated method stub
		
		try {
			validate(dialog);
			String professorIdBeforeEdit = Screen.getInstance().getStudentTab().getSelectedProfessorId();
			Professor professor = getEditedProfessor(dialog);
			DataModel model = DataModel.getInstance();
			model.setEditedProfessor(professorIdBeforeEdit, professor);
			JOptionPane.showMessageDialog(dialog, "Informacije o profesoru uspesno izmenjene!");
			dialog.dispose();
		}
     catch (Exception e) {
        JOptionPane.showMessageDialog((JDialog) dialog, e.getMessage(), "Greska", JOptionPane.WARNING_MESSAGE);
    }
	}

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
		return new Professor(firstName, lastName, birthDate, address, phoneNum, email, officeAddress, idNumber, title,
				workingYears);
	}

	public Address createAddressFromAddressString(String addressString) {
		String[] addressParts = addressString.split(":");
		return new Address(addressParts[2], Integer.parseInt(addressParts[3]), addressParts[1], addressParts[0]);
	}

	public boolean checkIfFieldsIsEmpty(EditingScreen dialog) {
		Vector<JComponent> fields = dialog.getFieldsReferences();
		for (int i = 0; i < fields.size() - 2; i++) {
			JTextField textField = (JTextField) fields.get(i);
			if (textField.getText().trim().equals(""))
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
		data = address.getCountry() + ":" + address.getCity() + ":" + address.getStreet() +":" + Integer.toString(address.getStreetNumber());
		return data;
	}
	
	@Override
	public void validate(EditingScreen dialog) throws InvalidFieldException {
		// TODO Auto-generated method stub
        EntityValidator validator = new EntityValidator();
        Vector<JComponent> fields = dialog.getFieldsReferences();
        for(int i=0;i<fields.size() - 2;i++) {
        	JTextField field = (JTextField) fields.get(i);
        	 if (field.getName().toLowerCase(Locale.ROOT).contains("datum") && !validator.isValidDate(field))
                 validator.throwInvalidValidation(field, "<html>Format datuma treba da bude <br>GGGG-MM-DD</html>");
        	 if (field.getText().trim().equals(""))
                 validator.throwInvalidValidation(field, "Polje mora biti popunjeno!");
             if (field.getName().toLowerCase(Locale.ROOT).contains("adresa")
                     && !field.getName().toLowerCase(Locale.ROOT).contains("e-mail")
                     && !validator.isValidAdressNumber(field))
                 validator.throwInvalidValidation(field, "Adresa nije u dobrom formatu!");
             if(!validator.isValidNumberField(field))
                 validator.throwInvalidValidation(field, "Polje treba biti broj!");
             if(field.getName().toLowerCase().contains("broj licne karte") && !validator.isValidLBOForEditing(field))
                 validator.throwInvalidValidation(field, "LBO vec zauzet!");
             validator.setEmptyMessage(field);
        }
	}

}
