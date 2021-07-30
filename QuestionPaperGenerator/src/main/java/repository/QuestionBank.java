package repository;

import model.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krishna Kota on 15/05/21
 */
public class QuestionBank {

    private final List<Question> questions = new ArrayList<>();

    public List<Question> getQuestions() {
        return questions;
    }

    public Question createQuestion() {
        Question question = new Question();
        questions.add(question);
        return question;
    }
}
