package duke;

import duke.task.Task;

import java.io.File;

import java.lang.String;

import java.util.Scanner;
import java.util.ArrayList;

import static storage.Storage.DEFAULT_STORAGE_FILEPATH;
import static ui.Ui.displayWelcomeMessage;
import static storage.Storage.loadFile;
import static parser.Parser.decideAction;

/**
 * Entry point of the Duke application.
 * Initializes the application and starts the interaction with the user.
 */
public class Duke {
    public static ArrayList<Task> tasks = new ArrayList<>();

    /**
     * Runs the program until termination whereby "bye" is input by user.
     * */
    public static void main(String[] args) {
        displayWelcomeMessage();

        // Current number of tasks in list.
        int listIndex = 0;

        File file = new File(DEFAULT_STORAGE_FILEPATH);
        listIndex = loadFile(file, listIndex);

        Scanner input = new Scanner(System.in);
        decideAction(input, listIndex);
    }
}