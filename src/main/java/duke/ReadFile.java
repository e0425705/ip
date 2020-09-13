package duke;

import duke.task.Task;
import duke.task.ToDo;
import duke.task.Event;
import duke.task.Deadline;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile extends Duke {
    private static void printFileContents(String filePath) throws FileNotFoundException {
        File f = new File(filePath); // create a File for the given file path
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        while (s.hasNext()) {
            // System.out.println(s.nextLine());
            String userInput = s.nextLine();
            String[] savedCommand = userInput.split(" ");
            switch (savedCommand[1]){
            case "|T|":
                Task todoItem = new ToDo(savedCommand[2]);
                tasks.add(todoItem);
            case "|E|":
                Task eventItem = new Event(savedCommand[2], savedCommand[3]);
                tasks.add(eventItem);
            case "|D|":
                Task deadlineItem = new Deadline(savedCommand[2], savedCommand[3].substring(1));
                tasks.add(deadlineItem);
            }
        }
    }

    public static void main(String[] args) {
        try {
            printFileContents("duke.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
