package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Address;
import model.Database.DataModel;
import model.Student;
import utils.Constants;
import utils.EnumConversion;
import view.Screen;
import view.ToolbarComponent.Student.ToolbarEditStudent;
import view.ToolbarComponent.Student.ToolbarEditStudentInfo;

public class StudentEditController {
	public StudentEditController() {

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
	
	public static void editStudent(ToolbarEditStudentInfo studentInfo,ToolbarEditStudent dialog) {
		if(checkIfFieldsIsEmpty(studentInfo)) {
			String studentIndexBeforeEdit = Screen.getInstance().getStudentTab().getSelectedStudentIndex();
			Vector<JComponent> fields = studentInfo.getFieldsReferences();
			Student student = getEditedStudent(studentInfo);
			DataModel model=DataModel.getInstance();
			model.setEditedStudent(studentIndexBeforeEdit, student);
			JOptionPane.showMessageDialog(studentInfo, "Informacije o studentu uspesno izmenjene!");
			dialog.dispose();
			
		}
		else {
			JOptionPane.showMessageDialog(studentInfo, "Polja ne smiju biti prazna!");
		}
	}
	
	public static Student getEditedStudent(ToolbarEditStudentInfo studentInfo) {
		String firstName = studentInfo.getTextField(0).getText();
        String lastName = studentInfo.getTextField(1).getText();
        LocalDate birthDate = LocalDate.parse(studentInfo.getTextField(2).getText());
        Address address = createAddressFromAddressString(studentInfo.getTextField(3).getText());
        String phoneNum = studentInfo.getTextField(4).getText();
        String email = studentInfo.getTextField(5).getText();
        String indexNum = studentInfo.getTextField(6).getText();
        int startingYear = Integer.parseInt(studentInfo.getTextField(7).getText());
        int currentYear = Integer.parseInt(studentInfo.getComboBox(8).getSelectedItem().toString());
        Constants.Status financing = EnumConversion.stringToStatus(studentInfo.getComboBox(9).getSelectedItem().toString());
		return new Student(lastName, firstName, birthDate, address, phoneNum, email, indexNum, startingYear, currentYear, financing, 0);
	}
	
	public static Address createAddressFromAddressString(String addressString) {
        String[] addressParts = addressString.split("-");
        return new Address(addressParts[0], Integer.parseInt(addressParts[1]), addressParts[2], addressParts[3]);
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
