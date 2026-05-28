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

/**
 * Represents the login screen UI.
 */
public class LoginView extends VBox {

    /**
     * Creates the login screen.
     */
    public LoginView() {

        // Banking service instance
        BankingService bankingService = new BankingService();

        // Create sample account for testing
        bankingService.createAccount("prathamesh", "password123");

        // Create title label
        Label title = new Label("Simple Banking Application");
        title.setFont(new Font(20));

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
        loginButton.setPrefWidth(250);

        // Handle button click
        loginButton.setOnAction(event -> {

            // Read values form fields
            String username = usernameField.getText();
            String password = passwordField.getText();

            // Authenticate user
            boolean authenticated = bankingService.authenticate(username, password);

            if (authenticated) {
                messageLabel.setText("Login Successful");
            } else {
                messageLabel.setText("Invalid Username or Password!");
            }
        });

        // Configure layout spacing
        setSpacing(15);
        setPadding(new Insets(20));

        // Center all components
        setAlignment(Pos.CENTER);

        // Add all components to VBox
        getChildren().addAll(title, usernameField, passwordField, loginButton, messageLabel);
    }
}
