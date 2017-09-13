package com.metacube.library.model;

public class Subject extends BaseEntity {
    private String name;

    public Subject(int id) {
        this.setId(id);
    }
    public Subject(int id, String name) {
        this.setId(id);
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
