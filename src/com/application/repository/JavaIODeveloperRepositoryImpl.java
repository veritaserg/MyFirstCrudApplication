package com.application.repository;

import com.application.model.Developer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JavaIODeveloperRepositoryImpl implements DeveloperRepository {
    List<Developer> developers = new ArrayList<>();
    String path = "E:\\developer.txt";

    @Override
    public void create(Developer developer) {
        developers.add(developer);
        save();
    }

    @Override
    public void remove(Integer i) {
        for (int j = 0; j < developers.size(); j++) {
            if (i.equals(developers.get(j).getId())) {
                developers.remove(j);
            }
        }
        save();
    }

    @Override
    public void update(Developer developer) {
        for (int j = 0; j <= developers.size() - 1; j++) {
            Integer x = developer.getId();
            if (x.equals(developers.get(j).getId())) {
                developers.remove(j);
                developers.add(developer);
            }
        }
        save();
    }

    @Override
    public Developer getDev(Integer i) {

        for (int j = 0; j < developers.size(); j++) {
            if (i.equals(developers.get(j).getId())) {
                return developers.get(j);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
        return null;
    }

    @Override
    public List<Developer> list() {
        return developers;
    }

    public void save() {
        File file = new File(path);
        try (ObjectOutputStream bf = new ObjectOutputStream(new FileOutputStream(file))) {
            bf.writeObject(developers);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}