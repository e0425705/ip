package duke.parser;

import duke.Duke;

import java.util.Scanner;

import static duke.ui.Ui.displayByeMessage;
import static duke.ui.Ui.displayCaseEmptyInput;
import static duke.ui.Ui.displayDeadlineError;
import static duke.ui.Ui.displayDeleteMessage;
import static duke.ui.Ui.displayDone;
import static duke.ui.Ui.displayEventError;
import static duke.ui.Ui.displayExceptionMessage;
import static duke.ui.Ui.displayFind;
import static duke.ui.Ui.displayHelpMessage;
import static duke.ui.Ui.displayList;
import static duke.ui.Ui.displaySaveMessage;
import static duke.ui.Ui.displayStringIndexOutOfBoundsExceptionMessage;
import static duke.ui.Ui.displayToDo;

/**
 * Deals with making sense of the user command.
 */
public class Parser extends Duke {
    /** Accesses the command type input by user */
    public static final int COMMAND = 0;

    /**
     * Parses user input into command for execution.
     * Returns updated index of list so that it can be updated in Duke.main.
     *
     * @param input     Full user input string.
     * @param listIndex Number of tasks in list.
     * @return Updated listIndex.
     * @throws StringIndexOutOfBoundsException When user input has missing or erroneous fields.
     * @throws Exception                       When user input is not understood.
     */
    public static int decideAction(Scanner input, int listIndex) {
        while (true) {
            String userInput = input.nextLine();
            String[] givenCommand = userInput.split(" ");

            givenCommand[COMMAND] = parseToLowerCase(givenCommand[COMMAND]);
            try {
                if (userInput.trim().isEmpty()) {
                    displayCaseEmptyInput();
                } else if (givenCommand[COMMAND].equals("list")) {
                    displayList(listIndex);
                } else if (givenCommand[COMMAND].equals("done")) {
                    displayDone(givenCommand[1]);
                } else if (givenCommand[COMMAND].equals("todo")) {
                    listIndex = displayToDo(userInput, listIndex);
                } else if (givenCommand[COMMAND].equals("deadline")) {
                    listIndex = displayDeadlineError(userInput, listIndex);
                } else if (givenCommand[COMMAND].equals("event")) {
                    listIndex = displayEventError(userInput, listIndex);
                } else if (givenCommand[COMMAND].trim().equals("bye")) {
                    displayByeMessage();
                    break;
                } else if (givenCommand[COMMAND].trim().equals("save")) {
                    displaySaveMessage();
                } else if (givenCommand[COMMAND].trim().equals("find")) {
                    displayFind(userInput, listIndex);
                } else if (givenCommand[COMMAND].trim().equals("help")) {
                    displayHelpMessage();
                } else if (givenCommand[COMMAND].trim().equals("delete")) {
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

    private static String parseToLowerCase(String givenCommand) {
        givenCommand = givenCommand.toLowerCase();

        return givenCommand;
    }
}
