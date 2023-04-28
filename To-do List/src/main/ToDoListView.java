package main;

import java.time.LocalDate;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ToDoListView extends BorderPane {
    private DatePicker datePicker;
    private TextField descriptionField;
    private ListView<ToDoItem> toDoListView;
    private Label statusLabel;

    public ToDoListView(ToDoList toDoList) {
        datePicker = new DatePicker();
        descriptionField = new TextField();
        toDoListView = new ListView<>();
        statusLabel = new Label();

        toDoListView.setItems(toDoList.getItems());
        toDoListView.setPrefHeight(300);

        statusLabel.textProperty().bind(Bindings.createStringBinding(() -> {
            if (toDoListView.getItems().isEmpty()) {
                return "No to-do items";
            } else {
                return "Total: " + toDoListView.getItems().size();
            }
        }, toDoListView.getItems()));

        datePicker.setOnAction(event -> {
            LocalDate selectedDate = datePicker.getValue();
            toDoListView.setItems(toDoList.getItemsDueOn(selectedDate));
        });

        Button addButton = new Button("Add");
        addButton.setOnAction(event -> {
            String description = descriptionField.getText();
            LocalDate dueDate = datePicker.getValue();
            if (description != null && !description.isEmpty() && dueDate != null) {
                ToDoItem newItem = new ToDoItem(description, dueDate);
                toDoList.addItem(newItem);
                descriptionField.clear();
                datePicker.setValue(null);
                toDoListView.setItems(toDoList.getItems());
            }
        });

        Button removeButton = new Button("Remove");
        removeButton.setOnAction(event -> {
            ToDoItem selectedItem = toDoListView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                toDoList.removeItem(selectedItem);
            }
        });

        HBox dateBox = new HBox(10, new Label("Due Date:"), datePicker);
        HBox inputBox = new HBox(10, new Label("Description:"), descriptionField, addButton);
        inputBox.setPadding(new Insets(0, 10, 0, 0));
        VBox controlBox = new VBox(10, dateBox, inputBox, removeButton);
        setLeft(controlBox);
        setCenter(toDoListView);
        setBottom(statusLabel);
        setPadding(new javafx.geometry.Insets(10));
    }
}

