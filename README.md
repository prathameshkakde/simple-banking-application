# 🏦 Simple Banking Application

## Project Overview

The Simple Banking Application is a desktop application built using Java and JavaFX. It allows users to create accounts, log in securely, perform banking transactions, and persist account data between application sessions.

This project was developed as part of a Java learning journey focused on Object-Oriented Programming, File Handling, JavaFX, Maven, Git, and software engineering best practices.

---

## Features

### Account Management

* Create a new account
* User login authentication
* Prevent duplicate usernames

### Banking Operations

* Deposit money
* Withdraw money
* View current balance

### Transaction History

* Record deposits and withdrawals
* Display transaction history
* Persist transaction history between application sessions

### Data Persistence

* Save accounts to file storage
* Save balances to file storage
* Save transaction history to file storage
* Reload data when the application starts

### Input Validation

* Prevent empty inputs
* Prevent invalid numeric values
* Prevent negative amounts
* Prevent zero-value transactions
* Prevent withdrawals exceeding account balance

### User Interface

* JavaFX desktop application
* Login screen
* Registration screen
* Banking dashboard
* Modern card-based UI
* CSS styling support

---

## Technologies Used

* Java 17
* JavaFX
* Maven
* File I/O
* CSS
* Git
* GitHub

---

## Project Structure

src/main/java

* application

    * Main.java

* model

    * Account.java
    * Transaction.java

* service

    * BankingService.java

* storage

    * FileStorageService.java

* ui

    * LoginView.java
    * RegisterView.java
    * DashboardView.java

---

## How to Run

### Clone the Repository

git clone <repository-url>

### Navigate to the Project

cd simple-banking-application

### Run Using Maven

mvn javafx:run

---

## Learning Outcomes

This project helped reinforce:

* Object-Oriented Programming (OOP)
* Classes and Objects
* Encapsulation
* Collections Framework
* File Handling
* JavaFX UI Development
* Input Validation
* Maven Build Management
* Git Workflow
* Basic Software Architecture

---

## Future Improvements

* Money transfer between accounts
* Database integration
* Password encryption
* Unit testing with JUnit
* Improved transaction history table
* Executable installer packaging

---

## 👨‍💻 Author

**Prathamesh Kakde**
🔗 https://github.com/prathameshkakde

