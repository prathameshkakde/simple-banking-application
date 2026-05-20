package com.prathamesh;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Entry point of the Simple Banking Application.
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) {

        // Text displayed in the window
        Label welcomeLabel =
                new Label("Welcome to Simple Banking Application");

        // Create scene
        Scene scene = new Scene(welcomeLabel, 500, 300);

        // Configure window
        stage.setTitle("Simple Banking Application");
        stage.setScene(scene);

        // Show window
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}