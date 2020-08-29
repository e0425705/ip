import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {

        displayDuke();
        drawLines();
        helloMessage();
        drawLines();

        /*
        Level-0, Greet
        levelZero();
        */

        /*
        // Level-1. Greet, Echo, Exit
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
        */

        /*
        // Level-2. Add, List
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
        */

        // Level-3. Mark as Done.
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

    public static void displayDuke() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
    }

    public static void levelZero() {
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
