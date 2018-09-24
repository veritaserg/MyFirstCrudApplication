package com.application.controller;

import com.application.model.Account;
import com.application.repository.GenericRepository;
import com.application.repository.JavaIOAccountRepositoryImpl;

import java.util.List;

public class AccountControler implements Controller<Account> {
    GenericRepository ac = new JavaIOAccountRepositoryImpl();

    @Override
    public void create(Account account) {
        ac.create(account);
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public void update(Account account) {

    }

    @Override
    public Account get(Integer id) {
        return null;
    }

    @Override
    public List<Account> list() {
        return null;
    }
}
