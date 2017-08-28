package com.metacube.heap;

public class Job implements Comparable<Job>{
    private String document;
    private int priority;
    private static int totalJobs;
    private int arrivedAt = 0;
    
    public Job() {
        setArrivedAt();
    }
    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
    public String getDocument() {
        return document;
    }
    public void setDocument(String document) {
        this.document = document;
    }
    @Override
    public int compareTo(Job job) {
        if(this.getPriority() > job.getPriority()){
            return 1;
        }
        else if(this.getPriority() < job.getPriority()){
            return -1;
        }
        else{
            if(this.getArrivedAt() < job.getArrivedAt()){
                return 1;
            }
            else if(this.getArrivedAt() > job.getArrivedAt()){
                return -1;
            }
        }
        return 0;
    }
    @Override
    public String toString(){
        return priority+" "+document;
    }
    public int getArrivedAt() {
        return arrivedAt;
    }
    public void setArrivedAt() {
        arrivedAt = totalJobs++;
    }
}
