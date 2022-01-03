package model.Database;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Database.DTOs.PassedSubject;
import model.Professor;
import model.Student;
import model.Subject;

public class DataWriter {
	public DataWriter() {
	}

	public void writeEntitiesToFile(String path, ArrayList<?> list) {
		File file = new File(path);
		try (BufferedWriter myWriter = new BufferedWriter(new FileWriter(file))) {
			for (int i = 0; i < list.size(); i++) {
				Object entity = list.get(i);
				if (i == 0)
					myWriter.write(entity.toString());
				else
					myWriter.append(entity.toString());
				if (i != list.size() - 1)
					myWriter.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeFailedSubjectsToFile(String path, ArrayList<Student> students) {
		File file = new File(path);
		try (BufferedWriter myWriter = new BufferedWriter(new FileWriter(file))) {
			int writeNumber = 0;
			int linesToWrite = DataModel.getInstance().getLinesOfFailedToWrite();
			for(Student student : DataModel.getInstance().getStudents()) {
				if(!student.getFailedSubjects().isEmpty()) {
					for(Subject failedSubject : student.getFailedSubjects()) {
						if (writeNumber == 0) {
							myWriter.write(
									student.getIndexNumber() + "," + failedSubject.getSubjectId());
							writeNumber++;
						} else {
							myWriter.append(
									student.getIndexNumber() + "," + failedSubject.getSubjectId());
							writeNumber++;
					}
						if (writeNumber != linesToWrite)
						myWriter.newLine();
				}
			}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void writePassedSubjectsToFile(String path, ArrayList<PassedSubject> subjects) {
		File file = new File(path);
		try(BufferedWriter myWriter = new BufferedWriter(new FileWriter(file))) {
			for(int i = 0; i < subjects.size(); i++) {
				PassedSubject pasSub = subjects.get(i);
				if(i == 0) myWriter.write(pasSub.toString());
				if(i != 0) myWriter.append(pasSub.toString());
				if(i != subjects.size() - 1) myWriter.newLine();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeProfessorSubjectsToFile(String path, ArrayList<Professor> professors) {
		File file = new File(path);
		try(BufferedWriter myWriter = new BufferedWriter(new FileWriter(file))){
			int writeNumber = 0;
			int linesToWrite = DataModel.getInstance().getLinesOfProfessorSubjectsToWrite();
			for(Professor professor : professors) {
				if(!professor.getSubjects().isEmpty()) {
					for(Subject subject : professor.getSubjects()) {
						if(writeNumber == 0) {
							myWriter.write(professor.getIdNumber() + "," + subject.getSubjectId());
							writeNumber++;
						} else {
							myWriter.append(professor.getIdNumber() + "," + subject.getSubjectId());
							writeNumber++;
						}
						  if(writeNumber != linesToWrite)
							  myWriter.newLine();
					}
				}
			}
			}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
