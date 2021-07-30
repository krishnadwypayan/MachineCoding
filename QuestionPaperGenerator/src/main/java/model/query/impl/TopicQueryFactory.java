package model.query.impl;

import model.Question;
import model.query.Query;
import model.query.QueryFactory;
import repository.QuestionBank;

import java.util.List;

/**
 * Created by Krishna Kota on 15/05/21
 */
public class TopicQueryFactory implements QueryFactory<String> {

    @Override
    public Query createQuery(String topic, double share) {
        return new TopicQuery(topic, share);
    }

    @Override
    public List<Question> filter(Query query, QuestionBank questionBank) {
        return null;
    }
}
