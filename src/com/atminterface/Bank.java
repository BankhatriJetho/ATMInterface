package com.atminterface;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    // Maps userId to (AccountHolder + their Account)
    private Map<String, AccountHolder> accountHolders;
    private Map<String, Account> accounts;

    public Bank() {
        this.accountHolders = new HashMap<>();
        this.accounts = new HashMap<>();
        // For demonstration, create a sample user
        AccountHolder sampleUser = new AccountHolder("John Doe", "1234");
        Account sampleAccount = new Account();
        // Add some initial funds to test deposit and withdrawal
        sampleAccount.deposit(1000.0);

        accountHolders.put(sampleUser.getUserId(), sampleUser);
        accounts.put(sampleUser.getUserId(), sampleAccount);
    }

    // Validate user credentials
    public boolean authenticateUser(String userId, String pin) {
        if (!accountHolders.containsKey(userId)) {
            return false;
        }
        return accountHolders.get(userId).validatePin(pin);
    }

    public AccountHolder getAccountHolder(String userId) {
        return accountHolders.get(userId);
    }

    public Account getAccount(String userId) {
        return accounts.get(userId);
    }

    // Transfer from one user to another
    public boolean transferFunds(String fromUserId, String toUserId, double amount) {
        if (!accounts.containsKey(fromUserId) || !accounts.containsKey(toUserId)) {
            return false;
        }
        Account fromAccount = accounts.get(fromUserId);
        Account toAccount = accounts.get(toUserId);

        if (fromAccount.getBalance() < amount) {
            System.out.println("Insufficient funds for transfer.");
            return false;
        }

        fromAccount.withdraw(amount);
        fromAccount.recordTransfer(amount, false);

        toAccount.deposit(amount);
        toAccount.recordTransfer(amount, true);

        return true;
    }

    // Add a new user and account (could be extended as needed)
    public String createNewUser(String name, String pin) {
        AccountHolder newHolder = new AccountHolder(name, pin);
        Account newAccount = new Account();
        accountHolders.put(newHolder.getUserId(), newHolder);
        accounts.put(newHolder.getUserId(), newAccount);
        return newHolder.getUserId();
    }
}
