package duke.task;

public class Deadline extends Task {
    protected String by;

    /**
     * Subclass of class Task.
     *
     * @param description task description input by user
     * @param by date and time of task input by user
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

    @Override
    public String toFileString() {
        return "D" + super.toFileString() + " | " + by;
    }
}