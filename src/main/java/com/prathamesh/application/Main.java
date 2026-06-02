package com.prathamesh.application;

import com.prathamesh.ui.LoginView;
import com.prathamesh.service.BankingService;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Entry point of the Simple Banking Application.
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) {

        // Shared banking service
        BankingService bankingService = new BankingService();

        // Create login screen
        LoginView loginView = new LoginView(bankingService, stage);

        // Create scene
        Scene scene = new Scene(loginView, 400, 300);

        // Configure stage
        stage.setTitle("Simple Banking Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}