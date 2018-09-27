package com.application.repository;

import java.io.IOException;
import java.util.List;

public interface GenericRepository<T,ID> {
    void create(T t) throws IOException;

    void remove(ID id);

    void update(T t);

    T getDev(ID id);

    List<T> list();

}

