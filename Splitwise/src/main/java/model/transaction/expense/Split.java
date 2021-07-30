package model.transaction.expense;

/**
 * Created by Krishna Kota on 30/05/21
 */
public abstract class Split {
    private final String userId;

    protected Split(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
