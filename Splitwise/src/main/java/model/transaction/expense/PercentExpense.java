package model.transaction.expense;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krishna Kota on 29/05/21
 */
public class PercentExpense extends Expense {

    private final List<UnequalSplit> users = new ArrayList<>();

    public PercentExpense(int expenseId, String userId, String groupId, double amount) {
        super(expenseId, userId, groupId, amount);
    }

    public List<UnequalSplit> getUsers() {
        return users;
    }

    @Override
    protected boolean validate() {
        return false;
    }
}
