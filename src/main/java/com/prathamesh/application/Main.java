package com.prathamesh.application;

import com.prathamesh.model.Transaction;
import com.prathamesh.service.BankingService;
import com.prathamesh.model.Account;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Entry point of the Simple Banking Application.
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) {

        // Text displayed in the window
        Label welcomeLabel =
                new Label("Welcome to Simple Banking Application");

        // Create scene
        Scene scene = new Scene(welcomeLabel, 500, 300);

        // Configure window
        stage.setTitle("Simple Banking Application");
        stage.setScene(scene);

        // Show window
        stage.show();
    }

    public static void main(String[] args) {

        BankingService bankingService = new BankingService();

        // Create account
        bankingService.createAccount(
                "prathamesh",
                "password123"
        );

        // Deposit money
        boolean depositSuccessful =
                bankingService.deposit(
                        "prathamesh",
                        500
                );

        System.out.println(
                "Deposit Successful: " +
                        depositSuccessful
        );

        // Valid withdrawal
        boolean withdrawalSuccessful =
                bankingService.withdraw(
                        "prathamesh",
                        200
                );

        System.out.println(
                "Withdrawal Successful: " +
                        withdrawalSuccessful
        );

        // Attempt withdrawal larger than balance
        boolean largeWithdrawal =
                bankingService.withdraw(
                        "prathamesh",
                        1000
                );

        System.out.println(
                "Large Withdrawal Successful: " +
                        largeWithdrawal
        );

        // Display account information
        Account account =
                bankingService.findAccountByUsername(
                        "prathamesh"
                );

        System.out.println(
                "\nCurrent Balance: " +
                        account.getBalance()
        );

        System.out.println("\nTransaction History:");

        for (Transaction transaction :
                account.getTransactions()) {

            System.out.println(
                    transaction.getType() +
                            " - " +
                            transaction.getAmount()
            );
        }
    }
}