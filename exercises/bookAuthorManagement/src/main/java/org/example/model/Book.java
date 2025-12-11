package org.example.model;

public class Book {
    private final Long id;
    private final String title;
    private final Double price;
    private final Author author;

    public Book(Long id, String title, Double price, Author author) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }

    public Author getAuthor() {
        return author;
    }
}
