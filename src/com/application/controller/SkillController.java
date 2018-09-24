package com.application.controller;

import com.application.model.Skill;
import com.application.repository.GenericRepository;
import com.application.repository.JavaIOSkillRepositoryImpl;

import java.util.List;

public class SkillController implements Controller<Skill> {

    private GenericRepository sk = new JavaIOSkillRepositoryImpl();

    @Override
    public void create(Skill skill) {
        sk.create(skill);
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public void update(Skill skill) {

    }

    @Override
    public Skill get(Integer id) {
        return null;
    }

    @Override
    public List<Skill> list() {
        return null;
    }
}
