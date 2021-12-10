package controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import interfaces.IEditingController;
import model.Address;
import model.DataModel;
import model.Student;
import utils.Constants;
import utils.EnumConversion;
import view.TabComponent.Tab;
import view.TablesComponent.Tables;
import view.ToolbarComponent.EditingScreen;

public class EditingStudentController implements IEditingController {
	private Tables studentTable;

	@Override
	public void editEntity(EditingScreen dialog) {
		// TODO Auto-generated method stub
		if(checkIfFieldsIsEmpty(dialog)) {
			String studentIndexBeforeEdit = Tab.getSelectedStudentIndex();
			Vector<JComponent> fields = dialog.getFieldsReferences();
			Student student = getEditedStudent(dialog);
			DataModel model=DataModel.getInstance();
			model.setEditedStudent(studentIndexBeforeEdit, student);
			JOptionPane.showMessageDialog(dialog, "Informacije o studentu uspesno izmenjene!");
			notifyObserver(student);
			dialog.dispose();
			
		}
		else {
			JOptionPane.showMessageDialog(dialog, "Polja ne smiju biti prazna!");
		}
		
	}
	
	public static Student getEditedStudent(EditingScreen dialog) {
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
		return new Student(lastName, firstName, birthDate, address, phoneNum, email, indexNum, startingYear, currentYear, financing, 0);
	}
	
	public static Address createAddressFromAddressString(String addressString) {
        String[] addressParts = addressString.split("-");
        return new Address(addressParts[0], Integer.parseInt(addressParts[1]), addressParts[2], addressParts[3]);
    }

	public static boolean checkIfFieldsIsEmpty(EditingScreen dialog) {
		Vector<JComponent> fields = dialog.getFieldsReferences();
		for(int i=0;i<fields.size()-2;i++) {
			JTextField textField = (JTextField)fields.get(i);
			if(textField.getText().trim().equals(""))
				return false;
		}
		return true;
	}
	@Override
	public void addObserver(Tables table) {
		// TODO Auto-generated method stub
		studentTable = table;
	}
	
	public void notifyObserver(Student student) {
		String[] array = {student.getIndexNumber(), student.getFirstName(), student.getLastName(), Integer.toString(student.getStudyYear()), student.getStatus().getValue(), Double.toString(student.getAverageMark())};
        studentTable.notifyEditing(new Vector<>(Arrays.asList(array)));
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
}
