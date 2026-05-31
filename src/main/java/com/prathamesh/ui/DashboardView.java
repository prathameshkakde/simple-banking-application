package com.prathamesh.ui;

import com.prathamesh.service.BankingService;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
        Label titleLabel =
                new Label(
                        "Welcome to Your Banking Dashboard"
                );

        titleLabel.setFont(
                new Font(24)
        );

        // Logout button
        Button logoutButton =
                new Button(
                        "Logout"
                );

        logoutButton.setPrefWidth(250);

        // Layout configuration
        setSpacing(20);
        setPadding(new Insets(20));
        setAlignment(Pos.CENTER);

        // Add components
        getChildren().addAll(
                titleLabel,
                logoutButton
        );
    }
}