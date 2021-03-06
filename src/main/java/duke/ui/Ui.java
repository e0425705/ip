package duke.ui;

import duke.Duke;
import duke.task.Task;

import java.io.IOException;

import static duke.storage.ReadFromFile.ERROR;
import static duke.tasklist.TaskList.addDeadline;
import static duke.tasklist.TaskList.addEvent;
import static duke.tasklist.TaskList.addToDo;
import static duke.tasklist.TaskList.deleteTask;
import static duke.storage.Storage.saveFile;
import static duke.tasklist.TaskList.findKeyword;

/**
 * Deals with interactions with the user.
 */
public class Ui extends Duke {
    /** Maximum array size */
    public static final int MAXIMUM = 100;

    /** Length of the word find */
    public static final int LENGTH_OF_WORD_FIND = 4;

    /** Check if variable is singular or plural */
    public static final int SINGULAR = 1;

    /**
     * Prints out Duke logo.
     */
    public static void displayDuke() {
        drawLines();
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        drawLines();
    }

    /**
     * Prints out a line divider.
     */
    public static void drawLines() {
        System.out.println("--------------------------------------------------------------------"
                + "------------------------");
    }

    /**
     * Prints out acknowledgement of adding task to list.
     */
    public static int printAddTaskToList(int listIndex) {
        drawLines();
        System.out.println("Got it. I've added this task:");
        System.out.println("\t" + tasks.get(listIndex++).toString());
        printListIndex(listIndex);
        drawLines();

        return listIndex;
    }

    /**
     * Prints out current number of tasks in list.
     *
     * @param listIndex Current number of tasks in list.
     */
    public static void printListIndex(int listIndex) {
        System.out.println("Now you have " + listIndex + ((listIndex > SINGULAR) ? " tasks" : " task")
                + " in the list");
    }

    /**
     * Prints out hello message.
     */
    public static void helloMessage() {
        String hello = "Hello! I'm Duke.\n"
                + "What can I do for you today?";
        System.out.println(hello);
    }

    /**
     * Prints out welcome message to user when program is run.
     */
    public static void displayWelcomeMessage() {
        displayDuke();
        helloMessage();
        displayHelpMessage();
    }

    /**
     * Prints out error message if input is empty.
     */
    public static void displayCaseEmptyInput() {
        drawLines();
        System.out.println("The description cannot be empty.");
        drawLines();
    }

    /**
     * Prints out current list of tasks.
     *
     * @param listIndex Current number of tasks in list.
     */
    public static void displayList(int listIndex) {
        drawLines();
        System.out.print("Here" + ((listIndex > SINGULAR) ? " are" : " is") + " the");
        System.out.println(((listIndex > SINGULAR) ? " tasks" : " task") + " in the list");
        for (int j = INITIALISE; j < listIndex; j++) {
            System.out.println("\t" + (j + 1) + "." + tasks.get(j).toString());
        }
        drawLines();
    }

    /**
     * Prints out message when a task is marked as done by user.
     *
     * @param givenCommand Index of task to be marked as done.
     */
    public static void displayDone(String givenCommand) {
        int taskDone = Integer.parseInt(givenCommand);
        tasks.get(taskDone - 1).markAsDone();
        drawLines();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("\t" + tasks.get(taskDone - 1).toString());
        drawLines();
    }

    /**
     * Prints out message when a {@code ToDo} task is input by user.
     *
     * @param userInput String of user input.
     * @param listIndex Current number of tasks in list.
     */
    public static int displayToDo(String userInput, int listIndex) {
        if (userInput.toLowerCase().trim().equals("todo")) {
            drawLines();
            System.out.println("The description of a todo cannot be empty.");
            drawLines();
        } else {
            listIndex = addToDo(userInput, listIndex);
        }
        return listIndex;
    }

    /**
     * Prints out message when a {@code Deadline} task is input by user.
     *
     * @param userInput String of user input.
     * @param listIndex Current number of tasks in list.
     */
    public static int displayDeadlineError(String userInput, int listIndex) {
        if (addDeadline(userInput, listIndex) == ERROR) {
            drawLines();
            System.out.println("Sorry I do not understand what you mean!\n"
                    + "Do bring out help list via the command 'help' for the specific format!");
            drawLines();
        } else {
            listIndex++;
        }
        return listIndex;
    }

    /**
     * Prints out message when an {@code Event} task is input by user.
     *
     * @param userInput String of user input.
     * @param listIndex Current number of tasks in list.
     */
    public static int displayEventError(String userInput, int listIndex) {
        if (addEvent(userInput, listIndex) == ERROR) {
            drawLines();
            System.out.println("Sorry I do not understand what you mean!\n"
                    + "Do bring out help list via the command 'help' for the specific format!");
            drawLines();
        } else {
            listIndex++;
        }
        return listIndex;
    }

    /**
     * Prints out bye message and let the user know that the current list has been saved to file.
     */
    public static void displayByeMessage() {
        saveFile();
        drawLines();
        String bye = "Bye. It was a pleasure serving you.\n"
                + "The current list has been saved.\n"
                + "Hope to see you again soon!";
        System.out.println(bye);
        drawLines();
    }

    /**
     * Prints out acknowledgement of saving current list in file.
     */
    public static void displaySaveMessage() {
        saveFile();
        drawLines();
        System.out.println("The current list has been saved.");
        drawLines();
    }

    /**
     * Prints out index of the task and the respective task description that contain the keyword.
     *
     * @param keyword String that user is looking for in current list.
     * @param listIndex Current number of tasks in list.
     */
    public static void displayFind(String keyword, int listIndex) {
        keyword = keyword.substring(LENGTH_OF_WORD_FIND).trim();
        int[] indexesOfKeyword = new int[MAXIMUM];
        int indexToSaveKeyword = INITIALISE;
        int indexToAccess = INITIALISE;

        drawLines();
        System.out.println("Here are the matching tasks in your list:");
        for (Task t : findKeyword(tasks, keyword)) {
            for (int i = INITIALISE; i < listIndex; i++) {
                if (tasks.get(i).equals(t)) {
                    indexesOfKeyword[indexToSaveKeyword++] = ++i;
                }
            }
            System.out.println("\t" + indexesOfKeyword[indexToAccess++] + "." + t);
        }
        drawLines();
    }

    /**
     * Prints out commands available.
     */
    public static void displayHelpMessage() {
        drawLines();
        String help = "Commands available: list, help, done, todo, deadline, event, delete, find, save, bye\n"
                + "The expected format of input values: \n"
                + "\tlist - prints list of data inputted\n"
                + "\thelp - pulls out commands available and their input format\n"
                + "\tdone x - x is index of data that you want to mark as done\n"
                + "\ttodo x - x is task description\n"
                + "\tdeadline x /by DATETIME - x is task description, DATETIME is deadline date and time\n"
                + "\tevent x /at DATETIME - x is task description, DATETIME is event date and time\n"
                + "\t\tFormat for DATETIME is YYYY-MM-DDtHHmm, where\n"
                + "\t\tYYYY = year, MM = month, DD = day, HH = hour, mm = minute\n"
                + "\tdelete x - removes task located at index x of the list\n"
                + "\tfind x - looks for task description with x included\n"
                + "\tsave - saves current list\n"
                + "\tbye - terminates the program";
        System.out.println(help);
        drawLines();
    }

    /**
     * Prints out acknowledgement that task at index listIndex is deleted.
     *
     * @param listIndex Current number of tasks in list.
     * @param deleteListIndex Index in the list to be deleted.
     */
    public static int displayDeleteMessage(int listIndex, String deleteListIndex) {
        int removeIndex = Integer.parseInt(deleteListIndex);
        if (removeIndex > listIndex) {
            displayDeleteErrorMessage();
        } else {
            listIndex = deleteTask(listIndex, removeIndex);
        }
        return listIndex;
    }

    private static void displayDeleteErrorMessage() {
        drawLines();
        System.out.println("Sorry the index of task to be remove cannot be found!");
        drawLines();
    }

    /**
     * Prints the error message when StringIndexOutOfBoundsException occurs.
     */
    public static void displayStringIndexOutOfBoundsExceptionMessage() {
        drawLines();
        System.out.println("The task you input has missing fields!");
        System.out.println("Please do input 'help' for the commands and their respective input format.");
        drawLines();
    }

    /**
     * Prints error message when Exception occurs.
     */
    public static void displayExceptionMessage() {
        drawLines();
        String exception = "Something went wrong!! I do not understand what you mean.\n"
                + "There could be an error in the way of input.\n"
                + "Please do input 'help' for the commands and their respective input format.";
        System.out.println(exception);
        drawLines();
    }

    /**
     * Prints error message when IOException occurs.
     */
    public static void displayIOExceptionMessage(IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }

    /**
     * Prints error message when there is an error in method WriteToFile.
     */
    public static void displayWriteToFileException(Exception e) {
        System.out.println("Something went wrong: " + e.getMessage());
    }

    /**
     * Prints error message when there is an error in method ReadFromFile.
     */
    public static void displayReadFromError() {
        drawLines();
        System.out.println("An error has occurred here!\n"
                + "Do check file source if there is a corruption of data!");
        drawLines();
    }
}
