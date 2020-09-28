package duke.task;

import static duke.storage.ReadFromFile.DONE;
import static duke.storage.ReadFromFile.NOT_DONE;

/**
 * Represents a Task in the list.
 */
public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Assumption: description of task is not null.
     *
     * @param description Task description input by user.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns description of the task.
     *
     * @return Task description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Marks task as done.
     */
    public void markAsDone() {
        isDone = true;
    }

    /**
     * Returns corresponding symbol after checking with variable isDone.
     *
     * @return Symbol of either a tick or cross.
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); // return tick or X symbols
    }

    /**
     * Returns String to be printed out in list.
     *
     * @return String printed out in list.
     */
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }

    /**
     * Returns String to be written into duke.storage file.
     *
     * @return String written to duke.storage file.
     */
    public String toFileString() {
        return " " + (isDone ? DONE : NOT_DONE) + " " + description;
    }
}