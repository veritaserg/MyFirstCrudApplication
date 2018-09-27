package com.application.model;

public class Account extends BaseEntity {
    private String account;

    public Account(Long id, String account) {
        super(id);
        this.account = account;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return account;
    }
}
