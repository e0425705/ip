package storage;

import duke.Duke;
import duke.task.Task;

import java.io.FileWriter;

import static ui.Ui.displayWriteToFileException;

/**
 * deals with saving tasks in the file
 */
public class WriteToFile extends Duke {
    /**
     *
     */
    public static void writeToFile() {
        try {
            FileWriter fw = new FileWriter("duke.txt");
            for (Task task : tasks) {
                fw.write(task.toFileString() + System.lineSeparator());
            }
            fw.close();
        } catch (Exception e) {
            displayWriteToFileException(e);
        }
    }
}
