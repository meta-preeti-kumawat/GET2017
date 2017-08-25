package com.metacube.hash;

public class Guest {
    private String name;
    private int age;
    private static int numberOfGuests;
    
    public Guest(String name, int age) {
        this.name = name;
        this.age = age;
        numberOfGuests++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static int getNumberOfGuests() {
        return numberOfGuests;
    }
    public int getKey(){
        return age;
    }
}
