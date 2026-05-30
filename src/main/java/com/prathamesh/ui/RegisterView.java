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
import javafx.stage.Stage;
import javafx.scene.Scene;

/**
 * Represents the registration screen UI.
 */
public class RegisterView extends VBox {

    private final BankingService bankingService;

    private final Stage stage;

    /**
     * Creates the registration screen.
     */
    public RegisterView(BankingService bankingService, Stage stage) {

        this.bankingService = bankingService;
        this.stage = stage;

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

        // Navigate back to login screen
        Button backToLoginButton = new Button("Back to Login");
        backToLoginButton.setPrefWidth(250);

        // Navigate back to login screen
        backToLoginButton.setOnAction(event -> {

            LoginView loginView =
                    new LoginView(
                            bankingService,
                            stage
                    );

            Scene loginScene =
                    new Scene(
                            loginView,
                            400,
                            300
                    );

            stage.setScene(
                    loginScene
            );
        });

        // Layout configuration
        setSpacing(15);
        setPadding(new Insets(20));
        setAlignment(Pos.CENTER);

        // Add components
        getChildren().addAll(titleLabel,usernameField,passwordField,registerButton, backToLoginButton, messageLabel);
    }
}
