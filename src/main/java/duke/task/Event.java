package duke.task;

public class Event extends Task {
    protected String at;

    /**
     * Subclass of class Task.
     *
     * @param description Task description input by user.
     * @param at Date and time of task type {@code Event} input by user.
     */
    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }

    @Override
    public String toFileString() {
        return "E" + super.toFileString() + " | " + at;
    }
}