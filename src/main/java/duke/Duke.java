package duke;

import duke.task.Task;


import java.io.File;

import java.lang.String;

import java.util.Scanner;
import java.util.ArrayList;

import static ui.Ui.displayWelcomeMessage;
import static storage.Storage.loadFile;
import static parser.Parser.decideAction;

public class Duke {
    public static final String DONE = "1";
    public static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        displayWelcomeMessage();
        int listIndex = 0;

        File file = new File("duke.txt");
        listIndex = loadFile(file, listIndex);

        Scanner input = new Scanner(System.in);
        decideAction(input, listIndex);
    }
}