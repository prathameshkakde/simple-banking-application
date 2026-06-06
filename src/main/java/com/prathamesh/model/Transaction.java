package com.prathamesh.model;

import java.time.LocalDateTime;

/**
 * Represents a banking transaction.
 */
public class Transaction {

    // Type of transaction (Deposit / Withdrawal)
    private String type;

    // Amount involved in the transaction
    private double amount;

    // Date and time when transaction occurred
    private LocalDateTime timestamp;

    /**
     * Creates a new transaction
     *
     * @param type
     * @param amount
     */
    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;

        // Automatically store current date and time
        this.timestamp = LocalDateTime.now();
    }

    /**
     * Creates a transaction using an existing timestamp.
     *
     * @param type transaction type
     * @param amount transaction amount
     * @param timestamp original timestamp
     */
    public Transaction(String type, double amount, LocalDateTime timestamp) {
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    // Getter for type
    public String getType() {
        return type;
    }

    // Setter for type
    public void setType(String type) {
        this.type = type;
    }

    // Getter for amount
    public double getAmount() {
        return amount;
    }

    // Setter for amount
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * @return transaction timestamp
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
