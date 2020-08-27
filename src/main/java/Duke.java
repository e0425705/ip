import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {

        displayDuke();
        lines();
        helloMessage();
        lines();

        /*
        Level-0, Greet
        levelZero();
        */

        /*
        // Level-1. Greet, Echo, Exit
        lines();
        helloMessage();
        lines();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().toLowerCase();

        while (!(input.equals("bye"))) {
            lines();
            System.out.println(input);
            lines();
            Scanner next = new Scanner(System.in);
            input = next.nextLine().toLowerCase();
        }
        lines();
        byeMessage();
        lines();
        */

        /*
        // Level-2. Add, List
        lines();
        helloMessage();
        lines();
        String[] storeMessage = new String[100];
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine().toLowerCase();
        int i = 0;
        while(!(command.equals("bye"))) {
            if(command.equals("list")) {
                lines();
                for (int j = 0; j < i; j++) {
                    System.out.println(j + 1 + ". " + storeMessage[j]);
                }
                lines();
                Scanner anotherCommand = new Scanner(System.in);
                command = anotherCommand.nextLine().toLowerCase();
            } else {
                lines();
                System.out.println("added: " + command);
                lines();
                storeMessage[i++] = command;
                Scanner nextCommand = new Scanner(System.in);
                command = nextCommand.nextLine().toLowerCase();
            }
        }
        lines();
        byeMessage();
        lines();
        */

        // Level-3. Mark as Done.
        // by default, all items added into list is not marked as done at first
        String[][] storeDescription = new String[100][3];
        Scanner input = new Scanner(System.in);

        int index = 0;
        for (int i = 0; ;i++) {
            String userInput = input.nextLine();
            String[] command = userInput.split(" ");
            if (userInput.equals("list")) {
                lines();
                System.out.println("Here are the tasks in your list:");
                for (int j = 0; j < index; j++) {
                    String isChecked = storeDescription[j][2];
                    System.out.println(j + 1 + ". [" + (isChecked.equals("true") ? "\u2713" : "\u2718") + "]" + storeDescription[j][1]);
                }
                lines();
            } else if (command[0].equals("done")) {
                int indexToBeMarked = Integer.parseInt(command[1]) - 1;
                lines();
                System.out.println("Nice! I've marked this task as done:");
                storeDescription[indexToBeMarked][2] = "true";
                System.out.println("[" + "\u2713" + "] " + storeDescription[indexToBeMarked][1]);
                lines();
            } else if (userInput.equals("bye")) {
                lines();
                byeMessage();
                lines();
                break;
            } else {
                lines();
                System.out.println("added: " + userInput);
                lines();
                storeDescription[index][0] = String.valueOf(index);
                storeDescription[index][1] = userInput;
                storeDescription[index++][2] = "false";
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
        lines();
        helloMessage();
        lines();
        byeMessage();
        lines();
    }

    public static void lines() {
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
