package com.application.controller;

import com.application.model.Account;
import com.application.repository.AccountRepository;
import com.application.repository.io.JavaIOAccountRepositoryImpl;

import java.io.IOException;
import java.util.List;

public class AccountControler {
    AccountRepository ac = new JavaIOAccountRepositoryImpl();


    public void create(Account account) {
        try {
            ac.create(account);
        } catch (IOException e) {

        }
    }

    public void remove(Long id) {
        ac.remove(id);
    }

    public void update(Account account) {

    }

    public Account get(Long id) {
        return ac.getDev(id);
    }


    public List<Account> list() {
        return ac.list();
    }
}
