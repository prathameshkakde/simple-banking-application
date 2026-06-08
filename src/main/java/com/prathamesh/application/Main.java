package com.prathamesh.application;

import com.prathamesh.ui.LoginView;
import com.prathamesh.service.BankingService;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
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
        VBox root = new VBox(loginView);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #F5F5F5;");
        Scene scene = new Scene(root, 700, 500);
        scene.getStylesheets().add(getClass().getResource("/styles/application.css").toExternalForm());

        // Configure stage
        stage.setTitle("Simple Banking Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}