package org.example.service;

import org.example.model.Author;
import org.example.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    private static final List<Book> books = new ArrayList<>();

    public BookService(){
        Author author1 = new Author(1L, "Orhan Pamuk");
        Author author2 = new Author(2L, "Stefan Zweig");
        Author author3 = new Author(3L, "İhsan Oktay Anar");

        Book book1 = new Book(1L, "Masumiyet Müzesi", 20.0, author1);
        Book book2 = new Book(2L, "Kafamda Bir Tuhaflık", 15.0, author1);
        Book book3 = new Book(3L, "Satranç", 5.0, author2);
        Book book4 = new Book(4L, "Kızıl", 3.0, author2);
        Book book5 = new Book(5L, "Puslu Kıtalar Atlası", 101.0, author3);

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
    }

    public List<Book> getBooks() {
        return books;
    }
}
