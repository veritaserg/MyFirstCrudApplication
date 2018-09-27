package com.application.model;

public class BaseEntity {
    private Long Id;

    public void setId(Long id) {
        Id = id;
    }

    public BaseEntity(Long id) {

        Id = id;
    }

    public Long getId() {
        return Id;
    }

    @Override
    public String toString() {
        return String.valueOf(Id);
    }
}
