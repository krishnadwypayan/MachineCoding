package service;

import exceptions.InvaldExpenseTypeException;
import model.transaction.expense.Expense;
import model.transaction.expense.factory.IExpenseFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Krishna Kota on 30/05/21
 */
public class ExpenseManager {

    private final Map<String, IExpenseFactory> expenseFactoryMap = new HashMap<>();

    public void registerExpenseType(String expenseType, IExpenseFactory expenseFactory) throws InstantiationException, IllegalAccessException {
        expenseFactoryMap.put(expenseType, expenseFactory);
    }

    public Expense getExpense(String expenseType, String userId, String ledgerId, double amount) throws InvaldExpenseTypeException {
        if (!expenseFactoryMap.containsKey(expenseType)) {
            throw new InvaldExpenseTypeException();
        }
        return expenseFactoryMap.get(expenseType).createExpense(1, userId, ledgerId, amount);
    }

}
