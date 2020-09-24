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
import static ui.Ui.displayReadFromError;
import static ui.Ui.drawLines;
import static ui.Ui.printListIndex;

/**
 * Decodes the storage data file into {@code Task} objects.
 */
public class ReadFromFile extends Duke {
    /**
     * Creates a storage file "duke.txt" if file does not exist.
     * Decodes data from storage into {@code Task}.
     *
     * @throws StringIndexOutOfBoundsException If there is a deviation from allowed data format.
     * @throws IOException If an error occurs when reading from file.
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
                    listIndex = readTaskTypeFromFile(listIndex, userInput, savedCommand);
                }
                printListIndex(listIndex);
                drawLines();
            }
        } catch (StringIndexOutOfBoundsException e) {
            displayReadFromError();
        } catch (IOException e) {
            displayIOExceptionMessage(e);
        }
        return listIndex;
    }

    /**
     * Determines the {@code Task} type.
     *
     * @param listIndex Current index in list.
     * @param userInput Line of data without filtering from file.
     * @param savedCommand UserInput parse into array.
     * @return Updated listIndex.
     */
    private static int readTaskTypeFromFile(int listIndex, String userInput, String[] savedCommand) {
        switch (savedCommand[0]) {
        case "T": {
            listIndex = readToDoFromFile(listIndex, userInput, savedCommand);
            break;
        }
        case "E": {
            listIndex = readEventFromFile(listIndex, userInput, savedCommand);
            break;
        }
        case "D": {
            listIndex = readDeadlineFromFile(listIndex, userInput, savedCommand);
            break;
        }
        default:
            displayReadFromError();
            break;
        }
        return listIndex;
    }

    /**
     * Reads the individual attributes of {@code Deadline}.
     * Returns updated index of list.
     * If the line read from file has errors, index of list is not updated
     * and that line is not added to list.
     *
     * @param listIndex Current index in list.
     * @param userInput Line of data without filtering from file.
     * @param savedCommand UserInput parse into array.
     * @return ListIndex increment by 1 and with task type {@code Deadline} with attributes added to list.
     */
    private static int readDeadlineFromFile(int listIndex, String userInput, String[] savedCommand) {
        if (savedCommand[1].equals(DONE)) {
            tasks.get(listIndex).markAsDone();
        } else if (!(savedCommand[1].equals("0"))) {
            displayReadFromError();

            return listIndex;
        }

        int separationIndexOfDeadline = userInput.indexOf('|');
        String byInput = userInput.substring(separationIndexOfDeadline + 1).trim();
        userInput = userInput.substring(4, separationIndexOfDeadline - 1);
        Task inputDescription = new Deadline(userInput, byInput);
        tasks.add(inputDescription);

        System.out.println("\t" + tasks.get(listIndex++).toString());

        return listIndex;
    }

    /**
     * Reads the individual attributes of {@code Event}.
     * Returns updated index of list.
     * If the line read from file has errors, index of list is not updated
     * and that line is not added to list.
     *
     * @param listIndex Current index in list.
     * @param userInput Line of data without filtering from file.
     * @param savedCommand UserInput parse into array.
     * @return ListIndex increment by 1 and with task type {@code Event} with attributes added to list.
     */
    private static int readEventFromFile(int listIndex, String userInput, String[] savedCommand) {
        if (savedCommand[1].equals(DONE)) {
            tasks.get(listIndex).markAsDone();
        } else if (!savedCommand[1].equals("0")) {
            displayReadFromError();

            return listIndex;
        }

        int separationIndexOfEvent = userInput.indexOf('|');
        String atInput = userInput.substring(separationIndexOfEvent + 1).trim();
        userInput = userInput.substring(4, separationIndexOfEvent - 1);
        Task inputDescription = new Event(userInput, atInput);
        tasks.add(inputDescription);

        System.out.println("\t" + tasks.get(listIndex++).toString());

        return listIndex;
    }

    /**
     * Reads the individual attributes of {@code ToDo}.
     * Returns updated index of list.
     * If the line read from file has errors, index of list is not updated
     * and that line is not added to list.
     *
     * @param listIndex Current index in list.
     * @param userInput Line of data without filtering from file.
     * @param savedCommand UserInput parse into array.
     * @return ListIndex increment by 1 and with task type {@code ToDo} with attributes added to list.
     */
    private static int readToDoFromFile(int listIndex, String userInput, String[] savedCommand) {
        if (savedCommand[1].equals(DONE)) {
            tasks.get(listIndex).markAsDone();
        } else if (!savedCommand[1].equals("0")) {
            displayReadFromError();

            return listIndex;
        }

        userInput = userInput.substring(4);
        Task inputDescription = new ToDo(userInput);
        tasks.add(inputDescription);

        System.out.println("\t" + tasks.get(listIndex++).toString());

        return listIndex;
    }

}
