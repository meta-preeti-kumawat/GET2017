package com.metacube.treesort;

public class Student implements Comparable<Student>{
    private Integer roll;
    private String name;
    public Student(int roll, String name) {
        this.roll = roll;
        this.name = name;
    }
    public int getRoll() {
        return roll;
    }
    public void setRoll(int roll) {
        this.roll = roll;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public int compareTo(Student student) {
        if(getRoll() == student.getRoll() ){
            return 0;
        }
        return getRoll() > student.getRoll() ? 1 : -1;
    }
    @Override
    public int hashCode() {
        return roll.hashCode();
    }
    @Override
    public boolean equals(Object student) {
        return roll.equals(((Student) student).getRoll());
    }
    @Override
    public String toString() {
        return ("\nRoll Number: " + getRoll() + " Name: " + getName());
    }
}
