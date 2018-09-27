package com.application.model;

import java.util.Set;

public class Developer extends BaseEntity {
    private String name;
    private Set<Skill> skills;
    private Account account;


    public Developer(Long id, String name, Set<Skill> skills, Account account) {
        super(id);
        this.name = name;
        this.skills = skills;
        this.account = account;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                '}';
    }
}
