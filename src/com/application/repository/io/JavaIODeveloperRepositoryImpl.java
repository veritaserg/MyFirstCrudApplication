package com.application.repository.io;

import com.application.controller.AccountControler;
import com.application.controller.SkillController;
import com.application.model.Account;
import com.application.model.Developer;
import com.application.model.Skill;
import com.application.repository.DeveloperRepository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class JavaIODeveloperRepositoryImpl implements DeveloperRepository {
    static Path paths = Paths.get("C:\\Users\\T\\IdeaProjects\\com\\my\\crud\\src\\com\\application\\resources\\developer.txt");
    private Long id = 0L;
    SkillController sk = new SkillController();
    AccountControler account = new AccountControler();

    @Override
    public void create(Developer dev) {
        if (!list().isEmpty())
            id = list().get(list().size() - 1).getId();
        else if (dev.getId() > 0)
            id = dev.getId() - 1;
        String ss = "";
        try {
            Iterator it = dev.getSkills().iterator();
            while (it.hasNext()) {
                ss += it.next() + ",";
            }
            if (dev.getSkills().size() >= 1) {
                ss = ss.substring(0, ss.length() - 1);
            }
            String str = "\n" + (++id) + " " + dev.getName() + " " + ss + " " + dev.getAccount();
            sk.create(new Skill(id, ss));
            account.create(new Account(id, dev.getAccount().toString()));
            Files.write(paths, str.getBytes(), StandardOpenOption.APPEND);
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Long id) {
        try (BufferedWriter writer = Files.newBufferedWriter(paths);) {
            for (String list : load(paths)) {
                if (Long.parseLong(list.split(" ")[0]) == id) {
                    writer.write(list.split(" ")[0] + " " + list.split(" ")[1] +
                            " " + list.split(" ")[2] + list.split(" ")[3] + "");
                    writer.newLine();
                }
            }
            sk.remove(id);
            account.remove(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Developer d) {
        remove(d.getId());
        create(d);
    }

    @Override
    public Developer getDev(Long id) {
        String line;
              Set<Skill> skills = new HashSet<>();
        ArrayList<String> listskills = new ArrayList<String>();
        try (BufferedReader bf = Files.newBufferedReader(paths)) {
            while (bf.ready()) {
                line = bf.readLine();
                for (String listt : listskills) {                         /////////works faster////////
                    skills.add(new Skill(id, listt));
                }
                if (Long.parseLong(line.split(" ")[0]) == id)
                    listskills.add(line.split(" ")[2]);
                for (String listt : listskills) {
                    skills.add(new Skill(id, listt));
                }
                    return new Developer(
                            Long.valueOf(line.split(" ")[0]),
                            line.split(" ")[1],
                            skills,
                            new Account(id, line.split(" ")[3]));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        for (Developer list : list()) {
//            if (id == list.getId())                      //shorter code working
//                return list;
//        }
   return null;
    }

    @Override
    public List<Developer> list() {
        List<Developer> developers = new ArrayList<>();
        Long id;
        String name;
        Account account;
        Set<Skill> skills = new HashSet<>();
        ArrayList<String> temp = new ArrayList<String>();
        for (String list : load(paths)) {
            id = Long.valueOf(list.split(" ")[0]);
            name = list.split(" ")[1];
            temp.add(list.split(" ")[2]);
            account = new Account(id, list.split(" ")[3]);
            for (String listt : temp) {
                skills.add(new Skill(id, listt));
            }
            developers.add(new Developer(id, name, skills, account));
        }
        return developers;
    }

    ArrayList<String> load(Path paths) {
        List<String> list = new ArrayList<>();
        try (BufferedReader bf = Files.newBufferedReader(paths)) {
            while (bf.ready()) {
                list.add(bf.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (ArrayList<String>) list;
    }
}





