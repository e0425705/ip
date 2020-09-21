package parser;

import duke.Duke;
import duke.task.Task;

import java.util.Scanner;

import static tasklist.TaskList.findKeyword;
import static ui.Ui.displayByeMessage;
import static ui.Ui.displayCaseEmptyInput;
import static ui.Ui.displayDeadline;
import static ui.Ui.displayDeleteMessage;
import static ui.Ui.displayDone;
import static ui.Ui.displayEvent;
import static ui.Ui.displayExceptionMessage;
import static ui.Ui.displayFind;
import static ui.Ui.displayHelpMessage;
import static ui.Ui.displayList;
import static ui.Ui.displaySaveMessage;
import static ui.Ui.displayStringIndexOutOfBoundsExceptionMessage;
import static ui.Ui.displayToDo;
import static ui.Ui.drawLines;

/**
 * deals with making sense of the user command
 */
public class Parser extends Duke {
    /**
     *
     */
    public static int decideAction(Scanner input, int listIndex) {
        while (true) {
            String userInput = input.nextLine();
            String[] givenCommand = userInput.split(" ");

            givenCommand[0] = parseToLowerCase(givenCommand[0]);
            try {
                if (userInput.trim().isEmpty()) {
                    displayCaseEmptyInput();
                } else if (givenCommand[0].equals("list")) {
                    displayList(listIndex);
                } else if (givenCommand[0].equals("done")) {
                    displayDone(givenCommand[1]);
                } else if (givenCommand[0].equals("todo")) {
                    listIndex = displayToDo(userInput, listIndex);
                } else if (givenCommand[0].equals("deadline")) {
                    listIndex = displayDeadline(userInput, listIndex);
                } else if (givenCommand[0].equals("event")) {
                    listIndex = displayEvent(userInput, listIndex);
                } else if (givenCommand[0].trim().equals("bye")) {
                    displayByeMessage();
                    break;
                } else if (givenCommand[0].trim().equals("save")) {
                    displaySaveMessage();
                } else if (givenCommand[0].trim().equals("find")) {
                    displayFind(userInput, listIndex);
                } else if (givenCommand[0].trim().equals("help")) {
                    displayHelpMessage();
                } else if (givenCommand[0].trim().equals("delete")) {
                    listIndex = displayDeleteMessage(listIndex, givenCommand[1]);
                } else {
                    displayExceptionMessage();
                }
            } catch (StringIndexOutOfBoundsException e) {
                displayStringIndexOutOfBoundsExceptionMessage();
            } catch (Exception e) {
                displayExceptionMessage();
            }
        }
        return listIndex;
    }

    public static String parseToLowerCase(String givenCommand) {
        givenCommand = givenCommand.toLowerCase();

        return givenCommand;
    }
}
