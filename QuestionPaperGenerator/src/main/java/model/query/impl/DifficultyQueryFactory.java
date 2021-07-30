package model.query.impl;

import model.Difficulty;
import model.Question;
import model.query.Query;
import model.query.QueryFactory;
import repository.QuestionBank;

import java.util.List;

/**
 * Created by Krishna Kota on 16/05/21
 */
public class DifficultyQueryFactory implements QueryFactory<Difficulty> {

    @Override
    public Query createQuery(Difficulty difficulty, double share) {
        return new DifficultyQuery(difficulty, share);
    }

    @Override
    public List<Question> filter(Query query, QuestionBank questionBank) {
        return null;
    }
}
