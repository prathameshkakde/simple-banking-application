package com.prathamesh.application;

import com.prathamesh.ui.RegisterView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Entry point of the Simple Banking Application.
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) {

        // Create login screen
        RegisterView registerView = new RegisterView();

        // Create scene
        Scene scene = new Scene(registerView, 400, 300);

        // Configure stage
        stage.setTitle("Simple Banking Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}