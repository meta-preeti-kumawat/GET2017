package com.metacube.library.model;

public class Publisher extends BaseEntity {
    private String name;

    public Publisher(int id) {
        this.setId(id);
    }
    public Publisher(int id, String name) {
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
