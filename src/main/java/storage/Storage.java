package storage;

import java.io.File;

import static storage.ReadFromFile.readFromFile;
import static storage.WriteToFile.writeToFile;

/**
 * deals with loading tasks from the file and saving tasks in the file
 */
public class Storage {
    /**
     *
     */
    public static void saveFile() {
        writeToFile();
    }

    /**
     *
     */
    public static int loadFile(File file, int listIndex) {
        listIndex = readFromFile(file, listIndex);

        return listIndex;
    }

}
