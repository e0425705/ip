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
                if (userInput.toLowerCase().trim().equals("list")) {
                    drawLines();
                    System.out.print("Here" + ((listIndex > 1) ? " are" : " is") + " the");
                    System.out.println(((listIndex > 1) ? " tasks" : " task") + " in the list");
                    for (int j = 0; j < listIndex; j++) {
                        System.out.println((j + 1) + "." + tasks.get(j).toString());
                    }
                    drawLines();
                } else if (userInput.toLowerCase().trim().equals("todo")) {
                    drawLines();
                    System.out.println("The description of a todo cannot be empty.");
                    drawLines();
                } else if (userInput.trim().isEmpty()) {
                    drawLines();
                    System.out.println("The description cannot be empty.");
                    drawLines();
                } else if (userInput.toLowerCase().startsWith("done")) {
                    int taskDone = Integer.parseInt(commandGiven[1]);
                    tasks.get(taskDone - 1).markAsDone();
                    drawLines();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("\t" + tasks.get(taskDone - 1).toString());
                    drawLines();
                } else if (userInput.toLowerCase().startsWith("todo")) {
                    userInput = userInput.substring(4).trim();
                    Task inputDescription = new ToDo(userInput);
                    tasks.add(inputDescription);
                    drawLines();
                    System.out.println("Got it. I've added this task:");
                    System.out.println("\t" + tasks.get(listIndex++).toString());
                    printListIndex(listIndex);
                    drawLines();
                } else if (userInput.toLowerCase().startsWith("deadline")) {
                    userInput = userInput.substring(8).trim();
                    int byIndex = userInput.indexOf('/');
                    String dateInput = userInput.substring(byIndex + 3).trim();
                    userInput = userInput.substring(0, byIndex - 1);
                    Task inputDescription = new Deadline(userInput, dateInput);
                    tasks.add(inputDescription);
                    drawLines();
                    System.out.println("Got it. I've added this task:");
                    System.out.println("\t" + tasks.get(listIndex++).toString());
                    printListIndex(listIndex);
                    drawLines();
                } else if (userInput.toLowerCase().startsWith("event")) {
                    userInput = userInput.substring(5).trim();
                    int byIndex = userInput.indexOf('/');
                    String dateInput = userInput.substring(byIndex + 3).trim();
                    userInput = userInput.substring(0, byIndex - 1);
                    Task inputDescription = new Event(userInput, dateInput);
                    tasks.add(inputDescription);
                    drawLines();
                    System.out.println("Got it. I've added this task:");
                    System.out.println("\t" + tasks.get(listIndex++).toString());
                    printListIndex(listIndex);
                    drawLines();
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

    public static int readFromFile(File file, int listIndex) {
        try {
            if (file.createNewFile()) {
                System.out.println("Created new file " + file.getAbsolutePath());
                drawLines();
            } else if (!file.createNewFile()) {
                Scanner s = new Scanner(file);
                while (s.hasNext()) {
                    String userInput = s.nextLine();
                    String[] savedCommand = userInput.split(" ");
                    switch (savedCommand[0]) {
                    case "T": {
                        userInput = userInput.substring(4);
                        Task inputDescription = new ToDo(userInput);
                        tasks.add(inputDescription);
                        if (savedCommand[1].equals("1")) {
                            tasks.get(listIndex).markAsDone();
                        }
                        System.out.println("\t" + tasks.get(listIndex++).toString());
                        break;
                    }
                    case "E": {
                        int separationIndexOfEvent = userInput.indexOf('|');
                        String atInput = userInput.substring(separationIndexOfEvent + 1).trim();
                        userInput = userInput.substring(4, separationIndexOfEvent - 1);
                        Task inputDescription = new Event(userInput, atInput);
                        tasks.add(inputDescription);
                        if (savedCommand[1].equals("1")) {
                            tasks.get(listIndex).markAsDone();
                        }
                        System.out.println("\t" + tasks.get(listIndex++).toString());
                        break;
                    }
                    case "D": {
                        int separationIndexOfDeadline = userInput.indexOf('|');
                        String byInput = userInput.substring(separationIndexOfDeadline + 1).trim();
                        userInput = userInput.substring(4, separationIndexOfDeadline - 1);
                        Task inputDescription = new Deadline(userInput, byInput);
                        tasks.add(inputDescription);
                        if (savedCommand[1].equals("1")) {
                            tasks.get(listIndex).markAsDone();
                        }
                        System.out.println("\t" + tasks.get(listIndex++).toString());
                        break;
                    }
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
            for (Task task : tasks) {
                fw.write(task.toFileString() + System.lineSeparator());
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
        System.out.println("Commands available: list, help, done, todo, deadline, event, delete, save, bye");
        System.out.println("The expected format of input values: ");
        System.out.println("list - gives the list of data inputted");
        System.out.println("help - this pulls out the commands available");
        System.out.println("done x - x is the index of data that you want to mark as done");
        System.out.println("todo x - x is the task description");
        System.out.println("deadline x /by y - x is the task description and y is the deadline date");
        System.out.println("event x /at y - x is the task description and y is the event date");
        System.out.println("delete x - removes the task located at index x of the list");
        System.out.println("save - this saves the current list");
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
        System.out.println("The current list has been saved.");
        System.out.println("Hope to see you again soon!");
        drawLines();
    }
}