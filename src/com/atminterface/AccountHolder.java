package com.atminterface;

import java.util.UUID;

public class AccountHolder {
    private String name;
    private String userId;
    private String pin;

    //Constructor
    public AccountHolder(String name, String pin){
        this.name = name;
        this.pin = pin;

        //generate a userId automatically
        this.userId = UUID.randomUUID().toString().substring(0,8);
    }
    public AccountHolder(String name, String userId, String pin) {
        this.name = name;
        this.userId = userId;
        this.pin = pin;
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
