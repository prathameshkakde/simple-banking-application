package com.prathamesh.ui;

import com.prathamesh.service.BankingService;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

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
        titleLabel.setFont(new Font(28));

        // Registration feedback
        Label messageLabel = new Label();

        // Username
        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter username");
        usernameField.setPrefWidth(300);

        // Password
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter password");
        passwordField.setPrefWidth(300);

        // Register button
        Button registerButton = new Button("Register");
        registerButton.setPrefWidth(300);

        registerButton.setOnAction(event -> {

            String username = usernameField.getText();
            String password = passwordField.getText();

            boolean created = bankingService.createAccount(username, password);

            if (created) {
                messageLabel.setText("Account Created Successfully!");
            } else {
                messageLabel.setText("Username Already Exists!");
            }
        });

        // Back button
        Button backToLoginButton = new Button("Back to Login");
        backToLoginButton.setPrefWidth(300);

        backToLoginButton.setOnAction(event -> {

            LoginView loginView = new LoginView(bankingService, stage);
            VBox root = new VBox(loginView);
            root.setAlignment(Pos.CENTER);
            root.setStyle("-fx-background-color: #F5F5F5;");
            Scene loginScene = new Scene(root, 700, 500);
            stage.setScene(loginScene);
        });

        // Layout
        setSpacing(20);
        setPadding(new Insets(40));
        setAlignment(Pos.CENTER);

        setMaxWidth(350);

        setStyle(
                "-fx-background-color: white;" +
                        "-fx-background-radius: 10;" +
                        "-fx-border-radius: 10;" +
                        "-fx-border-color: #DDDDDD;" +
                        "-fx-border-width: 1;" +
                        "-fx-padding: 30;"
        );

        getChildren().addAll(
                titleLabel,
                usernameField,
                passwordField,
                registerButton,
                backToLoginButton,
                messageLabel
        );
    }
}