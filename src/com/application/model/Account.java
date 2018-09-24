package com.application.model;

import java.io.Serializable;

public class Account implements Serializable {
    private String account;
    private int id;

    public Account(int id, String account) {

        this.account = account;
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return account;
    }

    public void setId(int id) {
        this.id = id;
    }
}
