package br.com.pucgo.model;

public class Answer {
    protected Integer id;
    protected String text;
    protected String createdAt;

    protected Question question;

    public Answer(
        Integer id,
        String text,
        String createdAt,
        Question question
    ) {
        this.id = id;
        this.text = text;
        this.createdAt = createdAt;

        this.question = question;
    }

    public Answer(
        String text,
        Question question
    ) {
        this.text = text;
        this.question = question;
    }

    public Integer getId() {
        return id;
    }
    
    public String getText() {
        return text;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public Question getQuestion() {
        return question;
    }
}