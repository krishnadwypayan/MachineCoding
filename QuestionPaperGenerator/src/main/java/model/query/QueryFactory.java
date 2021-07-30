package model.query;

import model.Question;
import repository.QuestionBank;

import java.util.List;

/**
 * Created by Krishna Kota on 15/05/21
 */
public interface QueryFactory<T> {

    Query createQuery(T object, double share);

    List<Question> filter(Query query, QuestionBank questionBank);

}
