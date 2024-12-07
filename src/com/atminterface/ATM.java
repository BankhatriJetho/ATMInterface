package com.atminterface;

import java.util.List;
import java.util.Scanner;

public class ATM {
    private Bank bank;
    private String currentUserId;
    private Scanner scanner;

    public ATM(Bank bank) {
        this.bank = bank;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("==== Welcome to the ATM ====");
        login();
        if (currentUserId != null) {
            showMenu();
        }
    }

    private void login() {
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine().trim();
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine().trim();

        if (bank.authenticateUser(userId, pin)) {
            currentUserId = userId;
            System.out.println("Login successful. Welcome, " + bank.getAccountHolder(currentUserId).getName() + "!");
        } else {
            System.out.println("Invalid user ID or PIN. Please try again.");
        }
    }

    private void showMenu() {
        int choice = -1;
        while (choice != 5) {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Show Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Choose an option: ");
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                continue;
            }

            switch (choice) {
                case 1:
                    showTransactionHistory();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    transfer();
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
    }

    private void showTransactionHistory() {
        Account account = bank.getAccount(currentUserId);
        List<BankTransaction> transactions = account.getTransactionHistory();
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            System.out.println("Transaction History:");
            for (BankTransaction t : transactions) {
                System.out.println(t);
            }
        }
    }

    private void withdraw() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = Double.parseDouble(scanner.nextLine().trim());
        Account account = bank.getAccount(currentUserId);
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. New balance: " + account.getBalance());
        }
    }

    private void deposit() {
        System.out.print("Enter the amount to deposit: ");
        double amount = Double.parseDouble(scanner.nextLine().trim());
        Account account = bank.getAccount(currentUserId);
        try {
            account.deposit(amount);
            System.out.println("Deposit successful. New balance: " + account.getBalance());
        } catch (IllegalArgumentException e) {
            System.out.println("Deposit failed: " + e.getMessage());
        }
    }

    private void transfer() {
        System.out.print("Enter the user ID to transfer to: ");
        String toUserId = scanner.nextLine().trim();
        System.out.print("Enter the amount to transfer: ");
        double amount = Double.parseDouble(scanner.nextLine().trim());

        if (bank.transferFunds(currentUserId, toUserId, amount)) {
            System.out.println("Transfer successful.");
            System.out.println("Your new balance: " + bank.getAccount(currentUserId).getBalance());
        } else {
            System.out.println("Transfer failed. Check the user ID or your balance.");
        }
    }
}

