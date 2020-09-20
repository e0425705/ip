package duke;

import duke.task.Task;

import java.io.FileWriter;

public class WriteToFile extends Duke {
    public static void writeToFile() {
        try {
            FileWriter fw = new FileWriter("duke.txt");
            for (Task task : tasks) {
                fw.write(task.toFileString() + System.lineSeparator());
            }
            fw.close();
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
