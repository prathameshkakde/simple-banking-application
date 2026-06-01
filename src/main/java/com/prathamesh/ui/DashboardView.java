package com.prathamesh.ui;

import com.prathamesh.service.BankingService;
import java.util.Optional;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 * Represents the banking dashboard screen.
 */
public class DashboardView extends VBox {

    private final BankingService bankingService;
    private final Stage stage;
    private double balance = 0.0;

    /**
     * Creates the dashboard screen.
     */
    public DashboardView(BankingService bankingService, Stage stage) {
        this.bankingService = bankingService;
        this.stage = stage;

        // Dashboard title
        Label titleLabel =
                new Label(
                        "Welcome to Your Banking Dashboard"
                );

        titleLabel.setFont(
                new Font(24)
        );

        // Balance display
        Label balanceLabel = new Label("Current Balance: ₹0.00");
        balanceLabel.setFont(new Font(18));

        // Logout button
        Button logoutButton = new Button("Logout");
        logoutButton.setPrefWidth(250);

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
                balanceLabel.setText(String.format("Current Balance: %.2f", balance));
            });
        });

        // Layout configuration
        setSpacing(20);
        setPadding(new Insets(20));
        setAlignment(Pos.CENTER);

        // Add components
        getChildren().addAll(
                titleLabel,
                balanceLabel,
                depositButton,
                logoutButton
        );
    }
}