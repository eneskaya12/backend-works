package org.example.service;

import org.example.model.Customer;
import org.example.model.Invoice;
import org.example.model.Order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
        private static final List<Customer> customers = new ArrayList<>();

        public CustomerService() {
            Customer customer1 = new Customer(1L, "Durdu", LocalDate.of(2025,7,13));
            Customer customer2 = new Customer(2L, "Ufuk", LocalDate.of(2025,6,20));
            Customer customer3 = new Customer(3L, "Emin", LocalDate.of(2024,1,10));
            Customer customer4 = new Customer(4L, "Yusuf", LocalDate.of(2025,6,24));
            Customer customer5 = new Customer(5L, "Fatma", LocalDate.of(2025,8,30));
            Customer customer6 = new Customer(6L, "İlknur", LocalDate.of(2025,6,6));
            Customer customer7 = new Customer(7L, "Can", LocalDate.of(2025,6,10));

            Order order1 = new Order(1L, LocalDate.of(2025,7,13));
            Order order2 = new Order(2L, LocalDate.of(2025,7,13));
            Order order3 = new Order(3L, LocalDate.of(2025,7,13));
            Order order4 = new Order(4L, LocalDate.of(2025,7,13));
            Order order5 = new Order(5L, LocalDate.of(2025,7,13));
            Order order6 = new Order(6L, LocalDate.of(2025,7,13));
            Order order7 = new Order(7L, LocalDate.of(2025,7,13));

            Invoice invoice1 = new Invoice(1L, 600.0);
            Invoice invoice2 = new Invoice(2L, 1000.5);
            Invoice invoice3 = new Invoice(3L, 1800.0);
            Invoice invoice4 = new Invoice(4L, 400.0);
            Invoice invoice5 = new Invoice(5L, 320.0);
            Invoice invoice6 = new Invoice(6L, 700.0);
            Invoice invoice7 = new Invoice(7L, 1564.0);

            order1.addInvoice(invoice1);
            order2.addInvoice(invoice2);
            order3.addInvoice(invoice3);
            order4.addInvoice(invoice4);
            order4.addInvoice(invoice5);
            order5.addInvoice(invoice6);
            order6.addInvoice(invoice7);
            order7.addInvoice(invoice4);
            order7.addInvoice(invoice5);
            order7.addInvoice(invoice7);

            customer1.addOrder(order1);
            customer2.addOrder(order2);
            customer3.addOrder(order3);
            customer4.addOrder(order4);
            customer5.addOrder(order5);
            customer6.addOrder(order6);
            customer7.addOrder(order7);

            customers.add(customer1);
            customers.add(customer2);
            customers.add(customer3);
            customers.add(customer4);
            customers.add(customer5);
            customers.add(customer6);
            customers.add(customer7);
        }

        public List<Customer> getCustomers() {
            return customers;
        }
}
