package model;

import java.util.Objects;

/**
 * Created by Krishna Kota on 12/05/21
 */
public class Question {
    // text, subject, topic, difficulty, marks
    private String text;
    private String subject;
    private String topic;
    private Difficulty difficulty;
    private int marks;

    public Question(String text, String subject, String topic, Difficulty difficulty, int marks) {
        this.text = text;
        this.subject = subject;
        this.topic = topic;
        this.difficulty = difficulty;
        this.marks = marks;
    }

    public String getText() {
        return text;
    }

    public String getSubject() {
        return subject;
    }

    public String getTopic() {
        return topic;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return marks == question.marks && text.equals(question.text) &&
                subject.equals(question.subject) &&
                topic.equals(question.topic) && difficulty == question.difficulty;
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, subject, topic, difficulty, marks);
    }

    @Override
    public String toString() {
        return "Question{" +
                "text='" + text + '\'' +
                ", subject='" + subject + '\'' +
                ", topic='" + topic + '\'' +
                ", difficulty=" + difficulty +
                ", marks=" + marks +
                '}';
    }
}
