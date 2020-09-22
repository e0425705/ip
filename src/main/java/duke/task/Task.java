package duke.task;

/**
 *
 */
public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns the description of the task
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     */
    public void markAsDone() {
        isDone = true;
    }

    /**
     *
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); // return tick or X symbols
    }

    /**
     *
     */
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }

    /**
     *
     */
    public String toFileString() {
        return " " + (isDone ? 1 : 0) + " " + description;
    }
}