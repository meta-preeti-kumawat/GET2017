package com.metacube.queue.model;

import com.metacube.queue.utility.ArrayList;

public class College  extends BaseEntity implements Comparable<College>{
    private int seats;
    private ArrayList<Student> listOfStudents = new ArrayList<Student>();
    
    public College(String id, String name, int rank) {
        super(id, name, rank);
    }
    
    public College(String id, String name, int rank, int seats) {
        super(id, name, rank);
        setSeats(seats);
    }

    @Override
    public int compareTo(College college) {
        if(getRank() > college.getRank()){
            return 1;
        }
        else if(getRank() < college.getRank()){
            return -1;
        }
        return 0;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public ArrayList<Student> getListOfStudents() {
        return listOfStudents;
    }

    public void setListOfStudents(ArrayList<Student> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

    public void addStudent(Student student) {
        listOfStudents.add(student);
    }
}
