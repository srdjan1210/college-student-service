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
			
			JOptionPane.showMessageDialog(dialog, "Informacije o studentu uspesno izmenjene!");
			dialog.dispose();
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog((JDialog) dialog, e.getMessage(), "Greska", JOptionPane.WARNING_MESSAGE);
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
	
	public void printSOmething(){
		System.out.println("Something");
	}

	public void validate(ToolbarEnteringMark dialog) throws InvalidFieldException {
		// TODO Auto-generated method stub
		 EntityValidator validator = new EntityValidator();
	    	 JTextField field = dialog.getTextField(3);
	    	 if (field.getText().trim().equals(""))
                 validator.throwInvalidValidation(field, "Polje mora biti popunjeno!");
	    	 if (field.getName().toLowerCase(Locale.ROOT).contains("datum") && !validator.isValidDate(field))
                 validator.throwInvalidValidation(field, "<html>Format datuma treba da bude <br>GGGG-MM-DD</html>");
	    	 validator.setEmptyMessage(field);
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
