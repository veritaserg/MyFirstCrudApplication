package com.application.repository;

import java.util.List;

public interface GenericRepository<T> {
    void create(T t);

    void remove(Integer id);

    void update(T t);

    T getDev(Integer id);

    List<T> list();

}

