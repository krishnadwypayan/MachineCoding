package model;

import java.time.LocalDateTime;

/**
 * Created by Krishna Kota on 11/05/21
 */
public class Wallet {

    private double balance;
    private LocalDateTime createdAt;
    private Statement statement;

    public Wallet(double balance) {
        this.balance = balance;
        this.createdAt = LocalDateTime.now();
        this.statement = new Statement();
    }

    public void debit(double amount) {
        balance -= amount;
    }

    public void credit(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Statement getStatement() {
        return statement;
    }
}
