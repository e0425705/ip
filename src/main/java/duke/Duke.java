package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import java.lang.String;
import java.util.Scanner;

public class Duke {
    public static final int MAX_INT = 100;
    private static Task[] tasks = new Task[MAX_INT];

    public static void main(String[] args) {
        // Level 4
        displayDuke();
        helloMessage();
        commandsAvailable();

        Scanner input = new Scanner(System.in);
        int listIndex = 0;

        while (true) {
            String userInput = input.nextLine();
            String[] commandGiven = userInput.split(" ");

            try {
                if (userInput.toLowerCase().equals("list")) {
                    drawLines();
                    System.out.println("Here are the tasks in your list:");
                    for (int j = 0; j < listIndex; j++) {
                        System.out.println((j + 1) + "." + tasks[j].toString());
                    }
                    drawLines();
                } else if (userInput.toLowerCase().trim().equals("todo")) {
                    drawLines();
                    System.out.println(" ☹ OOPS!!! The description of a todo cannot be empty.");
                    drawLines();
                } else if (userInput.trim().isEmpty()) {
                    drawLines();
                    System.out.println(" ☹ OOPS!!! The description cannot be empty.");
                    drawLines();
                } else if (userInput.toLowerCase().startsWith("done")) {
                    int taskDone = Integer.parseInt(commandGiven[1]);
                    tasks[taskDone - 1].markAsDone();
                    drawLines();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println(tasks[taskDone - 1].toString());
                    drawLines();
                } else if (userInput.toLowerCase().startsWith("todo")) {
                    userInput = userInput.substring(4).trim();
                    tasks[listIndex] = new ToDo(userInput);
                    drawLines();
                    System.out.println("Got it. I've added this task:");
                    System.out.println("\t" + tasks[listIndex++].toString());
                    printListIndex(listIndex);
                    drawLines();
                } else if (userInput.toLowerCase().startsWith("deadline")) {
                    listIndex = getListIndexOfDeadline(listIndex, userInput);
                    drawLines();
                    System.out.println("Got it. I've added this task:");
                    printListIndex(listIndex);
                    drawLines();
                } else if (userInput.toLowerCase().startsWith("event")) {
                    listIndex = getListIndexOfEvent(listIndex, userInput);
                    drawLines();
                    System.out.println("Got it. I've added this task:");
                    printListIndex(listIndex);
                    drawLines();
                } else if (userInput.toLowerCase().equals("bye")) {
                    byeMessage();
                    break;
                } else if (userInput.toLowerCase().equals("help")) {
                    commandsAvailable();
                } else {
                    drawLines();
                    System.out.println(" ☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                    drawLines();
                }
            } catch (StringIndexOutOfBoundsException e) {
                drawLines();
                System.out.println("The task you input has missing fields!");
                System.out.println("Please do input 'help' for the commands and their respective input format.");
                drawLines();
            } catch (Exception e) {
                drawLines();
                System.out.println("Something went wrong!");
                System.out.println("There could be an error in the way of input.");
                System.out.println("Please do input 'help' for the commands and their respective input format.");
                drawLines();
            }
        }
    }

    private static int getListIndexOfEvent(int listIndex, String userInput) {
        userInput = userInput.substring(5).trim();
        int byIndex = userInput.indexOf('/');
        String dateInput = userInput.substring(byIndex + 3).trim();
        userInput = userInput.substring(0, byIndex - 1);
        tasks[listIndex] = new Event(userInput, dateInput);
        System.out.println("\t" + tasks[listIndex++].toString());
        return listIndex;
    }

    private static int getListIndexOfDeadline(int listIndex, String userInput) {
        userInput = userInput.substring(8).trim();
        int byIndex = userInput.indexOf('/');
        String dateInput = userInput.substring(byIndex + 3).trim();
        userInput = userInput.substring(0, byIndex - 1);
        tasks[listIndex] = new Deadline(userInput, dateInput);
        System.out.println("\t" + tasks[listIndex++].toString());
        return listIndex;
    }

    private static void printListIndex(int listIndex) {
        System.out.println("Now you have " + listIndex + ((listIndex > 1) ? " tasks" : " task") + " in the list");
    }

    private static void commandsAvailable() {
        drawLines();
        System.out.println("Commands available: list, done, todo, event, deadline");
        System.out.println("The expected format of input values: ");
        System.out.println("list - gives the list of data inputted");
        System.out.println("help - this pulls out the commands available");
        System.out.println("done x - x is the index(pull up list) of data that you want to mark as done");
        System.out.println("todo x - x is the data to be done");
        System.out.println("deadline x /by y - x is the data and y is the deadline");
        System.out.println("event x /at y - x is the data and y is the event date");
        System.out.println("bye - this terminates the program");
        drawLines();
    }

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

    public static void drawLines() {
        System.out.println("--------------------------------------------------------------------------------------------");
    }

    public static void helloMessage() {
        System.out.println("Hello! I'm duke.");
        System.out.println("What can I do for you today?");
    }

    public static void byeMessage() {
        drawLines();
        System.out.println("Bye. It was a pleasure serving you.");
        System.out.println("Hope to see you again soon!");
        drawLines();
    }
}