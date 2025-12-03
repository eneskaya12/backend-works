package org.example.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final Long id;
    private final LocalDate orderDate;
    private final List<Invoice> invoices;

    public Order(Long id, LocalDate orderDate){
        this.id = id;
        this.orderDate = orderDate;
        this.invoices = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void addInvoice(Invoice invoice) {
        if (invoice != null) {
            this.invoices.add(invoice);
        }
    }
}
