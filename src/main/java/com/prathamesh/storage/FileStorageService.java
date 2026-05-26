package com.prathamesh.storage;

import java.io.FileWriter;
import java.io.IOException;
import com.prathamesh.model.Account;

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
}
