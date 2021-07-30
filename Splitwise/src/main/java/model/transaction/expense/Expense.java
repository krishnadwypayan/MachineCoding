package model.transaction.expense;

import model.transaction.Transaction;

/**
 * Created by Krishna Kota on 29/05/21
 */
public abstract class Expense extends Transaction {

    protected Expense(int expenseId, String userId, String ledgerId, double amount) {
        super(expenseId, userId, ledgerId, amount);
    }

    protected abstract boolean validate();
}
