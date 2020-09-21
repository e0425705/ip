package storage;

import duke.Duke;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static ui.Ui.displayIOExceptionMessage;
import static ui.Ui.drawLines;
import static ui.Ui.printListIndex;

/**
 * deals with loading tasks from the file
 */
public class ReadFromFile extends Duke {
    /**
     *
     */
    public static int readFromFile(File file, int listIndex) {
        try {
            if (file.createNewFile()) {
                System.out.println("Created new file " + file.getAbsolutePath());
                drawLines();
            } else if (!file.createNewFile()) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNext()) {
                    String userInput = scanner.nextLine();
                    String[] savedCommand = userInput.split(" ");
                    switch (savedCommand[0]) {
                    case "T": {
                        userInput = userInput.substring(4);
                        Task inputDescription = new ToDo(userInput);
                        tasks.add(inputDescription);
                        if (savedCommand[1].equals(DONE)) {
                            tasks.get(listIndex).markAsDone();
                        }
                        System.out.println("\t" + tasks.get(listIndex++).toString());
                        break;
                    }
                    case "E": {
                        int separationIndexOfEvent = userInput.indexOf('|');
                        String atInput = userInput.substring(separationIndexOfEvent + 1).trim();
                        userInput = userInput.substring(4, separationIndexOfEvent - 1);
                        Task inputDescription = new Event(userInput, atInput);
                        tasks.add(inputDescription);
                        if (savedCommand[1].equals(DONE)) {
                            tasks.get(listIndex).markAsDone();
                        }
                        System.out.println("\t" + tasks.get(listIndex++).toString());
                        break;
                    }
                    case "D": {
                        int separationIndexOfDeadline = userInput.indexOf('|');
                        String byInput = userInput.substring(separationIndexOfDeadline + 1).trim();
                        userInput = userInput.substring(4, separationIndexOfDeadline - 1);
                        Task inputDescription = new Deadline(userInput, byInput);
                        tasks.add(inputDescription);
                        if (savedCommand[1].equals(DONE)) {
                            tasks.get(listIndex).markAsDone();
                        }
                        System.out.println("\t" + tasks.get(listIndex++).toString());
                        break;
                    }
                    default:
                        System.out.println("An error has occurred!"
                                + "Do check file source is there is a corruption of data!");
                        break;
                    }
                }
                printListIndex(listIndex);
                drawLines();
            }
        } catch (IOException e) {
            displayIOExceptionMessage(e);
        }
        return listIndex;
    }
}
