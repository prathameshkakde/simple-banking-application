package com.prathamesh.service;

import com.prathamesh.model.Account;
import com.prathamesh.model.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles banking operations and account storage.
 */
public class BankingService {
    // Stores all accounts in memory
    private List<Account> accounts;

    // Currently logged-in account
    private Account currentAccount;

    /**
     * Creates the banking service.
     */
    public BankingService() {
        this.accounts = new ArrayList<>();
        this.currentAccount = null;
    }

    /**
     * Returns all accounts.
     *
     * @return list of accounts
     */
    public List<Account> getAccounts() {
        return accounts;
    }

    /**
     * Returns the currently logged-in account.
     *
     * @return current account
     */
    public Account getCurrentAccount() {
        return currentAccount;
    }

    /**
     * Sets the currently logged-in account.
     *
     * @param currentAccount account to set
     */
    public void setCurrentAccount(Account currentAccount) {
        this.currentAccount = currentAccount;
    }

    /**
     *  Creates a new account and stores it
     *
     * @param username
     * @param password
     */
    public boolean createAccount(String  username, String password) {

        // Check whether username already exists
        if (findAccountByUsername(username) != null) {
            return false;
        }

        // Create new account
        Account account = new Account(
                username,
                password,
                0.0
        );

        // Store account
        accounts.add(account);

        return true;
    }

    /**
     * Finds account by username
     *
     * @param username
     * @return
     */
    public Account findAccountByUsername(String username) {

        for (Account account : accounts) {
            if(account.getUsername().equals(username)) {
                return account;
            }
        }
        return null;
    }

    /**
     * Validates login credentials
     *
     * @param username
     * @param password
     * @return
     */
    public boolean authenticate(String username, String password) {

        Account account = findAccountByUsername(username);

        if (account == null) {
            return false;
        }

        return account.getPassword().equals(password);
    }

    /**
     * Deposits money into an account.
     *
     * @param username account username
     * @param amount amount to deposit
     * @return true if successful, false otherwise
     */
    public boolean deposit(String username, double amount) {

        // Deposit amount must be positive
        if (amount <= 0) {
            return false;
        }

        Account account = findAccountByUsername(username);

        if (account == null) {
            return false;
        }

        // Update balance
        account.setBalance(account.getBalance() + amount);

        // Record transaction
        account.addTransaction(new Transaction("Deposit", amount));

        return true;
    }

    /**
     * Withdraws money from an account.
     *
     * @param username account username
     * @param amount amount to withdraw
     * @return true if successful, false otherwise
     */
    public boolean withdraw(String username, double amount) {

        // Withdrawal amount must be positive
        if (amount <= 0) {
            return false;
        }

        Account account = findAccountByUsername(username);

        if (account == null) {
            return false;
        }

        // Check sufficient balance
        if (account.getBalance() < amount) {
            return false;
        }

        // Deduct amount
        account.setBalance(account.getBalance() - amount);

        // Record transaction
        account.addTransaction(new Transaction("Withdraw", amount));

        return true;
    }
}
