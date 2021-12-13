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

	public void writeFailedSubjectsToFile(String path, ArrayList<Subject> failedSubjects, ArrayList<Student> students) {
		File file = new File(path);
		try (BufferedWriter myWriter = new BufferedWriter(new FileWriter(file))) {
			int writeNumber = 0;
			int linesToWrite = DataModel.getInstance().getLinesOfFailedToWrite();
			for (int i = 0; i < students.size(); i++) {
				for (int j = 0; j < failedSubjects.size(); j++) {
					if (students.get(i).getFailedSubjects().contains(failedSubjects.get(j))) {
						if (writeNumber == 0) {
							System.out.println(
									students.get(i).getIndexNumber() + "," + failedSubjects.get(j).getSubjectId());
							myWriter.write(
									students.get(i).getIndexNumber() + "," + failedSubjects.get(j).getSubjectId());
							writeNumber++;
						} else {
							myWriter.append(
									students.get(i).getIndexNumber() + "," + failedSubjects.get(j).getSubjectId());
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
