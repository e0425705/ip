package duke.task;

public class Event extends Task {
    protected String at;

    /**
     * Subclass of class Task.
     *
     * @param description task description input by user
     * @param at date and time of task input by user
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