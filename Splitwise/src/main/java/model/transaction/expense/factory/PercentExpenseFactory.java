package model.transaction.expense.factory;

import model.transaction.expense.Expense;
import model.transaction.expense.PercentExpense;

/**
 * Created by Krishna Kota on 30/05/21
 */
public class PercentExpenseFactory implements IExpenseFactory {
    @Override
    public Expense createExpense(int expenseId, String userId, String ledgerId, double amount) {
        return new PercentExpense(expenseId, userId, ledgerId, amount);
    }
}
