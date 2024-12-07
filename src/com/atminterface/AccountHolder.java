package com.atminterface;

import java.util.Random;

public class AccountHolder {
    private String name;
    private String userId;
    private String pin;

    public AccountHolder(String name, String pin) {
        this.name = name;
        this.pin = pin;
        this.userId = generateUserId(name);
    }

    public AccountHolder(String name, String userId, String pin) {
        this.name = name;
        this.userId = userId;
        this.pin = pin;
    }

    private String generateUserId(String fullName) {
        // Split the full name into parts
        String[] parts = fullName.trim().split("\\s+");

        // Handle cases where user only has one name or more than two names.
        // We'll just assume the "last name" is the last part of the split.
        String firstName = parts[0];
        String lastName = (parts.length > 1) ? parts[parts.length - 1] : "";

        // Take the first letter of the first name. Ensure it’s uppercase.
        String firstLetter = firstName.substring(0, 1).toUpperCase();

        // If you want the last name exactly as input, keep as is,
        // or to standardize, lowercase it:
        String lastNamePart = lastName.isEmpty() ? "" : lastName;

        // Generate 5 random digits
        Random rand = new Random();
        int randomNum = rand.nextInt(100000); // 0 to 99999
        String randomDigits = String.format("%05d", randomNum); // pad with zeros if needed

        // Combine them
        return firstLetter + lastNamePart + randomDigits;
    }

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    public boolean validatePin(String enteredPin) {
        return this.pin.equals(enteredPin);
    }
}
