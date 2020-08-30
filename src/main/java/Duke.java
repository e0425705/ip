import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        /*
        // Level-0, Greet
        levelZero();
        // Level-1. Greet, Echo, Exit
        levelOne();
        // Level-2. Add, List
        levelTwo();
        // Level-3. Mark as Done.
        levelThree();
        */
        // Level-4. ToDos, Events, Deadlines
        levelFour();
    }

    public static void levelFour() {
        displayDuke();
        drawLines();
        helloMessage();
        System.out.println("Functions available: list, done, todo, event, deadline");
        System.out.println("list: Gives the list of data inputted");
        System.out.println("done x: x is the index of data that you want to mark as done");
        System.out.println("todo x: x is the data to be done");
        System.out.println("deadline x /by y: x is the data and y is the deadline");
        System.out.println("event x /at y: x is the data and y is the event date");
        drawLines();
        String[][] listDescription = new String[100][5];
        /*
         * listDescription[][0]: action - done, todo, deadline, events
         * listDescription[][1]: input
         * listDescription[][2]: store whether done or not
         * listDescription[][3]: store [T]/[D]/[E]
         * listDescription[][4]: store date input from [D]/[E]
         */
        Scanner input = new Scanner(System.in);
        int listIndex = 0;
        for (int i = 0; ;i++) {
            String userInput = input.nextLine();
            String[] commandGiven = userInput.split(" ");
            if (userInput.equals("bye")) {
                drawLines();
                byeMessage();
                drawLines();
            } else if (userInput.equals("list")) {
                drawLines();
                System.out.println("Here are the tasks in your list:");
                for (int j = 0; j < listIndex; j++) {
                    String isChecked = listDescription[j][2];
                    if (listDescription[j][3].equals("D")) {
                        System.out.print( (j+1) + ". [D][" + (isChecked.equals("true") ? "\u2713" : "\u2718") + "]");
                        System.out.println(listDescription[j][1] + " (by: " + listDescription[j][4] + ")");
                    } else if (listDescription[j][3].equals("E")) {
                        System.out.print( (j+1) + ". [E][" + (isChecked.equals("true") ? "\u2713" : "\u2718") + "]");
                        System.out.println(listDescription[j][1] + " (at: " + listDescription[j][4] + ")");
                    } else {
                        System.out.println( (j+1) + ". [T][" + (isChecked.equals("true") ? "\u2713" : "\u2718") + "]" + listDescription[j][1]);
                    }
                }
                drawLines();
            } else if (commandGiven[0].equals("done")) {
                int indexToBeMarked = Integer.parseInt(commandGiven[1]) - 1;
                drawLines();
                System.out.println("Nice! I've marked this task as done:");
                listDescription[indexToBeMarked][2] = "true";
                System.out.println("[" + "\u2713" + "] " + listDescription[indexToBeMarked][1]);
                drawLines();
            } else if (commandGiven[0].equals("todo")) {
                userInput = userInput.substring(5);
                listDescription[listIndex][1] = userInput;
                listDescription[listIndex][2] = "false";
                listDescription[listIndex++][3] = "T";
                drawLines();
                System.out.println("Got it. I've added this task:");
                System.out.println("  [T][" + "\u2718" + "] " + userInput);
                System.out.println("Now you have " + (listIndex) + ((listIndex > 1)? " tasks " : " task ") + "in your list");
                drawLines();
            } else if (commandGiven[0].equals("deadline")) {
                int slashIndex = userInput.indexOf('/');
                String deadlineDate = userInput.substring(slashIndex+4);
                userInput = userInput.substring(9,slashIndex-1);
                listDescription[listIndex][1] = userInput;
                listDescription[listIndex][2] = "false";
                listDescription[listIndex][3] = "D";
                listDescription[listIndex++][4] = deadlineDate;
                drawLines();
                System.out.println("Got it. I've added this task:");
                System.out.println("  [T][" + "\u2718" + "] " + userInput + " (by: " + deadlineDate + ")");
                System.out.println("Now you have " + (listIndex) + ((listIndex > 1)? " tasks " : " task ") + "in your list");
                drawLines();
            } else if (commandGiven[0].equals("event")) {
                int slashIndex = userInput.indexOf('/');
                String eventDate = userInput.substring(slashIndex+4);
                userInput = userInput.substring(6,slashIndex-1);
                listDescription[listIndex][1] = userInput;
                listDescription[listIndex][2] = "false";
                listDescription[listIndex][3] = "E";
                listDescription[listIndex++][4] = eventDate;
                drawLines();
                System.out.println("Got it. I've added this task:");
                System.out.println("  [T][" + "\u2718" + "] " + userInput + " (at: " + eventDate + ")");
                System.out.println("Now you have " + (listIndex) + ((listIndex > 1)? " tasks " : " task ") + "in your list");
                drawLines();
            }
        }
    }

    public static void levelThree() {
        displayDuke();
        drawLines();
        helloMessage();
        drawLines();
        String[][] listDescription = new String[100][3];
        Scanner input = new Scanner(System.in);

        int listIndex = 0;
        for (int i = 0; ;i++) {
            String userInput = input.nextLine();
            String[] commandGiven = userInput.split(" ");
            if (userInput.equals("list")) {
                drawLines();
                System.out.println("Here are the tasks in your list:");
                for (int j = 0; j < listIndex; j++) {
                    String isChecked = listDescription[j][2];
                    System.out.println(j + 1 + ". [" + (isChecked.equals("true") ? "\u2713" : "\u2718") + "]" + listDescription[j][1]);
                }
                drawLines();
            } else if (commandGiven[0].equals("done")) {
                int indexToBeMarked = Integer.parseInt(commandGiven[1]) - 1;
                drawLines();
                System.out.println("Nice! I've marked this task as done:");
                listDescription[indexToBeMarked][2] = "true";
                System.out.println("[" + "\u2713" + "] " + listDescription[indexToBeMarked][1]);
                drawLines();
            } else if (userInput.equals("bye")) {
                drawLines();
                byeMessage();
                drawLines();
                break;
            } else {
                drawLines();
                System.out.println("added: " + userInput);
                drawLines();
                listDescription[listIndex][0] = String.valueOf(listIndex);
                listDescription[listIndex][1] = userInput;
                listDescription[listIndex++][2] = "false";
            }
        }
    }

    public static void levelTwo() {
        displayDuke();
        drawLines();
        helloMessage();
        drawLines();
        String[] storeMessage = new String[100];
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine().toLowerCase();
        int i = 0;
        while(!(command.equals("bye"))) {
            if(command.equals("list")) {
                drawLines();
                for (int j = 0; j < i; j++) {
                    System.out.println(j + 1 + ". " + storeMessage[j]);
                }
                drawLines();
                Scanner anotherCommand = new Scanner(System.in);
                command = anotherCommand.nextLine().toLowerCase();
            } else {
                drawLines();
                System.out.println("added: " + command);
                drawLines();
                storeMessage[i++] = command;
                Scanner nextCommand = new Scanner(System.in);
                command = nextCommand.nextLine().toLowerCase();
            }
        }
        drawLines();
        byeMessage();
        drawLines();
    }

    public static void levelOne() {
        displayDuke();
        drawLines();
        helloMessage();
        drawLines();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().toLowerCase();

        while (!(input.equals("bye"))) {
            drawLines();
            System.out.println(input);
            drawLines();
            Scanner next = new Scanner(System.in);
            input = next.nextLine().toLowerCase();
        }
        drawLines();
        byeMessage();
        drawLines();
    }

    public static void displayDuke() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
    }

    public static void levelZero() {
        displayDuke();
        drawLines();
        helloMessage();
        drawLines();
        byeMessage();
        drawLines();
    }

    public static void drawLines() {
        System.out.println("____________________________________________________________");
    }

    public static void helloMessage() {
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
    }

    public static void byeMessage() {
        System.out.println("Bye. Hope to see you again soon!");
    }

}
