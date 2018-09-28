package com.application.repository.io;

import com.application.model.Account;
import com.application.repository.AccountRepository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class JavaIOAccountRepositoryImpl implements AccountRepository {
    Path path = Paths.get("C:\\Users\\T\\IdeaProjects\\com\\my\\crud\\src\\com\\application\\repository\\io\\JavaIOAccountRepositoryImpl.java");

    @Override
    public void create(Account account) {
        String str = "\n" + account.getId() + " " + account.getAccount();
        try {
            Files.write(path, str.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Long id) {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (String s : load(path)) {
                if (Long.parseLong(s.split(" ")[0]) == id) {
                    writer.write(s.split(" ")[0] + " " + s.split(" ")[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Account account) {

    }

    @Override
    public Account getDev(Long id) {
        for (String s : load(path)) {
            if (Long.parseLong(s.split(" ")[0]) == id) {
                return new Account(id, s.split(" ")[1]);
            }
        }
        return null;
    }

    @Override
    public List<Account> list() {
        List<Account> accounts = new ArrayList<>();
        Long id;
        String name;
        for (String list : load(path)) {
            id = Long.valueOf(list.split(" ")[0]);
            name = list.split(" ")[1];
            accounts.add(new Account(id, name));
        }
        return accounts;
    }

    ArrayList<String> load(Path path) {
        List<String> list = new ArrayList<>();
        try (BufferedReader bf = Files.newBufferedReader(path)) {
            while (bf.ready()) {
                list.add(bf.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (ArrayList<String>) list;
    }


}
