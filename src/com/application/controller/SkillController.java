package com.application.controller;

import com.application.model.Skill;
import com.application.repository.SkillRepository;
import com.application.repository.io.JavaIOSkillRepositoryImpl;

import java.io.IOException;
import java.util.List;

public class SkillController {

    private SkillRepository sk = new JavaIOSkillRepositoryImpl();

    public void create(Skill skill) {
        try {
            sk.create(skill);
        } catch (IOException e) {
            System.out.println("!!!!");
            e.printStackTrace();
        }
    }

    public void remove(Long id) {
        sk.remove(id);

    }

    public void update(Skill skill) {

    }

    public Skill get(Long id) {

        return sk.getDev(id);
    }


    public List<Skill> list() {
        return sk.list();
    }
}
