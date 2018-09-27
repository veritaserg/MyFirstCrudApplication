package com.application.controller;

import com.application.model.Developer;
import com.application.repository.GenericRepository;
import com.application.repository.io.JavaIODeveloperRepositoryImpl;

import java.io.IOException;
import java.util.List;

public class DeveloperController {

    private GenericRepository dev = new JavaIODeveloperRepositoryImpl();

    public void create(Developer d) {
        try {
            dev.create(d);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void remove(Long id) {
        dev.remove(id);
    }

    public void update(Developer d) {
        dev.update(d);
    }

    public Developer get(Long id) {
        return (Developer) dev.getDev(id);
    }

    public List<Developer> list() {
        return dev.list();
    }
}

