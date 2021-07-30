package model;

/**
 * Created by Krishna Kota on 12/05/21
 */
public class TopicQuery extends Query {

    private final String topic;

    public TopicQuery(int share, String topic) {
        super(share);
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }
}
