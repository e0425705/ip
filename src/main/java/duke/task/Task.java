package duke.task;

/**
 * Represents a task in the list.
 */
public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Assumption: description of task is not null.
     *
     * @param description task description input by user
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns the description of the task.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Marks the task as done.
     */
    public void markAsDone() {
        isDone = true;
    }

    /**
     * Checks with @param isDone and
     * returns the corresponding icon.
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
     * Returns String to be written into storage.
     */
    public String toFileString() {
        return " " + (isDone ? 1 : 0) + " " + description;
    }
}