package model.Database;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataWriter {
    public DataWriter() { }
    public void writeEntitiesToFile(String path, ArrayList<?> list) {
        File file = new File(path);
        try (BufferedWriter myWriter = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < list.size(); i++) {
                Object entity = list.get(i);
                if (i == 0) myWriter.write(entity.toString());
                else myWriter.append(entity.toString());
                if (i != list.size() - 1) myWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
