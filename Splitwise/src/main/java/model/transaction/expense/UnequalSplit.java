package model.transaction.expense;

/**
 * Created by Krishna Kota on 30/05/21
 */
public class UnequalSplit extends Split {

    private final double share;

    public UnequalSplit(String userId, double share) {
        super(userId);
        this.share = share;
    }

    public double getShare() {
        return share;
    }
}
