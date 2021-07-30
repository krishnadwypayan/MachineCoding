package main;

import exception.InvalidMarksDistributionException;
import exception.InvalidQueryException;
import model.Difficulty;
import model.DifficultyQuery;
import model.Query;
import model.QuestionPaper;
import model.TopicQuery;
import service.QuestionBank;
import service.QuestionPaperService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krishna Kota on 12/05/21
 */
public class Main {

    public static void main(String[] args) throws InvalidMarksDistributionException, InvalidQueryException {
        QuestionBank questionBank = new QuestionBank();
        QuestionPaperService questionPaperService = new QuestionPaperService(questionBank);

        questionBank.createQuestion("1", "abc", "OS", Difficulty.EASY, 1);
        questionBank.createQuestion("2", "abc", "Algo", Difficulty.EASY, 2);
        questionBank.createQuestion("3", "abc", "Algo", Difficulty.EASY, 1);
        questionBank.createQuestion("4", "abc", "OS", Difficulty.EASY, 4);
        questionBank.createQuestion("5", "abc", "DBMS", Difficulty.EASY, 6);
        questionBank.createQuestion("6", "abc", "OS", Difficulty.EASY, 1);
        questionBank.createQuestion("7", "abc", "OS", Difficulty.MEDIUM, 5);
        questionBank.createQuestion("8", "abc", "OS", Difficulty.HARD, 10);

        questionBank.printQuestionBank();
        System.out.println("-------------------");

        // Assuming the queries will specify the actual sum of marks and not a percentage

        DifficultyQuery query1 = new DifficultyQuery(12, Difficulty.EASY);
        DifficultyQuery query2 = new DifficultyQuery(10, Difficulty.HARD);
        List<DifficultyQuery> queries = new ArrayList<>();
        queries.add(query1);
        queries.add(query2);
        QuestionPaper questionPaper = questionPaperService.generateQuestionPaperByDifficulty(22, queries);
        System.out.println(questionPaper);

        System.out.println("-------------------");

        // did not handle the case of repeating questions in the question set. Assuming one topic is given once

        TopicQuery topicQuery1 = new TopicQuery(5, "OS");
        TopicQuery topicQuery2 = new TopicQuery(3, "Algo");
        TopicQuery topicQuery3 = new TopicQuery(6, "DBMS");
        List<TopicQuery> topicQueries = new ArrayList<>();
        topicQueries.add(topicQuery1);
        topicQueries.add(topicQuery2);
        topicQueries.add(topicQuery3);
        QuestionPaper questionPaper1 = questionPaperService.generateQuestionPaperByTopic(14, topicQueries);
        System.out.println(questionPaper1);


        //40 algo, 60 OS  : 15 easy, 85 hard
        // 6 easy algo, 34 hard algo, 9 easy OS, 51 hard algo
        QuestionBank questionBank2 = new QuestionBank();
        questionBank2.createQuestion("1", "abc", "OS", Difficulty.EASY, 10);
        questionBank2.createQuestion("2", "abc", "Algo", Difficulty.EASY, 20);

        questionBank2.createQuestion("3", "abc", "Algo", Difficulty.EASY, 3);
        questionBank2.createQuestion("4", "abc", "Algo", Difficulty.EASY, 3);

        questionBank2.createQuestion("5", "abc", "OS", Difficulty.EASY, 40);
        questionBank2.createQuestion("6", "abc", "DBMS", Difficulty.EASY, 60);
        questionBank2.createQuestion("7", "abc", "OS", Difficulty.EASY, 10);
        questionBank2.createQuestion("8", "abc", "OS", Difficulty.MEDIUM, 50);
        questionBank2.createQuestion("9", "abc", "OS", Difficulty.HARD, 20);

        questionBank2.createQuestion("10", "abc", "Algo", Difficulty.HARD, 10);
        questionBank2.createQuestion("11", "abc", "Algo", Difficulty.HARD, 20);
        questionBank2.createQuestion("12", "abc", "Algo", Difficulty.HARD, 50);
        questionBank2.createQuestion("13", "abc", "Algo", Difficulty.HARD, 4);

        questionBank2.createQuestion("15", "abc", "OS", Difficulty.EASY, 5);
        questionBank2.createQuestion("14", "abc", "OS", Difficulty.EASY, 4);
        questionBank2.createQuestion("16", "abc", "OS", Difficulty.HARD, 20);
        questionBank2.createQuestion("17", "abc", "OS", Difficulty.HARD, 1);
        questionBank2.createQuestion("18", "abc", "OS", Difficulty.HARD, 10);

        List<Query> combinedQueries = new ArrayList<>();
        DifficultyQuery difficultyQuery1 = new DifficultyQuery(15, Difficulty.EASY);
        DifficultyQuery difficultyQuery2 = new DifficultyQuery(85, Difficulty.HARD);
        TopicQuery topicQuery11 = new TopicQuery(40, "Algo");
        TopicQuery topicQuery12 = new TopicQuery(60, "OS");
        combinedQueries.add(difficultyQuery1);
        combinedQueries.add(difficultyQuery2);
        combinedQueries.add(topicQuery11);
        combinedQueries.add(topicQuery12);

        QuestionPaperService questionPaperService1 = new QuestionPaperService(questionBank2);
        QuestionPaper questionPaper2 = questionPaperService1.generateQuestionPaperCombinedQueries(100, combinedQueries);
        System.out.println(questionPaper2);
    }

}
