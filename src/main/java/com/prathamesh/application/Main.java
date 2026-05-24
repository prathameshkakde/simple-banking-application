package com.prathamesh.application;

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

        boolean firstAccount =
                bankingService.createAccount(
                        "prathamesh",
                        "password123"
                );

        boolean duplicateAccount =
                bankingService.createAccount(
                        "prathamesh",
                        "anotherPassword"
                );

        System.out.println(
                "First account created: " + firstAccount
        );

        System.out.println(
                "Duplicate account created: " + duplicateAccount
        );

        Account account =
                bankingService.findAccountByUsername(
                        "prathamesh"
                );

        System.out.println(
                "Found account: " + account.getUsername()
        );
    }
}