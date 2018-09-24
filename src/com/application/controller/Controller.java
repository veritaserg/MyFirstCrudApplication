package com.application.controller;


import java.util.List;

public interface Controller<T> {
    void create(T t);

    void remove(Integer id);

    void update(T t);

    T get(Integer id);

    List<T> list();


}
