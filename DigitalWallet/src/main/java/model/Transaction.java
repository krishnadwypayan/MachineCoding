package model;

import java.time.LocalDateTime;

/**
 * Created by Krishna Kota on 11/05/21
 */
public class Transaction {

    private String from;
    private String to;
    private double amount;
    private LocalDateTime createdAt;

    public Transaction(String from, String to, double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.createdAt = LocalDateTime.now();
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
