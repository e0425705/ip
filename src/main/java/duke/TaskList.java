package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

public class TaskList extends Duke {
    // contains the task list e.g., it has operations to add/delete tasks in the list

    /** */
    public static int addToDo(String userInput, int listIndex) {
        userInput = userInput.substring(4).trim();
        Task inputDescription = new ToDo(userInput);
        tasks.add(inputDescription);
        listIndex = printOutput(listIndex);

        return listIndex;
    }

    /** */
    public static int addEvent(String userInput, int listIndex) {
        userInput = userInput.substring(5).trim();
        int byIndex = userInput.indexOf('/');
        String dateInput = userInput.substring(byIndex + 3).trim();
        userInput = userInput.substring(0, byIndex - 1);
        Task inputDescription = new Event(userInput, dateInput);
        tasks.add(inputDescription);
        listIndex = printOutput(listIndex);

        return listIndex;
    }

    /** */
    public static int addDeadline(String userInput, int listIndex) {
        userInput = userInput.substring(8).trim();
        int byIndex = userInput.indexOf('/');
        String dateInput = userInput.substring(byIndex + 3).trim();
        userInput = userInput.substring(0, byIndex - 1);
        Task inputDescription = new Deadline(userInput, dateInput);
        tasks.add(inputDescription);
        listIndex = printOutput(listIndex);

        return listIndex;
    }

    /** */
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
}
