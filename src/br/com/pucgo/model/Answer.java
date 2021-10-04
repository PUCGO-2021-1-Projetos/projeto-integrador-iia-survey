package br.com.pucgo.model;

public class Answer {
    protected Integer id;
    protected String title;
    protected String createdAt;

    protected Question question;

    public Answer(
        Integer id,
        String title,
        String createdAt,
        Question question
    ) {
        this.id = id;
        this.title = title;
        this.createdAt = createdAt;

        this.question = question;
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