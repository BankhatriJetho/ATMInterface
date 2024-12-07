package com.atminterface;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BankTransaction {
    private double amount;
    private String type; // "DEPOSIT", "WITHDRAW", "TRANSFER IN", "TRANSFER OUT"
    private LocalDateTime timestamp;

    public BankTransaction(double amount, String type) {
        this.amount = amount;
        this.type = type;
        this.timestamp = LocalDateTime.now();
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public String getTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return timestamp.format(formatter);
    }

    @Override
    public String toString() {
        return "[" + getTimestamp() + "] " + type + ": " + amount;
    }
}
