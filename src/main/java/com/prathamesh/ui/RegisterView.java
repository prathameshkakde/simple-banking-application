package com.prathamesh.ui;

import com.prathamesh.service.BankingService;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 * Represents the registration screen UI.
 */
public class RegisterView extends VBox {

    /**
     * Creates the registration screen.
     */
    public RegisterView(){

        // Banking service instance
        BankingService bankingService = new BankingService();

        // Title
        Label titleLabel = new Label("Create a New Account");
        titleLabel.setFont(new Font(24));

        // Registration feedback
        Label messageLabel = new Label();

        // Username field
        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter username");
        usernameField.setPrefWidth(250);

        // Password field
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter password");
        passwordField.setPrefWidth(250);

        // Register button
        Button registerButton = new Button("Register");
        registerButton.setPrefWidth(250);

        // Handle registration
        registerButton.setOnAction(event -> {

            String username =
                    usernameField.getText();

            String password =
                    passwordField.getText();

            boolean created =
                    bankingService.createAccount(
                            username,
                            password
                    );

            if (created) {

                messageLabel.setText(
                        "Account Created Successfully!"
                );

            } else {

                messageLabel.setText(
                        "Username Already Exists!"
                );
            }
        });

        // Layout configuration
        setSpacing(15);
        setPadding(new Insets(20));
        setAlignment(Pos.CENTER);

        // Add components
        getChildren().addAll(titleLabel,usernameField,passwordField,registerButton, messageLabel);
    }
}
