package com.prathamesh.ui;

import com.prathamesh.service.BankingService;
import com.prathamesh.model.Transaction;

import java.util.Optional;

import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 * Represents the banking dashboard screen.
 */
public class DashboardView extends VBox {

    private final BankingService bankingService;
    private final Stage stage;

    /**
     * Creates the dashboard screen.
     */
    public DashboardView(BankingService bankingService, Stage stage) {
        this.bankingService = bankingService;
        this.stage = stage;

        // Dashboard title
        Label titleLabel = new Label("Banking Dashboard");
        titleLabel.setFont(new Font(28));

        // Balance display
        Label balanceLabel = new Label(String.format("Current Balance: ₹%.2f", bankingService.getCurrentAccount().getBalance()));
        balanceLabel.setFont(new Font(18));

        // Transaction history label
        Label transactionHistoryLabel = new Label("Recent Transaction:");
        transactionHistoryLabel.setFont(new Font(20));

        // Transaction history display
        Label historyContentLabel = new Label("No transactions yet.");
        historyContentLabel.setText(buildTransactionHistory());

        // Deposit button
        Button depositButton = new Button("Deposit");
        depositButton.setPrefWidth(300);

        // Handle deposit button click
        depositButton.setOnAction(event -> {

            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Deposit Money");
            dialog.setHeaderText(null);
            dialog.setContentText("Enter Your Deposit Amount");

            Optional<String> result = dialog.showAndWait();

            result.ifPresent(amount -> {
                if (amount.trim().isEmpty()) {
                    showError("Empty Amount", "Amount cannot be empty.");
                    return;
                }

                double depositAmount;

                try {
                    depositAmount = Double.parseDouble(amount);
                } catch (NumberFormatException exception) {
                    showError("Invalid Amount", "Please enter a valid number.");
                    return;
                }

                if (depositAmount <= 0) {
                    showError("Invalid Amount", "Amount must be greater than zero.");
                    return;
                }

                bankingService.deposit(bankingService.getCurrentAccount().getUsername(), depositAmount);

                historyContentLabel.setText(buildTransactionHistory());

                balanceLabel.setText(String.format("Current Balance: ₹%.2f", bankingService.getCurrentAccount().getBalance()
                        )
                );
            });
        });

        // Withdraw button
        Button withdrawButton = new Button("Withdraw");
        withdrawButton.setPrefWidth(300);

        // Handle withdraw button click
        withdrawButton.setOnAction(event -> {

            TextInputDialog dialog = new TextInputDialog();

            dialog.setTitle("Withdraw Money");

            dialog.setHeaderText(null);

            dialog.setContentText("Enter withdraw amount:");

            Optional<String> result = dialog.showAndWait();

            result.ifPresent(amount -> {
                if (amount.trim().isEmpty()) {
                    showError("Empty Amount", "Amount cannot be empty.");
                    return;
                }

                double withdrawalAmount;

                try {
                    withdrawalAmount = Double.parseDouble(amount);
                } catch (NumberFormatException exception) {
                    showError("Invalid Amount", "Please enter a valid number.");
                    return;
                }

                if (withdrawalAmount <= 0) {
                    showError("Invalid Amount", "Amount must be greater than zero.");
                    return;
                }

                if (
                        bankingService.withdraw(bankingService.getCurrentAccount().getUsername(), withdrawalAmount
                        )
                ) {

                    historyContentLabel.setText(
                            buildTransactionHistory()
                    );

                    balanceLabel.setText(
                            String.format(
                                    "Current Balance: ₹%.2f",
                                    bankingService
                                            .getCurrentAccount()
                                            .getBalance()
                            )
                    );

                } else {
                    showError("Insufficient Funds", "You cannot withdraw more than your available balance.");
                }
            });
        });

        // Logout button
        Button logoutButton = new Button("Logout");
        logoutButton.setPrefWidth(300);

        // Handle logout button click
        logoutButton.setOnAction(event -> {

            LoginView loginView = new LoginView(bankingService, stage);
            VBox root = new VBox(loginView);
            root.setAlignment(Pos.CENTER);
            root.setStyle("-fx-background-color: #F5F5F5;");
            Scene loginScene = new Scene(root, 700, 500);
            loginScene.getStylesheets().add(getClass().getResource("/styles/application.css").toExternalForm());
            stage.setScene(loginScene);
        });

        // Layout configuration
        setSpacing(25);
        setPadding(new Insets(40));
        setAlignment(Pos.CENTER);
        setMaxWidth(500);
        getStyleClass().add("card");

        // Add components
        getChildren().addAll(
                titleLabel,
                balanceLabel,
                transactionHistoryLabel,
                historyContentLabel,
                depositButton,
                withdrawButton,
                logoutButton
        );
    }

    private String buildTransactionHistory() {

        StringBuilder history =
                new StringBuilder();

        for (
                Transaction transaction : bankingService.getCurrentAccount().getTransactions()
        ) {
            history.append(transaction.getType());
            history.append(": ₹");

            history.append(
                    String.format(
                            "%.2f",
                            transaction.getAmount()
                    )
            );

            history.append("\n");
        }

        return history.toString();
    }

    /**
     * Displays an error dialog.
     *
     * @param title alert title
     * @param message alert message
     */
    private void showError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}