package com.application.view;

import com.application.controller.AccountControler;
import com.application.model.Account;

import java.util.List;

public class AccountView {
    AccountControler ac = new AccountControler();
    public void viewGetAll() {
        List<Account> accounts = ac.list();
        if (accounts.isEmpty()) {
            ConsoleHelper.writeToConsole("\nThere are no records to view.\n");
        } else {
            for (Account account : accounts) {
                ConsoleHelper.writeToConsole("\n" + "ID = " + account.getId() + " || Account: " + account.getAccount());
            }
        }
    }
}

