package br.com.pucgo.model;

public class Question {
    protected Integer id;
    protected String title;
    protected String createdAt;

    public Question(Integer id, String title, String createdAt) {
        this.id = id;
        this.title = title;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}