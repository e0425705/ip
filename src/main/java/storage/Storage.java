package storage;

import java.io.File;

import static storage.ReadFromFile.readFromFile;
import static storage.WriteToFile.writeToFile;

/**
 * Deals with loading tasks from the file and saving tasks in the file
 */
public class Storage {

    /** Default file path used for user */
    public static final String DEFAULT_STORAGE_FILEPATH = "duke.txt";

    /**
     * Accesses method writeToFile()
     */
    public static void saveFile() {
        writeToFile();
    }

    /**
     * Accesses method readFromFile
     *
     * @param listIndex last listing index of the task stored in "duke.txt"
     * @return listIndex so that it can be updated in Duke.main
     */
    public static int loadFile(File file, int listIndex) {
        listIndex = readFromFile(file, listIndex);

        return listIndex;
    }

}
