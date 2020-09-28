package duke.storage;

import duke.Duke;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static duke.ui.Ui.displayIOExceptionMessage;
import static duke.ui.Ui.displayReadFromError;
import static duke.ui.Ui.drawLines;
import static duke.ui.Ui.printListIndex;

/**
 * Decodes the duke.storage data file into {@code Task} objects.
 */
public class ReadFromFile extends Duke {
    /** Checks if the task is mark as done in duke.storage file */
    public static final String DONE = "1";

    /** Checks if the task is not mark as done in duke.storage file */
    public static final String NOT_DONE = "0";

    /** Default indicator of an error */
    public static final int ERROR = -1;

    /** Checks the task type */
    public static final int TASK_TYPE = 0;

    /** Index of where the task done is stored in duke.storage file */
    public static final int TASK_DONE = 1;

    /** Start of task description */
    public static final int TASK_DESCRIPTION = 4;

    /**
     * Creates a duke.storage file "duke.txt" if file does not exist.
     * Decodes data from duke.storage into {@code Task}.
     *
     * @param listIndex Number of tasks in list.
     * @return Updated listIndex.
     * @throws StringIndexOutOfBoundsException If there is a deviation from allowed data format.
     * @throws IOException                     If an error occurs when reading from file.
     */
    public static int readFromFile(File file, int listIndex) {
        try {
            if (file.createNewFile()) {
                System.out.println("Created new file " + file.getAbsolutePath());
                drawLines();
            } else if (!file.createNewFile()) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNext()) {
                    listIndex = readTaskTypeFromFile(listIndex, scanner);
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
     * Determines the task type of each line read from duke.storage file.
     *
     * @param listIndex Number of tasks in list.
     * @param scanner   Line of data read by scanner from duke.storage file.
     * @return Number of tasks in duke.storage file added to list.
     */
    private static int readTaskTypeFromFile(int listIndex, Scanner scanner) {
        String userInput = scanner.nextLine();
        String[] savedCommand = userInput.split(" ");
        if (savedCommand[TASK_TYPE].equals("T")) {
            if (!(readToDoFromFile(listIndex, userInput, savedCommand) == ERROR)) {
                listIndex++;
            }
        } else if (savedCommand[TASK_TYPE].equals("E")) {
            if (!(readEventFromFile(listIndex, userInput, savedCommand) == ERROR)) {
                listIndex++;
            }
        } else if (savedCommand[TASK_TYPE].equals("D")) {
            if (!(readDeadlineFromFile(listIndex, userInput, savedCommand) == ERROR)) {
                listIndex++;
            }
        } else {
            displayReadFromError();
        }
        return listIndex;
    }

    /**
     * Reads the individual attributes of {@code Deadline}.
     * Returns updated index of list.
     * If the line read from file has errors, index of list is not updated
     * and that line is not added to list.
     *
     * @param listIndex    Current index in list.
     * @param userInput    Line of data without filtering from file.
     * @param savedCommand UserInput parse into array.
     * @return ListIndex increment by 1 and with task type {@code Deadline} with attributes added to list.
     */
    private static int readDeadlineFromFile(int listIndex, String userInput, String[] savedCommand) {
        int separationIndexOfDeadline = userInput.indexOf('|');
        if (!(savedCommand[TASK_DONE].equals(NOT_DONE)) && !(savedCommand[TASK_DONE].equals(DONE))) {
            displayReadFromError();
            return ERROR;
        } else if (separationIndexOfDeadline == ERROR) {
            displayReadFromError();
            return ERROR;
        }

        String byInput = userInput.substring(separationIndexOfDeadline + 1).trim();
        userInput = userInput.substring(TASK_DESCRIPTION, separationIndexOfDeadline - 1);
        Task inputDescription = new Deadline(userInput, byInput);
        tasks.add(inputDescription);

        if (savedCommand[TASK_DONE].equals(DONE)) {
            tasks.get(listIndex).markAsDone();
        }
        System.out.println("\t" + tasks.get(listIndex++).toString());

        return listIndex;
    }

    /**
     * Reads the individual attributes of {@code Event}.
     * Returns updated index of list.
     * If the line read from file has errors, index of list is not updated
     * and that line is not added to list.
     *
     * @param listIndex    Current index in list.
     * @param userInput    Line of data without filtering from file.
     * @param savedCommand UserInput parse into array.
     * @return ListIndex increment by 1 and with task type {@code Event} with attributes added to list.
     */
    private static int readEventFromFile(int listIndex, String userInput, String[] savedCommand) {
        int separationIndexOfEvent = userInput.indexOf('|');
        if (!(savedCommand[TASK_DONE].equals(NOT_DONE)) && !(savedCommand[TASK_DONE].equals(DONE))) {
            displayReadFromError();
            return ERROR;
        } else if (separationIndexOfEvent == ERROR) {
            displayReadFromError();
            return ERROR;
        }

        String atInput = userInput.substring(separationIndexOfEvent + 1).trim();
        userInput = userInput.substring(TASK_DESCRIPTION, separationIndexOfEvent - 1);
        Task inputDescription = new Event(userInput, atInput);
        tasks.add(inputDescription);

        if (savedCommand[TASK_DONE].equals(DONE)) {
            tasks.get(listIndex).markAsDone();
        }
        System.out.println("\t" + tasks.get(listIndex++).toString());

        return listIndex;
    }

    /**
     * Reads the individual attributes of {@code ToDo}.
     * Returns updated index of list.
     * If the line read from file has errors, index of list is not updated
     * and that line is not added to list.
     *
     * @param listIndex    Current index in list.
     * @param userInput    Line of data without filtering from file.
     * @param savedCommand UserInput parse into array.
     * @return ListIndex increment by 1 and with task type {@code ToDo} with attributes added to list.
     */
    private static int readToDoFromFile(int listIndex, String userInput, String[] savedCommand) {
        if (!(savedCommand[TASK_DONE].equals(NOT_DONE)) && !(savedCommand[TASK_DONE].equals(DONE))) {
            displayReadFromError();
            return ERROR;
        }

        userInput = userInput.substring(TASK_DESCRIPTION);
        Task inputDescription = new ToDo(userInput);
        tasks.add(inputDescription);

        if (savedCommand[TASK_DONE].equals(DONE)) {
            tasks.get(listIndex).markAsDone();
        }
        System.out.println("\t" + tasks.get(listIndex++).toString());

        return listIndex;
    }

}
