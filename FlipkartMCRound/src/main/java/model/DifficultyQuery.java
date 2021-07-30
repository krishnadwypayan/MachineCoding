package model;

/**
 * Created by Krishna Kota on 12/05/21
 */
public class DifficultyQuery extends Query {

    private final Difficulty difficulty;

    public DifficultyQuery(int share, Difficulty difficulty) {
        super(share);
        this.difficulty = difficulty;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }
}
