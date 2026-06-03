package com.prathamesh.ui;

import com.prathamesh.service.BankingService;
import com.prathamesh.model.Transaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.application.Platform;
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
    private double balance = 0.0;
    private final List<Transaction> transactions = new ArrayList<>();

    /**
     * Creates the dashboard screen.
     */
    public DashboardView(BankingService bankingService, Stage stage) {
        this.bankingService = bankingService;
        this.stage = stage;

        // Dashboard title
        Label titleLabel = new Label("Welcome to Your Banking Dashboard");
        titleLabel.setFont(new Font(24));

        // Balance display
        Label balanceLabel = new Label("Current Balance: ₹0.00");
        balanceLabel.setFont(new Font(18));

        // Transaction history label
        Label transactionHistoryLabel = new Label("Transaction History:");
        transactionHistoryLabel.setFont(new Font(18));

        // Transaction history display
        Label historyContentLabel = new Label("No transactions yet.");

        // Deposit button
        Button depositButton = new Button("Deposit");
        depositButton.setPrefWidth(250);

        // Handle deposit button click
        depositButton.setOnAction(event -> {

            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Deposit Money");
            dialog.setHeaderText(null);
            dialog.setContentText("Enter Your Deposit Amount");

            Optional<String> result = dialog.showAndWait();

            result.ifPresent(amount -> {

                double depositAmount = Double.parseDouble(amount);

                balance += depositAmount;
                Transaction transaction = new Transaction("Deposit", depositAmount);
                transactions.add(transaction);
                historyContentLabel.setText(buildTransactionHistory());
                balanceLabel.setText(String.format("Current Balance: %.2f", balance));
            });
        });

        // Withdraw button
        Button withdrawButton = new Button("Withdraw");
        withdrawButton.setPrefWidth(250);

        // Handle withdraw button click
        withdrawButton.setOnAction(event -> {

            TextInputDialog dialog = new TextInputDialog();

            dialog.setTitle("Withdraw Money");

            dialog.setHeaderText(null);

            dialog.setContentText("Enter withdraw amount:");

            Optional<String> result = dialog.showAndWait();

            result.ifPresent(amount -> {

                double withdrawalAmount = Double.parseDouble(amount);

                if(withdrawalAmount <= balance) {
                    balance -= withdrawalAmount;
                    Transaction transaction = new Transaction("Withdraw", withdrawalAmount);
                    transactions.add(transaction);
                    historyContentLabel.setText(buildTransactionHistory());
                    balanceLabel.setText(String.format("Current Balance: ₹%.2f", balance));
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Insufficient Funds");
                    alert.setHeaderText(null);
                    alert.setContentText("You cannot withdraw more than your available balance.");
                    alert.showAndWait();
                }
            });
        });

        // Logout button
        Button logoutButton = new Button("Logout");
        logoutButton.setPrefWidth(250);

        // Handle logout button click
        logoutButton.setOnAction(event -> {

            LoginView loginView = new LoginView(bankingService, stage);

            Scene loginScene = new Scene(loginView, 400, 300);

            stage.setScene(loginScene);
        });

        // Layout configuration
        setSpacing(20);
        setPadding(new Insets(20));
        setAlignment(Pos.CENTER);

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

        StringBuilder history = new StringBuilder();

        for(Transaction transaction : transactions) {
            history.append(transaction.getType());
            history.append(": ₹");
            history.append(String.format("%.2f", transaction.getAmount()));
            history.append("\n");
        }
        return history.toString();
    }
}