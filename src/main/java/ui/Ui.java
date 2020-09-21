package ui;

import duke.Duke;
import duke.task.Task;

import java.io.IOException;

import static tasklist.TaskList.addDeadline;
import static tasklist.TaskList.addEvent;
import static tasklist.TaskList.addToDo;
import static tasklist.TaskList.deleteTask;
import static storage.Storage.saveFile;
import static tasklist.TaskList.findKeyword;

/**
 * deals with interactions with the user
 */
public class Ui extends Duke {
    /**
     * Prints out the commands available
     */
    public static void availableCommands() {
        drawLines();
        String help = "Commands available: list, help, done, todo, deadline, event, delete, find, save, bye\n"
                + "The expected format of input values: \n"
                + "\tlist - gives the list of data inputted\n"
                + "\thelp - this pulls out the commands available\n"
                + "\tdone x - x is the index of data that you want to mark as done\n"
                + "\ttodo x - x is the task description\n"
                + "\tdeadline x /by DATETIME - x is the task description and y is the deadline date and time\n"
                + "\tevent x /at DATETIME - x is the task description and y is the event date and time\n"
                + "\t\tthe format for DATETIME is YYYY-MM-DDtHHmm, where\n"
                + "\t\tY = year, M = month, D = day, H = hour, m = minute\n"
                + "\tdelete x - removes the task located at index x of the list\n"
                + "\tfind y - looks for task description with y included\n"
                + "\tsave - this saves the current list\n"
                + "\tbye - this terminates the program";
        System.out.println(help);
        drawLines();
    }

    /**
     * Prints out the Duke logo
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
     * Prints out a line divider
     */
    public static void drawLines() {
        System.out.println("--------------------------------------------------------------------------------------------");
    }

    /**
     * Prints out acknowledgement of adding task to list
     */
    public static int printOutput(int listIndex) {
        drawLines();
        System.out.println("Got it. I've added this task:");
        System.out.println("\t" + tasks.get(listIndex++).toString());
        printListIndex(listIndex);
        drawLines();

        return listIndex;
    }

    /**
     * Prints out the current number of tasks in list
     */
    public static void printListIndex(int listIndex) {
        System.out.println("Now you have " + listIndex + ((listIndex > 1) ? " tasks" : " task") + " in the list");
    }

    /**
     * Prints out the hello message
     */
    public static void helloMessage() {
        String hello = "Hello! I'm duke.\n"
                + "What can I do for you today?";
        System.out.println(hello);
    }

    /**
     * Prints out the bye message
     */
    public static void byeMessage() {
        drawLines();
        String bye = "Bye. It was a pleasure serving you.\n"
                + "The current list has been saved.\n"
                + "Hope to see you again soon!";
        System.out.println(bye);
        drawLines();
    }

    /**
     *
     */
    public static void displayWelcomeMessage() {
        displayDuke();
        helloMessage();
        availableCommands();
    }

    /**
     *
     */
    public static void displayCaseEmptyInput() {
        drawLines();
        System.out.println("The description cannot be empty.");
        drawLines();
    }

    /**
     *
     */
    public static void displayList(int listIndex) {
        drawLines();
        System.out.print("Here" + ((listIndex > 1) ? " are" : " is") + " the");
        System.out.println(((listIndex > 1) ? " tasks" : " task") + " in the list");
        for (int j = 0; j < listIndex; j++) {
            System.out.println("\t" + (j + 1) + "." + tasks.get(j).toString());
        }
        drawLines();
    }

    /**
     *
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
     *
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
     *
     */
    public static int displayDeadline(String userInput, int listIndex) {
        if (addDeadline(userInput, listIndex) == -1) {
            drawLines();
            System.out.println("The allowed input for date and time is YYYY-MM-DDtHH:MM");
            drawLines();
        }
        return listIndex;
    }

    /**
     *
     */
    public static int displayEvent(String userInput, int listIndex) {
        if (addEvent(userInput, listIndex) == -1) {
            drawLines();
            System.out.println("error in date-time input!");
            System.out.println("The allowed input for date and time is YYYY-MM-DDtHHmm");
            drawLines();
        }

        return listIndex;
    }

    /**
     *
     */
    public static void displayByeMessage() {
        saveFile();
        byeMessage();
    }

    /**
     *
     */
    public static void displaySaveMessage() {
        saveFile();
        drawLines();
        System.out.println("The current list has been saved.");
        drawLines();
    }

    /**
     *
     */
    public static void displayFind(String keyword, int listIndex) {
        keyword = keyword.substring(4).trim();
        drawLines();
        int[] indexOfKeyword = new int[20];
        int indexToSaveKeyword = 0;
        int indexToAccess = 0;
        System.out.println("Here are the matching tasks in your list:");
        for (Task t : findKeyword(tasks, keyword)) {
            for (int i = 0; i < listIndex; i++) {
                if (tasks.get(i).equals(t)) {
                    indexOfKeyword[indexToSaveKeyword++] = ++i;
                }
            }
            System.out.println("\t" + indexOfKeyword[indexToAccess++] + "." + t);
        }

        drawLines();
    }

    /**
     *
     */
    public static void displayHelpMessage() {
        availableCommands();
    }

    /**
     *
     */
    public static int displayDeleteMessage(int listIndex, String givenCommand) {
        listIndex = deleteTask(listIndex, givenCommand);

        return listIndex;
    }

    /**
     *
     */
    public static void displayStringIndexOutOfBoundsExceptionMessage() {
        drawLines();
        System.out.println("The task you input has missing fields!");
        System.out.println("Please do input 'help' for the commands and their respective input format.");
        drawLines();
    }

    /**
     *
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
     *
     */
    public static void displayIOExceptionMessage(IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }

    /**
     *
     */
    public static void displayWriteToFileException(Exception e) {
        System.out.println("Something went wrong: " + e.getMessage());
    }
}
