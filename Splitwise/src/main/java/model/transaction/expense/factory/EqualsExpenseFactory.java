package model.transaction.expense.factory;

import model.transaction.expense.EqualsExpense;
import model.transaction.expense.Expense;

/**
 * Created by Krishna Kota on 30/05/21
 */
public class EqualsExpenseFactory implements IExpenseFactory {
    @Override
    public Expense createExpense(int expenseId, String userId, String ledgerId, double amount) {
        return new EqualsExpense(expenseId, userId, ledgerId, amount);
    }
}
