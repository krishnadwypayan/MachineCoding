package model;

/**
 * Created by Krishna Kota on 12/05/21
 */
public abstract class Query {
    private int share;

    public Query(int share) {
        this.share = share;
    }

    public int getShare() {
        return share;
    }
}
