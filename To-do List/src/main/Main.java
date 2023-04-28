package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ToDoList toDoList = new ToDoList();
        ToDoListView toDoListView = new ToDoListView(toDoList);

        Scene scene = new Scene(toDoListView, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("To-Do List");
        primaryStage.show();
    }
}

