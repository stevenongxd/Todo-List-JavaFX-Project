package main;

import java.time.LocalDate;

public class ToDoItem {
    private String description;
    private LocalDate dueDate;

    public ToDoItem(String description, LocalDate dueDate) {
        this.description = description;
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    @Override
    public String toString() {
        return description + " (due " + dueDate + ")";
    }
}
