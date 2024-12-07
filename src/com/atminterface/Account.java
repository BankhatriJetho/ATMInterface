package com.atminterface;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Account {
    private String accountNumber;
    private double balance;
    private List<BankTransaction> transactionHistory;

    public Account() {
        this.accountNumber = "ACC-" + UUID.randomUUID().toString().substring(0, 6);
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // Deposit money into the account
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance += amount;
        transactionHistory.add(new BankTransaction(amount, "DEPOSIT"));
    }

    // Withdraw money from the account
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return false;
        }
        if (balance < amount) {
            System.out.println("Insufficient funds.");
            return false;
        }
        balance -= amount;
        transactionHistory.add(new BankTransaction(amount, "WITHDRAW"));
        return true;
    }

    // Record a transfer transaction
    public void recordTransfer(double amount, boolean incoming) {
        String type = incoming ? "TRANSFER IN" : "TRANSFER OUT";
        transactionHistory.add(new BankTransaction(amount, type));
    }

    public List<BankTransaction> getTransactionHistory() {
        return transactionHistory;
    }
}
