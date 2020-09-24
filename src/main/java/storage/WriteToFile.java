package storage;

import duke.Duke;
import duke.task.Task;

import java.io.FileWriter;

import static storage.Storage.DEFAULT_STORAGE_FILEPATH;
import static ui.Ui.displayWriteToFileException;

/**
 * Encodes the {@code Task} objects into a data file for storage.
 */
public class WriteToFile extends Duke {
    /**
     * Encodes the {@code tasks} into a decodable and readable string representation.
     *
     * @throws Exception If an error occurs when writing to file.
     */
    public static void writeToFile() {
        try {
            FileWriter fw = new FileWriter(DEFAULT_STORAGE_FILEPATH);
            for (Task task : tasks) {
                fw.write(task.toFileString() + System.lineSeparator());
            }
            fw.close();
        } catch (Exception e) {
            displayWriteToFileException(e);
        }
    }
}
