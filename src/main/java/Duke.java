import java.util.*;

public class Duke {
    public static void main(String[] args) {
        // printing out of "DUKE"
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        // Level 0
        lines();
        helloMessage();
        lines();
        byeMessage();
        lines();

        // Level 1
        lines();
        helloMessage();
        lines();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        while(!(input.equals("bye"))) {
            lines();
            System.out.println(input);
            lines();
            Scanner next = new Scanner(System.in);
            input = next.nextLine();
        }

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
