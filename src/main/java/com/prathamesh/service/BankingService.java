package com.prathamesh.service;

import com.prathamesh.model.Account;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles banking operations and account storage.
 */
public class BankingService {
    // Stores all accounts in memory
    private List<Account> accounts;

    /**
     * Creates the banking service.
     */
    public BankingService() {
        this.accounts = new ArrayList<>();
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

    public Account findAccountByUsername(String username) {

        for (Account account : accounts) {
            if(account.getUsername().equals(username)) {
                return account;
            }
        }
        return null;
    }
}
