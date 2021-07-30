package model;

import model.transaction.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krishna Kota on 29/05/21
 */
public class Ledger {

    private final List<Transaction> transactions = new ArrayList<>();

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
