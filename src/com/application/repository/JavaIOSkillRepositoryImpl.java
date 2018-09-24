package com.application.repository;


import com.application.model.Skill;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JavaIOSkillRepositoryImpl implements GenericRepository<Skill> {
    List<Skill> skills = new ArrayList<>();
    String path = "E:\\skill.txt";

    @Override
    public void create(Skill skill) {
        for (int i = 0; i < skills.size(); i++) {
            Integer j = skill.getId();
            if (j.equals(skills.get(i).getId())) {
                skills.remove(i);
            }
        }
        skills.add(skill);
        save();
    }

    @Override
    public void remove(Integer id) {
        for (int j = 0; j < skills.size(); j++) {
            if (id.equals(skills.get(j).getId())) {
                skills.remove(j);
            }
        }
        save();
    }

    @Override
    public void update(Skill skill) {
    }

    @Override
    public Skill getDev(Integer id) {


        return null;
    }

    @Override
    public List<Skill> list() {
        return skills;
    }

    public void save() {
        File file = new File(path);
        try (ObjectOutputStream bf = new ObjectOutputStream(new FileOutputStream(file))) {
            bf.writeObject(skills);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
