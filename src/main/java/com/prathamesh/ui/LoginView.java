package com.prathamesh.ui;

import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
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

        // Create title label
        Label title = new Label("Simple Banking Application");

        // Username input field
        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter Username");

        // Password input field
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter Password");

        // Login button
        Button loginButton = new Button("Login");

        // Configure layout spacing
        setSpacing(15);

        // Center all components
        setAlignment(Pos.CENTER);

        // Add all components to VBox
        getChildren().addAll(title, usernameField, passwordField, loginButton);
    }
}
