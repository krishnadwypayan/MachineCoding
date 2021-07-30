package model.transaction.settlement;

import model.transaction.Transaction;

/**
 * Created by Krishna Kota on 29/05/21
 */
public class Settlement extends Transaction {

    private final String to;

    public Settlement(int transactionId, String userId, String ledgerId, double amount, String to) {
        super(transactionId, userId, ledgerId, amount);
        this.to = to;
    }

    public String getTo() {
        return to;
    }
}
