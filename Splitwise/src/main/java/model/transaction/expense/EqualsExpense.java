package model.transaction.expense;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krishna Kota on 29/05/21
 */
public class EqualsExpense extends Expense {

    private final List<EqualSplit> users = new ArrayList<>();

    public EqualsExpense(int expenseId, String userId, String ledgerId, double amount) {
        super(expenseId, userId, ledgerId, amount);
    }

    public List<EqualSplit> getUsers() {
        return users;
    }

    @Override
    protected boolean validate() {
        return true;
    }
}
