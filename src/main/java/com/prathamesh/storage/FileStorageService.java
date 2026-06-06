package com.prathamesh.storage;

import com.prathamesh.model.Account;
import com.prathamesh.model.Transaction;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

/**
 * Handles saving and loading banking data.
 */
public class FileStorageService {

    /**
     * Creates a file storage service.
     */
    public FileStorageService() {
    }

    /**
     * Writes a simple test message to the storage file.
     */
    public void writeTestData() {

        try (FileWriter writer = new FileWriter("data/accounts.txt")) {

            writer.write("Banking Application Storage Test" + System.lineSeparator());

        } catch (IOException exception) {

            exception.printStackTrace();

        }
    }

    /**
     * Saves a single account to the file.
     *
     * @param account account to save
     */
    public void saveAccount(Account account) {

        try (FileWriter writer =
                new FileWriter(
                        "data/accounts.txt",
                        true
                        )) {

            writer.write(
                    account.getUsername()
                            + ","
                            + account.getPassword()
                            + ","
                            + account.getBalance()
                            + System.lineSeparator()
            );

        } catch (IOException exception) {

            exception.printStackTrace();
        }
    }

    public void saveTransaction(String username, Transaction transaction) {
        try (FileWriter writer = new FileWriter("data/transactions.txt", true)) {
            writer.write(username
                    + ","
                    + transaction.getType()
                    + ","
                    + transaction.getAmount()
                    + ","
                    + transaction.getTimestamp()
                    + System.lineSeparator()
            );
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Reads and prints all lines from the storage file.
     */
    public void readTestData() {

        try (BufferedReader reader =
                new BufferedReader(
                        new FileReader(
                                "data/accounts.txt"
                        ))) {

            String  line;

            while ((line = reader.readLine()) != null) {

                System.out.println(line);
            }

        } catch (IOException exception) {

            exception.printStackTrace();
        }
    }

    /**
     * Loads and prints account objects
     * from the storage file.
     */
    public List<Account> loadAccounts() {
        List<Account> accounts = new ArrayList<>();

        try (BufferedReader reader =
                new BufferedReader(
                        new FileReader(
                                "data/accounts.txt"
                        ))) {

            String  line;

            while ((line = reader.readLine()) != null) {

                // Split csv data
                String[] parts = line.split(",");

                // Extract values
                String username = parts[0];
                String password = parts[1];

                // Convert String to double
                double balance = Double.parseDouble(parts[2]);

                // Create Account object
                Account account = new Account(username, password, balance);
                accounts.add(account);

                // Display loaded account
                System.out.println("Loaded Account -> " + account.getUsername() + ", Balance: " + account.getBalance());
            }
        } catch (IOException exception) {

            exception.printStackTrace();
        }
        return accounts;
    }

    /**
     * Loads transactions from the transaction file.
     *
     * @return list of transactions
     */
    public List<String[]> loadTransactions() {
        List<String[]> transactions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("data/transactions.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                transactions.add(line.split(","));
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return transactions;
    }

    /**
     * Saves all accounts to the storage file.
     *
     * @param accounts accounts to save
     */
    public void saveAllAccounts(
            List<Account> accounts
    ) {

        try (
                FileWriter writer = new FileWriter("data/accounts.txt")
        ) {

            for (Account account : accounts) {
                writer.write(
                        account.getUsername()
                                + ","
                                + account.getPassword()
                                + ","
                                + account.getBalance()
                                + System.lineSeparator()
                );
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
