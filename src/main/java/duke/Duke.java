package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.String;
import java.util.Scanner;
import java.util.ArrayList;

public class Duke {

    public static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        displayDuke();
        helloMessage();
        commandsAvailable();

        int listIndex = 0;
        File file = new File("duke.txt");
        listIndex = readFromFile(file, listIndex);

        Scanner input = new Scanner(System.in);

        while (true) {
            String userInput = input.nextLine();
            String[] commandGiven = userInput.split(" ");

            try {
                if (userInput.toLowerCase().equals("list")) {
                    drawLines();
                    System.out.print("Here" + ((listIndex > 1) ? " are" : " is") + " the");
                    System.out.println(((listIndex > 1) ? " tasks" : " task") + " in the list");
                    for (int j = 0; j < listIndex; j++) {
                        System.out.println((j + 1) + "." + tasks.get(j).toString());
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
                    tasks.get(taskDone - 1).markAsDone();
                    drawLines();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("\t" + tasks.get(taskDone - 1).toString());
                    drawLines();
                } else if (userInput.toLowerCase().startsWith("todo")) {
                    drawLines();
                    userInput = userInput.substring(4).trim();
                    System.out.println("Got it. I've added this task:");
                    listIndex = addToDo(listIndex, userInput);
                    printListIndex(listIndex);
                    drawLines();
                } else if (userInput.toLowerCase().startsWith("deadline")) {
                    drawLines();
                    userInput = userInput.substring(8).trim();
                    int byIndex = userInput.indexOf('/');
                    String dateInput = userInput.substring(byIndex + 3).trim();
                    userInput = userInput.substring(0, byIndex - 1);
                    System.out.println("Got it. I've added this task:");
                    listIndex = addDeadline(listIndex, userInput, dateInput);
                    printListIndex(listIndex);
                    drawLines();
                } else if (userInput.toLowerCase().startsWith("event")) {
                    drawLines();
                    userInput = userInput.substring(5).trim();
                    int byIndex = userInput.indexOf('/');
                    String dateInput = userInput.substring(byIndex + 3).trim();
                    userInput = userInput.substring(0, byIndex - 1);
                    System.out.println("Got it. I've added this task:");
                    listIndex = addEvent(listIndex, userInput, dateInput);
                    printListIndex(listIndex);
                    drawLines();
                } else if (userInput.toLowerCase().equals("bye")) {
                    byeMessage();
                    writeToFile();
                    break;
                } else if (userInput.toLowerCase().equals("help")) {
                    commandsAvailable();
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

    private static int addEvent(int listIndex, String userInput, String dateInput) {
        Task inputDescription = new Event(userInput, dateInput);
        tasks.add(inputDescription);
        System.out.println("\t" + tasks.get(listIndex++).toString());
        return listIndex;
    }

    private static int addDeadline(int listIndex, String userInput, String dateInput) {
        Task inputDescription = new Deadline(userInput, dateInput);
        tasks.add(inputDescription);
        System.out.println("\t" + tasks.get(listIndex++).toString());
        return listIndex;
    }

    private static int addToDo(int listIndex, String userInput) {
        Task inputDescription = new ToDo(userInput);
        tasks.add(inputDescription);
        System.out.println("\t" + tasks.get(listIndex++).toString());
        return listIndex;
    }

    public static int readFromFile(File file, int listIndex) {
        try {
            if (file.createNewFile()) {
                System.out.println("Created new file " + file.getAbsolutePath());
            } else if (!file.createNewFile()) {
                Scanner s = new Scanner(file);
                while (s.hasNext()) {
                    String userInput = s.nextLine();
                    String[] savedCommand = userInput.split(" ");
                    if (savedCommand[0].equals("T")) {
                        userInput = userInput.substring(4);
                        listIndex = addToDo(listIndex, userInput);
                    } else if (savedCommand[0].equals("E")) {
                        int separationIndexOfEvent = userInput.indexOf('|');
                        String atInput = userInput.substring(separationIndexOfEvent + 1).trim();
                        userInput = userInput.substring(4, separationIndexOfEvent - 1);
                        listIndex = addEvent(listIndex, userInput, atInput);
                    } else if (savedCommand[0].equals("D")) {
                        int separationIndexOfDeadline = userInput.indexOf('|');
                        String byInput = userInput.substring(separationIndexOfDeadline + 1).trim();
                        userInput = userInput.substring(4, separationIndexOfDeadline - 1);
                        listIndex = addDeadline(listIndex, userInput, byInput);
                    }
                }
                printListIndex(listIndex);
                drawLines();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return listIndex;
    }

    public static void writeToFile() {
        try {
            FileWriter fw = new FileWriter("duke.txt");
            for (int i = 0; i < tasks.size(); i++) {
                fw.write(tasks.get(i).toFileString() + System.lineSeparator());
            }
            fw.close();
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
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
        System.out.println("delete x - removes the task located at index x of the list");
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