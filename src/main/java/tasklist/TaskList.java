package tasklist;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;

import duke.Duke;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import static java.util.stream.Collectors.toList;
import static ui.Ui.drawLines;
import static ui.Ui.printListIndex;
import static ui.Ui.printOutput;

/**
 * contains the task list e.g., it has operations to add/delete/find tasks in the list
 * and processes the date and time input by user
 */
public class TaskList extends Duke {
    /**
     *
     */
    public static int addToDo(String userInput, int listIndex) {
        userInput = userInput.substring(4).trim();
        Task inputDescription = new ToDo(userInput);
        tasks.add(inputDescription);
        listIndex = printOutput(listIndex);

        return listIndex;
    }

    /**
     *
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
     *
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

    /** */
    public static String processDateTime(String dateTimeInput) {
        int indexOfT = dateTimeInput.indexOf('t');
        if (indexOfT == -1) {
            return "error";
        }
        String dateInput = dateTimeInput.substring(0, indexOfT);
        String timeInput = dateTimeInput.substring(indexOfT + 1);
        int time = Integer.parseInt(timeInput);
        try{
            LocalDate data = LocalDate.parse(dateInput);
            String day = data.getDayOfMonth() + " ";
            String month = data.getMonth() + " ";
            String year = data.getYear() + ", ";
            if(time < 0000 || time > 2400) {
                return "error";
            }
            String output = day + month + year + timeInput;

            return output;
        } catch (DateTimeException e) {
            return "error";
        }
    }

    /**
     *
     */
    public static int deleteTask(int listIndex, String index) {
        int removeIndex = Integer.parseInt(index);
        drawLines();
        System.out.println("Noted. I've removed this task:");
        System.out.println("\t" + tasks.get(--removeIndex).toString());
        tasks.remove(removeIndex);
        printListIndex(--listIndex);
        drawLines();

        return listIndex;
    }

    /** */
    public static ArrayList<Task> findKeyword(ArrayList<Task> tasksData, String filterString) {
        ArrayList<Task> filteredTaskList = (ArrayList<Task>) tasksData.stream()
                .filter((s) -> s.getDescription().contains(filterString))
                .collect(toList());

        return filteredTaskList;
    }
}
