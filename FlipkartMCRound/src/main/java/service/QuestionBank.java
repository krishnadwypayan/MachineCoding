package service;

import exception.InvalidQueryException;
import model.CombinedQuery;
import model.Difficulty;
import model.DifficultyQuery;
import model.Query;
import model.Question;
import model.TopicQuery;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Krishna Kota on 12/05/21
 */
public class QuestionBank {

    // Queries based on difficulty
    // Queries based on topic
    // Queries of the combination

    private Map<Difficulty, Set<Question>> difficultyQuestionMap = new HashMap<>();
    private Map<String, Set<Question>> topicQuestionMap = new HashMap<>();

    public Question createQuestion(String text, String subject, String topic, Difficulty difficulty, int marks) {
        Question question = new Question(text, subject, topic, difficulty, marks);

        Set<Question> difficultySet = difficultyQuestionMap.getOrDefault(difficulty, new HashSet<>());
        difficultySet.add(question);
        difficultyQuestionMap.put(difficulty, difficultySet);

        Set<Question> topicSet = topicQuestionMap.getOrDefault(topic, new HashSet<>());
        topicSet.add(question);
        topicQuestionMap.put(topic, topicSet);

        return question;
    }

    public Set<Question> filter(Query query) throws InvalidQueryException {
        if (query instanceof DifficultyQuery && difficultyQuestionMap.containsKey(((DifficultyQuery) query).getDifficulty())) {

            return difficultyQuestionMap.get(((DifficultyQuery) query).getDifficulty());

        } else if (query instanceof TopicQuery && topicQuestionMap.containsKey(((TopicQuery) query).getTopic())) {

            return  topicQuestionMap.get(((TopicQuery) query).getTopic());

        } else if (query instanceof CombinedQuery
                && difficultyQuestionMap.containsKey(((CombinedQuery) query).getDifficulty())
                && topicQuestionMap.containsKey(((CombinedQuery) query).getTopic())) {

            Set<Question> questions = new HashSet<>(difficultyQuestionMap.get(((CombinedQuery) query).getDifficulty()));
            Set<Question> result = new HashSet<>();
            for (Question question : questions) {
                if (question.getTopic().equals(((CombinedQuery) query).getTopic())) {
                    result.add(question);
                }
            }

            return result;
        }

        throw new InvalidQueryException();
    }

    public void printQuestionBank() {
        StringBuilder sb = new StringBuilder();
        for (Difficulty difficulty : difficultyQuestionMap.keySet()) {
            sb.append(difficulty).append("\n");
            for (Question question : difficultyQuestionMap.get(difficulty)) {
                sb.append(question).append("\n");
            }
        }

        for (String topic : topicQuestionMap.keySet()) {
            sb.append(topic).append("\n");
            for (Question question : topicQuestionMap.get(topic)) {
                sb.append(question).append("\n");
            }
        }

        System.out.println(sb.toString());
    }

}
