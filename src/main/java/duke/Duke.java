package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import java.io.File;
import java.lang.String;
import java.util.Scanner;
import java.util.ArrayList;

import static duke.ReadFromFile.readFromFile;
import static duke.WriteToFile.writeToFile;

// import static java.util.stream.Collectors.toList;

public class Duke {
    public static final String DONE = "1";
    public static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        displayDuke();
        helloMessage();
        availableCommands();

        int listIndex = 0;

        File file = new File("duke.txt");
        listIndex = readFromFile(file, listIndex);

        Scanner input = new Scanner(System.in);

        while (true) {
            String userInput = input.nextLine();
            String[] commandGiven = userInput.split(" ");

            try {
                if (userInput.trim().isEmpty()) {
                    drawLines();
                    System.out.println("The description cannot be empty.");
                    drawLines();
                } else if (userInput.toLowerCase().trim().equals("list")) {
                    drawLines();
                    System.out.print("Here" + ((listIndex > 1) ? " are" : " is") + " the");
                    System.out.println(((listIndex > 1) ? " tasks" : " task") + " in the list");
                    for (int j = 0; j < listIndex; j++) {
                        System.out.println("\t" + (j + 1) + "." + tasks.get(j).toString());
                    }
                    drawLines();
                } else if (userInput.toLowerCase().startsWith("done")) {
                    int taskDone = Integer.parseInt(commandGiven[1]);
                    tasks.get(taskDone - 1).markAsDone();
                    drawLines();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("\t" + tasks.get(taskDone - 1).toString());
                    drawLines();
                } else if (userInput.toLowerCase().startsWith("todo")) {
                    if (userInput.toLowerCase().trim().equals("todo")) {
                        drawLines();
                        System.out.println("The description of a todo cannot be empty.");
                        drawLines();
                        continue;
                    }
                    userInput = userInput.substring(4).trim();
                    Task inputDescription = new ToDo(userInput);
                    tasks.add(inputDescription);
                    listIndex = printOutput(listIndex);
                } else if (userInput.toLowerCase().startsWith("deadline")) {
                    userInput = userInput.substring(8).trim();
                    int byIndex = userInput.indexOf('/');
                    String dateInput = userInput.substring(byIndex + 3).trim();
                    userInput = userInput.substring(0, byIndex - 1);
                    Task inputDescription = new Deadline(userInput, dateInput);
                    tasks.add(inputDescription);
                    listIndex = printOutput(listIndex);
                } else if (userInput.toLowerCase().startsWith("event")) {
                    userInput = userInput.substring(5).trim();
                    int byIndex = userInput.indexOf('/');
                    String dateInput = userInput.substring(byIndex + 3).trim();
                    userInput = userInput.substring(0, byIndex - 1);
                    Task inputDescription = new Event(userInput, dateInput);
                    tasks.add(inputDescription);
                    listIndex = printOutput(listIndex);
                } else if (userInput.toLowerCase().trim().equals("bye")) {
                    writeToFile();
                    byeMessage();
                    break;
                } else if (userInput.toLowerCase().trim().equals("save")) {
                    writeToFile();
                    drawLines();
                    System.out.println("The current list has been saved.");
                    drawLines();
                } else if (userInput.toLowerCase().trim().equals("help")) {
                    availableCommands();
                } else if (userInput.toLowerCase().startsWith("delete")) {
                    int removeIndex = Integer.parseInt(commandGiven[1]);
                    drawLines();
                    System.out.println("Noted. I've removed this task:");
                    System.out.println("\t" + tasks.get(--removeIndex).toString());
                    tasks.remove(removeIndex);
                    printListIndex(--listIndex);
                    drawLines();
                } else {
                    drawLines();
                    System.out.println("I'm sorry, but I don't know what that means.");
                    drawLines();
                }
            } catch (StringIndexOutOfBoundsException e) {
                drawLines();
                System.out.println("The task you input has missing fields!");
                System.out.println("Please do input 'help' for the commands and their respective input format.");
                drawLines();
            } catch (Exception e) {
                drawLines();
                System.out.println("Something went wrong!!");
                System.out.println("There could be an error in the way of input.");
                System.out.println("Please do input 'help' for the commands and their respective input format.");
                drawLines();
            }
        }
    }

    /** Prints out acknowledgement of adding task to list */
    private static int printOutput(int listIndex) {
        drawLines();
        System.out.println("Got it. I've added this task:");
        System.out.println("\t" + tasks.get(listIndex++).toString());
        printListIndex(listIndex);
        drawLines();
        return listIndex;
    }

    /** Trims the input of leading and trailing spaces */
    public static String trimInput(String input) {
        input = input.trim();
        return input;
    }

    /** Trims the input of leading and trailing spaces */
    public static String convertInputToLowerCase(String input) {
        input = input.toLowerCase();
        return input;
    }

    /** Prints out the current number of tasks in list */
    public static void printListIndex(int listIndex) {
        System.out.println("Now you have " + listIndex + ((listIndex > 1) ? " tasks" : " task") + " in the list");
    }

    /** Prints out the commands available */
    private static void availableCommands() {
        drawLines();
        String help = "Commands available: list, help, done, todo, deadline, event, delete, find, save, bye\n"
                + "The expected format of input values: \n"
                + "\tlist - gives the list of data inputted\n"
                + "\thelp - this pulls out the commands available\n"
                + "\tdone x - x is the index of data that you want to mark as done\n"
                + "\ttodo x - x is the task description\n"
                + "\tdeadline x /by y - x is the task description and y is the deadline date\n"
                + "\tevent x /at y - x is the task description and y is the event date\n"
                + "\tdelete x - removes the task located at index x of the list\n"
                + "\tfind x - looks for task description with x included\n"
                + "\tsave - this saves the current list\n"
                + "\tbye - this terminates the program";
        System.out.println(help);
        drawLines();
    }

    /** Prints out the Duke logo */
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

    /** Prints out a line divider */
    public static void drawLines() {
        System.out.println("--------------------------------------------------------------------------------------------");
    }

    /** Prints out the hello message */
    public static void helloMessage() {
        String hello = "Hello! I'm duke.\n"
                + "What can I do for you today?";
        System.out.println(hello);
    }

    /** Prints out the bye message */
    public static void byeMessage() {
        drawLines();
        String bye = "Bye. It was a pleasure serving you.\n"
                + "The current list has been saved.\n"
                + "Hope to see you again soon!";
        System.out.println(bye);
        drawLines();
    }
}