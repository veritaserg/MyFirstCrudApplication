package com.application.model;

import java.io.Serializable;
import java.util.Set;

public class Developer implements Serializable {
    private String name;
    private int id;

    private Set<Skill> skills;
    private Account account;

    public Developer(int id, String name) {
        this.id = id;
        this.name = name;

    }

    public Developer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", skills=" + skills +
                ", account=" + account +
                ", id=" + id +
                '}';
    }
}
