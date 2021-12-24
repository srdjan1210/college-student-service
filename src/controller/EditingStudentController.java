package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;

import exceptions.InvalidFieldException;
import interfaces.IEditingController;
import model.Address;
import model.Database.DataModel;
import model.Student;
import utils.Constants;
import utils.EnumConversion;
import view.Screen;
import view.ToolbarComponent.EditingScreen;

public class EditingStudentController implements IEditingController {

	@Override
	public void editEntity(EditingScreen dialog) {
		// TODO Auto-generated method stub
		if(Screen.getInstance().getStudentTab().getStudentTable().getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Student nije selektovan!", "Izmena studenta",JOptionPane.WARNING_MESSAGE);
            return;
        }
		if (checkIfFieldsIsEmpty(dialog)) {
			String studentIndexBeforeEdit = Screen.getInstance().getStudentTab().getSelectedStudentIndex();

			Student student = getEditedStudent(dialog);
			DataModel model = DataModel.getInstance();
			model.setEditedStudent(studentIndexBeforeEdit, student);
			JOptionPane.showMessageDialog(dialog, "Informacije o studentu uspesno izmenjene!");
			dialog.dispose();

		} else {
			JOptionPane.showMessageDialog(dialog, "Polja ne smiju biti prazna!");
		}

	}

	public static String[] findStudentDataForFields(Student student) {
		String data[] = { "", "", "", "", "", "", "", "", "", "" };
		data[0] = student.getFirstName();
		data[1] = student.getLastName();
		data[2] = student.getBirthDay().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		data[3] = addressToString(student.getAddress());
		data[4] = student.getPhoneNumber();
		data[5] = student.getEmailAddress();
		data[6] = student.getIndexNumber();
		data[7] = Integer.toString(student.getEntryYear());
		data[8] = Integer.toString(student.getStudyYear());
		data[9] = student.getStatus().getValue();
		return data;
	}

	public static String addressToString(Address address) {
		String data = "";
		data = address.getStreet() + "-" + Integer.toString(address.getStreetNumber()) + "-" + address.getCity() + "-"
				+ address.getCountry();
		return data;
	}

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

	public static Address createAddressFromAddressString(String addressString) {
		String[] addressParts = addressString.split("-");
		return new Address(addressParts[0], Integer.parseInt(addressParts[1]), addressParts[2], addressParts[3]);
	}

	public static boolean checkIfFieldsIsEmpty(EditingScreen dialog) {
		Vector<JComponent> fields = dialog.getFieldsReferences();
		for (int i = 0; i < fields.size() - 2; i++) {
			JTextField textField = (JTextField) fields.get(i);
			if (textField.getText().trim().equals(""))
				return false;
		}
		return true;
	}

	@Override
	public void validate(EditingScreen dialog) throws InvalidFieldException {
		// TODO Auto-generated method stub
		Vector<JComponent> fields = dialog.getFieldsReferences();
		for(int i=0;i<fields.size() - 2;i++) {
			JTextField field = (JTextField) fields.get(i);
			if (field.getName().toLowerCase(Locale.ROOT).contains("datum") && !isValidDate(field))
				throw new InvalidFieldException("Format datuma treba da bude yyyy-MM-dd(" + field.getName() + ")");
			if (field.getText().trim().equals(""))
				throw new InvalidFieldException(field.getName() + " polje je prazno ili nevalidno!");
			if (field.getName().toLowerCase(Locale.ROOT).contains("adresa") && !field.getName().toLowerCase(Locale.ROOT).contains("e-mail") && !isValidAdressNumber(field)) {
                field.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                throw new InvalidFieldException("Adresa nije u dobrom formatu");}
		}
	}
	
	private static boolean isValidDate(JTextField dateField) throws InvalidFieldException {
		try {
			LocalDate.parse(dateField.getText());
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	private static boolean isValidAdressNumber(JTextField adressField) {
        String text = adressField.getText();
        String[] txtSpl = text.split("-");
        if (txtSpl.length != 4 ||  
        		txtSpl[0].trim().equals("") ||        		
                 txtSpl[1].trim().equals("") ||
                 txtSpl[2].trim().equals("") ||
                 txtSpl[3].trim().equals("")) {

            return  false;
        }
        try {
            Integer.parseInt(txtSpl[1]);
        } catch(Exception e) {
            return false;
        }
        return true;
    }
}
