package model.query.impl;

import model.Difficulty;
import model.query.Query;

/**
 * Created by Krishna Kota on 16/05/21
 */
public class DifficultyQuery implements Query {

    private final Difficulty difficulty;
    private final double share;

    public DifficultyQuery(Difficulty difficulty, double share) {
        this.difficulty = difficulty;
        this.share = share;
    }

    @Override
    public double getShare() {
        return share;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }
}
