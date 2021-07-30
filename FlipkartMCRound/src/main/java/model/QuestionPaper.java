package model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Krishna Kota on 12/05/21
 */
public class QuestionPaper {

    private Set<Question> questions = new HashSet<>();

    public Set<Question> getQuestions() {
        return questions;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Question question : questions) {
            sb.append(question).append("\n");
        }
        return sb.toString();
    }
}
