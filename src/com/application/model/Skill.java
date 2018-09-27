package com.application.model;

public class Skill extends BaseEntity {
    private String name;

    public Skill(Long id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}




