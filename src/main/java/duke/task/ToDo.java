package duke.task;

public class ToDo extends Task {
    /**
     * Subclass of class Task.
     *
     * @param description Task description input by user.
     */
    public ToDo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    @Override
    public String toFileString() {
        return "T" + super.toFileString();
    }
}