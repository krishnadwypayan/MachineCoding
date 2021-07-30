package model.query.impl;

import model.query.Query;

/**
 * Created by Krishna Kota on 15/05/21
 */
public class TopicQuery implements Query {

    private final String topic;
    private final double share;

    public TopicQuery(String topic, double share) {
        this.topic = topic;
        this.share = share;
    }

    @Override
    public double getShare() {
        return share;
    }

    public String getTopic() {
        return topic;
    }
}
