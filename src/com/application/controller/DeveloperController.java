package com.application.controller;

import com.application.model.Developer;
import com.application.repository.GenericRepository;
import com.application.repository.JavaIODeveloperRepositoryImpl;

import java.util.List;

public class DeveloperController implements Controller<Developer> {

    private GenericRepository dev = new JavaIODeveloperRepositoryImpl();

    @Override
    public void create(Developer d) {
        dev.create(d);

    }

    @Override
    public void remove(Integer id) {
        dev.remove(id);
    }

    @Override
    public void update(Developer d) {
        dev.update(d);
    }

    @Override
    public Developer get(Integer id) {
        return (Developer) dev.getDev(id);
    }

    @Override
    public List<Developer> list() {
        return dev.list();
    }
}

