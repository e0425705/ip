package duke.task;

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
     * Returns corresponding icon after checking
     * with @param isDone.
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); // return tick or X symbols
    }

    /**
     * Returns String to be printed out in list.
     */
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }

    /**
     * Returns String to be written into storage file.
     */
    public String toFileString() {
        return " " + (isDone ? 1 : 0) + " " + description;
    }
}