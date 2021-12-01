package controller;

import java.time.format.DateTimeFormatter;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Address;
import model.Student;
import view.ToolbarComponent.Student.ToolbarEditStudentInfo;

public class StudentEditController {
	public StudentEditController() {

	}
	public static String[] findStudentDataForFields(Student student) {
		String data[] = { "", "", "", "", "", "", "", "", "", "" };
		data[0] = student.getFirstName();
		data[1] = student.getLastName();
		data[2] = student.getBirthDay().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
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
		data = address.getStreet() + " " + Integer.toString(address.getStreetNumber()) + " " + address.getCity() + " "
				+ address.getCountry();
		return data;
	}
	
	public static void editStudent(ToolbarEditStudentInfo studentInfo) {
		if(checkIfFieldsIsEmpty(studentInfo)) {
			
		}
		else {
			JOptionPane.showMessageDialog(studentInfo, "Polja ne smiju biti prazna!");
		}
	}
	
	public static boolean checkIfFieldsIsEmpty(ToolbarEditStudentInfo studentInfo) {
		Vector<JComponent> fields = studentInfo.getFieldsReferences();
		for(int i=0;i<fields.size()-2;i++) {
			JTextField textField = (JTextField)fields.get(i);
			if(textField.getText().trim().equals(""))
				return false;
		}
		return true;
	}
	
}
