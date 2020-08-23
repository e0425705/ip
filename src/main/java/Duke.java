import java.util.*;

public class Duke {
    public static void main(String[] args) {
        displayDuke();

        levelZero();

        // Level-1. Greet, Echo, Exit
        lines();
        helloMessage();
        lines();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        while (!(input.equals("bye"))) {
            lines();
            System.out.println(input);
            lines();
            Scanner next = new Scanner(System.in);
            input = next.nextLine();
        }
        lines();
        byeMessage();
        lines();

        // Level-2. Add, List
        lines();
        helloMessage();
        lines();
        String[] storeMessage = new String[100];
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        int i = 0;
        while(!(command.equals("bye"))) {
            if(command.equals("list")) {
                lines();
                for (int j = 0; j < i; j++) {
                    System.out.println(j + 1 + ". " + storeMessage[j]);
                }
                lines();
                Scanner anotherCommand = new Scanner(System.in);
                command = anotherCommand.nextLine();
            } else {
                lines();
                System.out.println("added: " + command);
                lines();
                storeMessage[i++] = command;
                Scanner nextCommand = new Scanner(System.in);
                command = nextCommand.nextLine();
            }
        }
        lines();
        byeMessage();
        lines();
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
