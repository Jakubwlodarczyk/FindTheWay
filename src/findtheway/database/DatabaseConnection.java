package findtheway.database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class DatabaseConnection {

    private String pathToFile = "src/findtheway/database/info.txt";

    public void createFile() {
        Path path = Paths.get(pathToFile);
        try {
            Files.createFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteFile() {
        Path fileToDeletePath = Paths.get(pathToFile);
        try {
            Files.delete(fileToDeletePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addTextToFile(String text) {
        text = text + "\n";
        try {
            Files.write(Paths.get(pathToFile), text.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
