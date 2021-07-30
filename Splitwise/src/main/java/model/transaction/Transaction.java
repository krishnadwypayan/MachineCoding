package model.transaction;

/**
 * Created by Krishna Kota on 29/05/21
 */
public abstract class Transaction {

    private final int transactionId;
    private final String userId;
    private final String ledgerId;
    private final double amount;

    protected Transaction(int transactionId, String userId, String ledgerId, double amount) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.ledgerId = ledgerId;
        this.amount = amount;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public String getUserId() {
        return userId;
    }

    public String getLedgerId() {
        return ledgerId;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                ", transactionId=" + transactionId +
                ", userId='" + userId + '\'' +
                ", ledgerId='" + ledgerId + '\'' +
                ", amount=" + amount +
                '}';
    }
}
