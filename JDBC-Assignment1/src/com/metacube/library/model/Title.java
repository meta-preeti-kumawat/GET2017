package com.metacube.library.model;

public class Title extends BaseEntity {
    private String name;
    private Subject subject;
    private Publisher publisher;
    
    public Title(int id, String name, Subject subject, Publisher publisher) {
        this.setId(id);
        this.name = name;
        this.subject = subject;
        this.publisher = publisher;
    }
    public Title(int id, String name, int subject_id, int publisher_id) {
        this.setId(id);
        this.name = name;
        this.subject = new Subject(subject_id);
        this.publisher = new Publisher(publisher_id);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Subject getSubject() {
        return subject;
    }
    public void setSubject(Subject subject) {
        this.subject = subject;
    }
    public Publisher getPublisher() {
        return publisher;
    }
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
