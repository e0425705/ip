package duke.task;

public class Deadline extends Task {
    protected String by;

    /**
     * Subclass of class Task.
     *
     * @param description Task description input by user.
     * @param by Date and time of task type {@code Deadline} input by user.
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