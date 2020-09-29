package duke.tasklist;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;

import duke.Duke;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import static duke.storage.ReadFromFile.ERROR;
import static java.util.stream.Collectors.toList;
import static duke.ui.Ui.drawLines;
import static duke.ui.Ui.printListIndex;
import static duke.ui.Ui.printAddTaskToList;

/**
 * Contains task list.
 *
 * It has operations to add/delete/find tasks in the list
 * and to process date and time input by user for task type {@code Deadline} and {@code Event}.
 */
public class TaskList extends Duke {
    /** Length of the word todo */
    public static final int LENGTH_OF_WORD_TODO = 4;

    /** Length of the word event */
    public static final int LENGTH_OF_WORD_EVENT = 5;

    /** Length of the word deadline */
    public static final int LENGTH_OF_WORD_DEADLINE = 8;

    /** Length of the word line separator /at or /by */
    public static final int LENGTH_OF_DATE_TIME_SEPARATOR = 3;

    /** Number of minutes in an hour */
    public static final int MINUTES_IN_AN_HOUR = 60;

    /** Midnight in terms of the 24-hours clock */
    public static final int MIDNIGHT = 0000;

    /** The last minute before a new day starts in terms of the 24-hours clock */
    public static final int LAST_MINUTE_OF_THE_DAY = 2359;

    /** Displays hundred in integer form */
    public static final int HUNDRED = 100;

    /** Adds a space */
    public static final String SPACE = " ";

    /** Adds a comma */
    public static final String COMMA = ", ";

    /**
     * Adds a ToDO type task to the list.
     *
     * @param userInput Line that user input.
     * @param listIndex Number of tasks in list..
     * @return Updated listIndex.
     */
    public static int addToDo(String userInput, int listIndex) {
        userInput = userInput.substring(LENGTH_OF_WORD_TODO).trim();
        Task inputDescription = new ToDo(userInput);
        tasks.add(inputDescription);
        listIndex = printAddTaskToList(listIndex);

        return listIndex;
    }

    /**
     * Adds an Event type task to the list.
     * Returns updated index of list.
     * If the input by user has errors, -1 is returned.
     *
     * @param userInput Line that user input.
     * @param listIndex Number of tasks in list.
     * @return Updated listIndex if there is no error.
     */
    public static int addEvent(String userInput, int listIndex) {
        userInput = userInput.substring(LENGTH_OF_WORD_EVENT).trim();
        int byIndex = userInput.indexOf('/');
        String dateInput = userInput.substring(byIndex + LENGTH_OF_DATE_TIME_SEPARATOR).trim();

        if (processDateTime(dateInput).equals("error")) {
            return ERROR;
        } else {
            dateInput = processDateTime(dateInput);
            userInput = userInput.substring(INITIALISE, byIndex - 1);
            Task inputDescription = new Event(userInput, dateInput);
            tasks.add(inputDescription);
            listIndex = printAddTaskToList(listIndex);
        }
        return listIndex;
    }

    /**
     * Adds an Deadline type task to the list.
     * Returns updated index of list.
     * If the input by user has errors, -1 is returned.
     *
     * @param userInput Line that user input.
     * @param listIndex Number of tasks in list.
     * @return Updated listIndex if there is no error.
     */
    public static int addDeadline(String userInput, int listIndex) {
        userInput = userInput.substring(LENGTH_OF_WORD_DEADLINE).trim();
        int byIndex = userInput.indexOf('/');
        String dateInput = userInput.substring(byIndex + LENGTH_OF_DATE_TIME_SEPARATOR).trim();

        if (processDateTime(dateInput).equals("error")) {
            return ERROR;
        } else {
            dateInput = processDateTime(dateInput);
            userInput = userInput.substring(INITIALISE, byIndex - 1);
            Task inputDescription = new Deadline(userInput, dateInput);
            tasks.add(inputDescription);
            listIndex = printAddTaskToList(listIndex);
        }
        return listIndex;
    }

    /**
     * Processes the date and time input by user.
     * Returns the conversion of user input in the format e.g. 21 SEPTEMBER 2020, 1600.
     * If the input format has errors, a String "error" is returned.
     *
     * @param dateTimeInput Date and time input by user.
     * @return Date and time in the format e.g. 21 SEPTEMBER 2020, 1600.
     * @throws DateTimeException If format is inaccurate.
     */
    public static String processDateTime(String dateTimeInput) {
        int indexOfT = dateTimeInput.indexOf('t');
        if (indexOfT == ERROR) {
            return "error";
        }

        String dateInput = dateTimeInput.substring(INITIALISE, indexOfT);
        String timeInput = dateTimeInput.substring(++indexOfT);
        int time = Integer.parseInt(timeInput);

        try {
            LocalDate data = LocalDate.parse(dateInput);
            String day = data.getDayOfMonth() + SPACE;
            String month = data.getMonth() + SPACE;
            String year = data.getYear() + COMMA;
            if (time < MIDNIGHT || time > LAST_MINUTE_OF_THE_DAY) {
                return "error";
            } else if (time % HUNDRED > MINUTES_IN_AN_HOUR) {
                return "error";
            }
            String output = day + month + year + timeInput;
            return output;
        } catch (DateTimeException e) {
            return "error";
        }
    }

    /**
     * Deletes the task at index deleteListIndex of list.
     *
     * @param removeIndex Index in the list to be deleted.
     * @param listIndex Current number of tasks in list.
     * @return Updated index of list value.
     */
    public static int deleteTask(int listIndex, int removeIndex) {
        drawLines();
        System.out.println("Noted. I've removed this task:");
        System.out.println("\t" + tasks.get(--removeIndex).toString());
        tasks.remove(removeIndex);
        printListIndex(--listIndex);
        drawLines();

        return listIndex;
    }

    /**
     * Finds for tasks with description matching to filterString.
     *
     * @param filterString Keyword user wants to find in list of tasks.
     * @return Arraylist with tasks containing @param keyword.
     */
    public static ArrayList<Task> findKeyword(ArrayList<Task> tasksData, String filterString) {
        ArrayList<Task> filteredTaskList = (ArrayList<Task>) tasksData.stream()
                .filter((s) -> s.getDescription().contains(filterString))
                .collect(toList());

        return filteredTaskList;
    }
}
