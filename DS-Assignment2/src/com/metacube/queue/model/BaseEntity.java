package com.metacube.queue.model;

public abstract class BaseEntity {
    private String id;
    private String name;
    private int rank;
    
    public BaseEntity(String id, String name, int rank) {
        this.id = id;
        this.name = name;
        this.rank = rank;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getRank() {
        return rank;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }


}
