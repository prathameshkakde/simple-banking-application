package com.prathamesh.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a bank account in the application
 */
public class Account {

    // Username used for login
    private String username;

    // User password
    private String password;

    // Current account balance
    private double balance;

    // Stores all account transactions
    private List<Transaction> transactions;

    /**
     * Constructor used to create a new account
     *
     * @param username
     * @param password
     * @param balance
     */
    public  Account(String username, String password, double balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    // Getter for username
    public String getUsername() {
        return username;
    }

    // Setter for username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Setter for balance
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     *
     * @return transaction history
     */
    public List<Transaction> getTransactions() {
        return transactions;
    }

    /**
     * Adds a transaction to the account history.
     * @param transaction
     */
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}
