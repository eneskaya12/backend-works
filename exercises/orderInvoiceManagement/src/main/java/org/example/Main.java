package org.example;

import org.example.model.Customer;
import org.example.model.Invoice;
import org.example.service.CustomerService;

import java.util.List;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();
        List<Customer> customers = customerService.getCustomers();

        //Tüm müşteriler
        System.out.println("\nTüm müşteriler: ");
        customers.stream().forEach(customer -> {System.out.println(customer.getName());});

        //Adında veya soyadında 'C' harfi bulunan müşterileri filtrele
        System.out.println("\nİçinde c harfi olan müşteriler: ");
        customers.stream().filter(customer -> customer.getName().toLowerCase().contains("c"))
                .forEach(customer -> System.out.println(customer.getName()));

        //Haziran ayında kayıt olan müşterilerin faturalarının toplam tutarı
        System.out.println("\nHaziran ayında kayıt olan müşterilerin faturalarının toplam tutarı: ");
        double totalJuneInvoiceAmount = customers.stream().filter(customer -> customer.getRegisterDate().getMonthValue() == 6)
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getInvoices().stream())
                .mapToDouble(Invoice::getAmount)
                .sum();
        System.out.println(totalJuneInvoiceAmount);

        //Sistemdeki tüm faturaları listele
        System.out.println("\nSistemde kayıtlı tüm faturalar: ");
        customers.stream().flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getInvoices().stream())
                .forEach(invoice -> System.out.println("Invoice Id: " + invoice.getId()+ " - Invoice Amount: " + invoice.getAmount()));

        //Sistemde 1500₺ üstündeki faturaları listeleyin
        System.out.println("\nSistemde kayıtlı 1500₺ üstündeki faturaların ortalaması: ");
        customers.stream().flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getInvoices().stream())
                .filter(invoice -> invoice.getAmount() > 1500)
                .forEach(invoice -> System.out.println("Invoice Id: " + invoice.getId()+ " - Invoice Amount: " + invoice.getAmount()));

        //Sistemde 1500₺ üstündeki faturaların ortalamasını hesaplayın
        System.out.println("\nSistemde kayıtlı 1500₺ üstündeki faturaların ortalaması: ");
        double averageOver1500 = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getInvoices().stream())
                .filter(invoice -> invoice.getAmount() > 1500)
                .mapToDouble(Invoice::getAmount)
                .average()
                .orElse(0.0);
        System.out.println(averageOver1500);

        //Sistemde 500₺ altındaki faturalara sahip müşterilerin isimlerini listele
        System.out.println("\nSistemde 500₺ altındaki faturalara sahip müşterilerin isimleri: ");
        List<String> customersName = customers.stream()
                .filter(customer -> customer.getOrders().stream()
                        .flatMap(order -> order.getInvoices().stream())
                        .anyMatch(invoice -> invoice.getAmount() < 500))
                .map(Customer::getName)
                .toList();
        customersName.forEach(customerName -> System.out.println(customerName));

    }
}