package duke.tasklist;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;

import duke.Duke;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import static java.util.stream.Collectors.toList;
import static duke.ui.Ui.drawLines;
import static duke.ui.Ui.printListIndex;
import static duke.ui.Ui.printOutput;

/**
 * Contains task list.
 *
 * It has operations to add/delete/find tasks in the list
 * and to process date and time input by user for task type {@code Deadline} and {@code Event}.
 */
public class TaskList extends Duke {
    /**
     * Adds a ToDO type task to the list.
     *
     * @param userInput Line that user input.
     * @param listIndex Number of tasks in list..
     * @return Updated listIndex.
     */
    public static int addToDo(String userInput, int listIndex) {
        userInput = userInput.substring(4).trim();
        Task inputDescription = new ToDo(userInput);
        tasks.add(inputDescription);
        listIndex = printOutput(listIndex);

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
        userInput = userInput.substring(5).trim();
        int byIndex = userInput.indexOf('/');
        String dateInput = userInput.substring(byIndex + 3).trim();

        if (processDateTime(dateInput).equals("error")) {
            return -1;
        } else {
            dateInput = processDateTime(dateInput);
            userInput = userInput.substring(0, byIndex - 1);
            Task inputDescription = new Event(userInput, dateInput);
            tasks.add(inputDescription);
            listIndex = printOutput(listIndex);
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
        userInput = userInput.substring(8).trim();
        int byIndex = userInput.indexOf('/');
        String dateInput = userInput.substring(byIndex + 3).trim();

        if (processDateTime(dateInput).equals("error")) {
            return -1;
        } else {
            dateInput = processDateTime(dateInput);
            userInput = userInput.substring(0, byIndex - 1);
            Task inputDescription = new Deadline(userInput, dateInput);
            tasks.add(inputDescription);
            listIndex = printOutput(listIndex);
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
        if (indexOfT == -1) {
            return "error";
        }

        String dateInput = dateTimeInput.substring(0, indexOfT);
        String timeInput = dateTimeInput.substring(indexOfT + 1);
        int time = Integer.parseInt(timeInput);

        try {
            LocalDate data = LocalDate.parse(dateInput);
            String day = data.getDayOfMonth() + " ";
            String month = data.getMonth() + " ";
            String year = data.getYear() + ", ";
            if (time < 0000 || time >= 2400) {
                return "error";
            } else if (time%100 > 60) {
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
