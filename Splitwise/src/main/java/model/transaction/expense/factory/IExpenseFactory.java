package model.transaction.expense.factory;

import model.transaction.expense.Expense;

/**
 * Created by Krishna Kota on 30/05/21
 */
public interface IExpenseFactory {
    Expense createExpense(int expenseId, String userId, String ledgerId, double amount);
}
