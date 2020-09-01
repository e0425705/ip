import taskPack.Task;
import java.lang.String;
import java.util.Scanner;

public class Duke {
    public static final int MAX_INT = 100;
    private static Task[] tasks = new Task[MAX_INT];

    public static void main(String[] args) {
        // Level 3
        drawLines();
        displayDuke();
        drawLines();
        helloMessage();
        System.out.println("Commands available: list, done, todo, event, deadline");
        System.out.println("The expected format of input values: ");
        System.out.println("list - Gives the list of data inputted");
        System.out.println("done x - x is the index(pull up list) of data that you want to mark as done");
        System.out.println("todo x - x is the data to be done");
        System.out.println("deadline x /by y - x is the data and y is the deadline");
        System.out.println("event x /at y - x is the data and y is the event date");
        drawLines();

        Scanner input = new Scanner(System.in);
        int listIndex = 0;
        for (int i = 0; ; i++) {
            String userInput = input.nextLine();
            String commandGiven[] = userInput.split(" ");
            if (userInput.equals("list")) {
                drawLines();
                System.out.println("Here are the tasks in your list:");
                for (int j = 0; j < listIndex; j++) {
                    System.out.println((j+1) + "." + tasks[j].toString());
                }
                drawLines();
            } else if (userInput.startsWith("done")) {
                drawLines();
                int taskDone = Integer.parseInt(commandGiven[1]);
                tasks[taskDone - 1].markAsDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println(tasks[taskDone - 1].toString());
                drawLines();
            } else if (commandGiven[0].equals("todo")) {
                drawLines();
                System.out.println("Got it. I've added this task:");
                userInput = userInput.substring(5);
                tasks[listIndex] = new ToDo(userInput);
                System.out.println("\t" + tasks[listIndex++].toString());
                System.out.println("Now you have " + listIndex + ((listIndex > 1) ? " tasks" : " task") + " in the list");
                drawLines();
            } else if (commandGiven[0].equals("deadline")) {
                drawLines();
                System.out.println("Got it. I've added this task:");
                userInput = userInput.substring(9);
                int byIndex = userInput.indexOf('/');
                String dateInput = userInput.substring(byIndex + 4);
                userInput = userInput.substring(0, byIndex-1);
                tasks[listIndex] = new Deadline(userInput, dateInput);
                System.out.println("\t" + tasks[listIndex++].toString());
                System.out.println("Now you have " + listIndex + ((listIndex > 1) ? " tasks" : " task") + " in the list");
                drawLines();
            } else if (commandGiven[0].equals("event")) {
                drawLines();
                System.out.println("Got it. I've added this task:");
                userInput = userInput.substring(6);
                int byIndex = userInput.indexOf('/');
                String dateInput = userInput.substring(byIndex + 4);
                userInput = userInput.substring(0, byIndex-1);
                tasks[listIndex] = new Event(userInput, dateInput);
                System.out.println("\t" + tasks[listIndex++].toString());
                System.out.println("Now you have " + listIndex + ((listIndex > 1) ? " tasks" : " task") + " in the list");
                drawLines();
            } else if (userInput.equals("bye")) {
                drawLines();
                byeMessage();
                drawLines();
                break;
            }
        }
    }

    public static void displayDuke() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  /\n"
                + "|____/ \\,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
    }

    public static void drawLines() {
        System.out.println("--------------------------------------------------------------------------------------------");
    }

    public static void helloMessage() {
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
    }

    public static void byeMessage() {
        System.out.println("Bye. Hope to see you again soon!");
    }
}