package com.application.repository;

import com.application.model.Account;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JavaIOAccountRepositoryImpl implements GenericRepository<Account> {
    ArrayList<Account> accounts = new ArrayList<>();
    String path = "E:\\accounts.txt";

    @Override
    public void create(Account account) {
        for (int i = 0; i < accounts.size(); i++) {
            Integer j = account.getId();
            if (j.equals(accounts.get(i).getId())) {
                accounts.remove(i);
            }
        }
        accounts.add(account);
        save();
    }

    @Override
    public void remove(Integer id) {
    }

    @Override
    public void update(Account account) {

    }

    @Override
    public Account getDev(Integer id) {
        return null;
    }

    @Override
    public List<Account> list() {
        return null;
    }

    public void save() {
        File file = new File(path);
        try (ObjectOutputStream bf = new ObjectOutputStream(new FileOutputStream(file))) {
            bf.writeObject(accounts);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
