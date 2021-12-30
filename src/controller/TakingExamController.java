package controller;

import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import exceptions.InvalidFieldException;
import interfaces.IEditingController;
import model.Student;
import model.Subject;
import model.Database.DataModel;
import view.Screen;
import view.ToolbarComponent.EditingScreen;
import view.ToolbarComponent.Student.ToolbarEnteringMark;

public class TakingExamController implements IEditingController{
	
	public TakingExamController(ToolbarEnteringMark enteringMark) {
		studentTakingExam(enteringMark);
	}
	
	public void studentTakingExam(EditingScreen dialog) {
		try {
			
			validate(dialog);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog((JDialog) dialog, e.getMessage(), "Greska", JOptionPane.WARNING_MESSAGE);
		}
		
		
		/*
		try {
			validate(dialog);
			String studentIndexBeforeEdit = Screen.getInstance().getStudentTab().getSelectedStudentIndex();
			Student student = getEditedStudent(dialog);
			DataModel model = DataModel.getInstance();
			model.setEditedStudent(studentIndexBeforeEdit, student);
			JOptionPane.showMessageDialog(dialog, "Informacije o studentu uspesno izmenjene!");
			dialog.dispose();
		}
     catch (Exception e) {
        JOptionPane.showMessageDialog((JDialog) dialog, e.getMessage(), "Greska", JOptionPane.WARNING_MESSAGE);
    }
		 */
	}
	
	public static String[] findSubjectDataForFields(Subject subject) {
		String data[] = { "", "", "", ""};
		data[0] = subject.getSubjectId();
		data[1] = subject.getSubjectName();
		return data;
	}
	
	/*
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
	 */

	@Override
	public void editEntity(EditingScreen dialog) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validate(EditingScreen dialog) throws InvalidFieldException {
		// TODO Auto-generated method stub
		 EntityValidator validator = new EntityValidator();
	     Vector<JComponent> fields = dialog.getFieldsReferences();
	     for(int i=0;i<fields.size();i++) {
	    	 System.out.println("BABAAAAAAA");
	    	 JTextField field = (JTextField) fields.get(i);
	    	 if (field.getName().toLowerCase(Locale.ROOT).contains("datum") && !validator.isValidDate(field)) {
	    		 System.out.println("uSAOO DATUMM");
                 validator.throwInvalidValidation(field, "<html>Format datuma treba da bude <br>GGGG-MM-DD</html>");
	    	 }
        	 
        	 if (field.getText().trim().equals(""))
                 validator.throwInvalidValidation(field, "Polje mora biti popunjeno!");
        	 validator.setEmptyMessage(field);
	     }
		
	}
	
    /*public void addNewFailedSubject() {
        String index = Screen.getInstance().getStudentTab().getSelectedStudentIndex();
        ArrayList<Subject> subjects = DataModel.getInstance().getNewSubjectsForStudent(index);
        if(subjects.size() == 0) {
            JOptionPane.showMessageDialog(null, "Nema predmeta za dodavanje!");
            return;
        }
        JList selektor = new JList(new SubjectListModel(subjects));
        selektor.setPreferredSize(new Dimension(100, 300));
        int result = JOptionPane.showConfirmDialog(null, new JScrollPane(selektor),"Izaberite predmet!", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if(result == 0) {
            if(selektor.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Niste selektovali predmet");
                return;
            }
            Subject subject = ((SubjectListModel) selektor.getModel()).getSelectedSubject(selektor.getSelectedIndex());
            DataModel.getInstance().addFailedSubjectToStudent(index, subject);
        }
    }*/
}
