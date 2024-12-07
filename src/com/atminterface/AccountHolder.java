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
}
