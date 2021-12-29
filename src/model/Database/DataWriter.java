package model.Database;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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
}
