package org.example.model;

public class Invoice {
    private final Long id;
    private final double amount;

    public Invoice(Long id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }
}
