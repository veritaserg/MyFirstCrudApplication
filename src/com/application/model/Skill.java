package com.application.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Skill implements Serializable {
    private ArrayList<String> skill;
    private int id;


    public Skill(ArrayList<String> skill, int id) {
        this.skill = skill;
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<String> getSkill() {
        return skill;
    }

    public int getId() {
        return id;
    }

    public void setSkill(ArrayList<String> skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return String.valueOf(skill);
    }
}
