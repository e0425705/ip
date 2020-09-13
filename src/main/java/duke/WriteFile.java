package duke;

import java.io.FileWriter;
import java.io.IOException;

public class WriteFile extends Duke {
    private static void appendToFile(String filePath, String textToAppend) throws IOException {
        FileWriter fw = new FileWriter(filePath, true); // create a FileWriter in append mode
        fw.write(textToAppend);
        fw.close();
    }

    public static void main(String[] args) {
        String filePath = "duke.txt";
        try {
            for (int i = 0; i < tasks.size(); i++) {
                appendToFile(filePath, tasks.get(i).toFileString() + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
