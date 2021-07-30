package service;

import exception.InvalidMarksDistributionException;
import exception.InvalidQueryException;
import model.CombinedQuery;
import model.Difficulty;
import model.DifficultyQuery;
import model.Query;
import model.Question;
import model.QuestionPaper;
import model.TopicQuery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Krishna Kota on 12/05/21
 */
public class QuestionPaperService {

    private final QuestionBank questionBank;

    public QuestionPaperService(QuestionBank questionBank) {
        this.questionBank = questionBank;
    }

    public QuestionPaper generateQuestionPaperCombinedQueries(int total, List<Query> queries) throws InvalidMarksDistributionException, InvalidQueryException {
        if (total < 0) {
            throw new InvalidMarksDistributionException();
        }

        // segregate the original queries

        List<DifficultyQuery> difficultyQueries = new ArrayList<>();
        List<TopicQuery> topicQueries = new ArrayList<>();
        for (Query query : queries) {
            if (query instanceof DifficultyQuery) {
                difficultyQueries.add((DifficultyQuery) query);
            } else if (query instanceof TopicQuery) {
                topicQueries.add((TopicQuery) query);
            }
        }

        // segregate each topic query with difficulty
        QuestionPaper questionPaper = new QuestionPaper();

        for (DifficultyQuery difficultyQuery : difficultyQueries) {
            for (TopicQuery topicQuery : topicQueries) {
                int share = (topicQuery.getShare() * difficultyQuery.getShare())/100;
                CombinedQuery combinedQuery = new CombinedQuery(share, topicQuery.getTopic(), difficultyQuery.getDifficulty());
                Set<Question> filter = questionBank.filter(combinedQuery);

                List<Question> questions = new ArrayList<>();
                questions.addAll(filter);

                List<Question> result = new ArrayList<>();

                boolean res = getQuestionsFromBank(share, questions, result, 0);
                if (!res) {
                    throw new InvalidMarksDistributionException();
                }
                questionPaper.getQuestions().addAll(result);
            }
        }

        return questionPaper;
    }

    public QuestionPaper generateQuestionPaperByDifficulty(int total, List<DifficultyQuery> queries) throws InvalidMarksDistributionException {
        if (total < 0) {
            throw new InvalidMarksDistributionException();
        }

        Map<Difficulty, Integer> counts = new HashMap<>();

        int sum = 0;
        for (DifficultyQuery query : queries) {
            sum += query.getShare();
            counts.put(query.getDifficulty(), counts.getOrDefault(query.getDifficulty(), 0) + query.getShare());
        }

        if (sum != total) {
            throw new InvalidMarksDistributionException();
        }

        QuestionPaper questionPaper = new QuestionPaper();
        for (DifficultyQuery query : queries) {
            try {
                Set<Question> questionsSet = questionBank.filter(query);
                List<Question> questions = new ArrayList<>();
                questions.addAll(questionsSet);

                int marks = counts.get(query.getDifficulty());
                List<Question> result = new ArrayList<>();
                boolean res = getQuestionsFromBank(marks, questions, result, 0);
                if (!res) {
                    throw new InvalidMarksDistributionException();
                }
                questionPaper.getQuestions().addAll(result);

            } catch (InvalidQueryException e) {

            }
        }

        return questionPaper;
    }

    public QuestionPaper generateQuestionPaperByTopic(int total, List<TopicQuery> queries) throws InvalidMarksDistributionException {
        if (total < 0) {
            throw new InvalidMarksDistributionException();
        }

        Map<String, Integer> counts = new HashMap<>();

        int sum = 0;
        for (TopicQuery query : queries) {
            sum += query.getShare();
            counts.put(query.getTopic(), counts.getOrDefault(query.getTopic(), 0) + query.getShare());
        }

        if (sum != total) {
            throw new InvalidMarksDistributionException();
        }

        QuestionPaper questionPaper = new QuestionPaper();
        for (TopicQuery query : queries) {
            try {
                Set<Question> questionsSet = questionBank.filter(query);
                List<Question> questions = new ArrayList<>();
                questions.addAll(questionsSet);

                int marks = counts.get(query.getTopic());
                List<Question> result = new ArrayList<>();
                boolean res = getQuestionsFromBank(marks, questions, result, 0);
                if (!res) {
                    throw new InvalidMarksDistributionException();
                }
                questionPaper.getQuestions().addAll(result);

            } catch (InvalidQueryException e) {

            }
        }

        return questionPaper;
    }

    /*
    marks = 12
    1 1 [2] [4] 2 [6] 2
     */
    private boolean getQuestionsFromBank(int marks, List<Question> questions, List<Question> result, int idx) {
        if (marks == 0) {
            return true;
        }
        if (marks < 0 || idx == questions.size()) {
            return false;
        }

        boolean ans = false;
        if (questions.get(idx).getMarks() <= marks) {
            ans |= getQuestionsFromBank(marks - questions.get(idx).getMarks(), questions, result, idx+1);
            if (ans) {
                result.add(questions.get(idx));
                return true;
            }
        }
        ans |= getQuestionsFromBank(marks, questions, result, idx+1);
        return ans;
    }

    private boolean getQuestionsFromBankCombined(int marks, List<Question> questions, List<Question> result, int idx) {
        if (marks == 0) {
            return true;
        }
        if (marks < 0 || idx == questions.size()) {
            return false;
        }

        boolean ans = false;
        if (questions.get(idx).getMarks() <= marks) {
            ans |= getQuestionsFromBank(marks - questions.get(idx).getMarks(), questions, result, idx+1);
            if (ans) {
                result.add(questions.get(idx));
                return true;
            }
        }
        ans |= getQuestionsFromBank(marks, questions, result, idx+1);
        return ans;
    }
}
