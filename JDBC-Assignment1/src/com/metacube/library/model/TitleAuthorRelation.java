package com.metacube.library.model;

public class TitleAuthorRelation extends BaseEntity {
    private Title title;
    private Author author;
    
    public Title getTitle() {
        return title;
    }
    public void setTitle(Title title) {
        this.title = title;
    }
    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
    
}
