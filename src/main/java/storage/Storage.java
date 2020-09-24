package storage;

import java.io.File;

import static storage.ReadFromFile.readFromFile;
import static storage.WriteToFile.writeToFile;

/**
 * Deals with loading tasks from storage file and saving tasks in storage file.
 */
public class Storage {

    /** Default file path used for user */
    public static final String DEFAULT_STORAGE_FILEPATH = "duke.txt";

    /**
     * Accesses method writeToFile().
     */
    public static void saveFile() {
        writeToFile();
    }

    /**
     * Accesses method readFromFile.
     * Returns updated index of list so that it can be updated in Duke.main.
     *
     * @param listIndex Current number of tasks in list.
     * @return Updated listIndex.
     */
    public static int loadFile(File file, int listIndex) {
        listIndex = readFromFile(file, listIndex);

        return listIndex;
    }

}
