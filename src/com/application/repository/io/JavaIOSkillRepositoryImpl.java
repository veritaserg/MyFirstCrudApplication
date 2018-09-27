package com.application.repository.io;


import com.application.model.Skill;
import com.application.repository.SkillRepository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class JavaIOSkillRepositoryImpl implements SkillRepository {
    Path path = Paths.get("com/application/resources/skills.txt");

    @Override
    public void create(Skill skill) throws IOException {
        String str = "\n" + skill.getId() + " " + skill.getName();
        Files.write(path, str.getBytes(), StandardOpenOption.APPEND);
    }

    @Override
    public void remove(Long id) {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (String s : load(path)) {
                if (Long.parseLong(s.split(" ")[0]) == id) {
                    try {
                        writer.write(s.split(" ")[0] + " " + s.split(" ")[1]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Skill skill) {

    }

    @Override
    public Skill getDev(Long id) {
        for (String s : load(path)) {
            if (Long.parseLong(s.split(" ")[0]) == id) {
                return new Skill(id, s.split(" ")[1]);
            }
        }
        return null;
    }

    @Override
    public List<Skill> list() {
        List<Skill> skills = new ArrayList<>();
        Long id;
        String name;
        for (String list : load(path)) {
            id = Long.valueOf(list.split(" ")[0]);
            name = list.split(" ")[1];
            skills.add(new Skill(id, name));
        }
        return skills;
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
