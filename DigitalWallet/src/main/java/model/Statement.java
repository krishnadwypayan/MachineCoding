package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krishna Kota on 11/05/21
 */
public class Statement {

    private List<Transaction> transactions = new ArrayList<>();

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
