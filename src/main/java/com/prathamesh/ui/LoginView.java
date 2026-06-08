package com.prathamesh.ui;

import com.prathamesh.service.BankingService;

import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Represents the login screen UI.
 */
public class LoginView extends VBox {

    private final  BankingService bankingService;

    private final Stage stage;

    /**
     * Creates the login screen.
     */
    public LoginView(BankingService bankingService, Stage stage) {
        this.bankingService = bankingService;
        this.stage = stage;

        // Create title label
        Label title = new Label("Banking Application");
        title.setFont(new Font(28));

        // Message label for login feedback
        Label messageLabel = new Label();

        // Username input field
        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter Username");
        usernameField.setPrefWidth(250);

        // Password input field
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter Password");
        passwordField.setPrefWidth(250);

        // Login button
        Button loginButton = new Button("Login");
        loginButton.setPrefWidth(300);

        // Handle button click
        loginButton.setOnAction(event -> {
            // Read values form fields
            String username = usernameField.getText();
            String password = passwordField.getText();

            // Authenticate user
            boolean authenticated = bankingService.authenticate(username, password);

            if (authenticated) {
                // Store currently logged-in account
                bankingService.setCurrentAccount(bankingService.findAccountByUsername(username));

                DashboardView dashboardView = new DashboardView(bankingService, stage);

                VBox root = new VBox(dashboardView);
                root.setAlignment(Pos.CENTER);
                root.setStyle("-fx-background-color: #F5F5F5;");
                Scene dashboardScene = new Scene(root, 700, 500);
                dashboardScene.getStylesheets().add(getClass().getResource("/styles/application.css").toExternalForm());
                stage.setScene(dashboardScene);
            } else {
                messageLabel.setText("Invalid Username or Password!");
            }
        });

        // Navigate to registration screen
        Button createAccountButton = new Button("Create Account");
        createAccountButton.setPrefWidth(300);

        // Navigate to registration screen
        createAccountButton.setOnAction(event -> {

            RegisterView registerView = new RegisterView(bankingService, stage);
            VBox root = new VBox(registerView);
            root.setAlignment(Pos.CENTER);
            root.setStyle("-fx-background-color: #F5F5F5;");
            Scene registerScene = new Scene(root, 700, 500);
            registerScene.getStylesheets().add(getClass().getResource("/styles/application.css").toExternalForm());
            stage.setScene(registerScene);
        });

        // Configure layout spacing
        setSpacing(20);
        setPadding(new Insets(40));
        setAlignment(Pos.CENTER);
        setMaxWidth(400);
        getStyleClass().add("card");

        // Add all components to VBox
        getChildren().addAll(title, usernameField, passwordField, loginButton, createAccountButton, messageLabel);
    }
}
