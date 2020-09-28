package duke;

import duke.task.Task;

import java.io.File;

import java.lang.String;

import java.util.Scanner;
import java.util.ArrayList;

import static duke.storage.Storage.DEFAULT_STORAGE_FILEPATH;
import static duke.ui.Ui.displayWelcomeMessage;
import static duke.storage.Storage.loadFile;
import static duke.parser.Parser.decideAction;

/**
 * Entry point of the Duke application.
 * Initializes the application and starts the interaction with the user.
 */
public class Duke {
    public static ArrayList<Task> tasks = new ArrayList<>();

    /** Initialises variable */
    public static final int INITIALISE = 0;

    /**
     * Runs the program until termination whereby "bye" is input by user.
     */
    public static void main(String[] args) {
        displayWelcomeMessage();

        int listIndex = INITIALISE;

        File file = new File(DEFAULT_STORAGE_FILEPATH);
        listIndex = loadFile(file, listIndex);

        Scanner input = new Scanner(System.in);
        decideAction(input, listIndex);
    }
}