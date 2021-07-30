package model;

/**
 * Created by Krishna Kota on 12/05/21
 */
public class CombinedQuery extends Query {

    private final String topic;
    private final Difficulty difficulty;

    public CombinedQuery(int share, String topic, Difficulty difficulty) {
        super(share);
        this.topic = topic;
        this.difficulty = difficulty;
    }

    public String getTopic() {
        return topic;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }
}
