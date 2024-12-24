import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String directoryPath = "C:/projectManyFiles/src/resources";
        String content = "test=test\n" +
                "yeah=there will be 1000 of files\n" +
                "blablabla=blablabla\n";

        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        for (int i = 1; i <= 10000; i++) {
            String fileName = "test" + i + ".properties";
            File file = new File(directoryPath, fileName);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(content);
            } catch (IOException e) {
                System.err.println("Error during file creation " + fileName + ": " + e.getMessage());
            }
        }

        System.out.println("Files were successfully created in " + directoryPath);
    }
}
