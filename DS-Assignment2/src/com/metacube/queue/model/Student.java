package com.metacube.queue.model;

public class Student extends BaseEntity implements Comparable<Student>{
    private College college;
    
    public Student(String id, String name, int rank) {
        super(id, name, rank);
    }
    
    @Override
    public int compareTo(Student student) {
        if(getRank() > student.getRank()){
            return 1;
        }
        else if(getRank() < student.getRank()){
            return -1;
        }
        return 0;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }
}
