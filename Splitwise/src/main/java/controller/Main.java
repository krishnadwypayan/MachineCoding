package controller;

import exceptions.InvaldExpenseTypeException;
import model.transaction.expense.Expense;
import model.transaction.expense.factory.EqualsExpenseFactory;
import model.transaction.expense.factory.ExactExpenseFactory;
import model.transaction.expense.factory.PercentExpenseFactory;
import service.ExpenseManager;

/**
 * Created by Krishna Kota on 30/05/21
 */
public class Main {

    private static ExpenseManager expenseManager = new ExpenseManager();

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvaldExpenseTypeException {
        registerExpenses();

        Expense equalsExpense1 = expenseManager.getExpense("equals", "user1@gmail.com", "1", 100);
        Expense equalsExpense2 = expenseManager.getExpense("equals", "user2@gmail.com", "12", 100);
        System.out.println(equalsExpense1);
        System.out.println(equalsExpense2);
    }

    private static void registerExpenses() throws InstantiationException, IllegalAccessException {
        expenseManager.registerExpenseType("equals", new EqualsExpenseFactory());
        expenseManager.registerExpenseType("percent", new PercentExpenseFactory());
        expenseManager.registerExpenseType("exact", new ExactExpenseFactory());
    }
}
