package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ToDoList {
    private List<ToDoItem> items;

    public ToDoList() {
        items = new ArrayList<>();
    }

    public void addItem(ToDoItem item) {
        items.add(item);
    }

    public void removeItem(ToDoItem item) {
        items.remove(item);
    }

    public ObservableList<ToDoItem> getItems() {
        return FXCollections.observableList(items);
    }

    public ObservableList<ToDoItem> getItemsDueOn(LocalDate date) {
        List<ToDoItem> dueItems = new ArrayList<>();
        for (ToDoItem item : items) {
            if (item.getDueDate().equals(date)) {
                dueItems.add(item);
            }
        }
        return FXCollections.observableList(dueItems);
    }
}
