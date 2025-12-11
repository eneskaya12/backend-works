package org.example;

import org.example.model.Author;
import org.example.model.Book;
import org.example.service.BookService;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        BookService bookService = new BookService();
        List<Book> books = bookService.getBooks();

        // 100₺'nin altındaki kitapları listele
        System.out.println("100₺'nin altındaki olan kitapları listele");
        books.stream().filter(book -> book.getPrice() < 100)
                .forEach(book -> System.out.println(book.getTitle()));

        // Yazarlara göre ortalama kitap fiyatlarını Map formatında hesaplayın
        System.out.println("Yazarlara göre ortalama kitap fiyatları");
        Map<Author, Double> avgPricesByAuthor = books.stream().collect(Collectors.groupingBy(
                Book::getAuthor,
                Collectors.averagingDouble(Book::getPrice)
        ));
        avgPricesByAuthor.forEach((author, aDouble) ->
                System.out.println(author.getName() + " -> Ortalama fiyat: " + aDouble));

        // En pahalı kitabı bulup yazdırın
        books.stream().max(Comparator.comparingDouble(Book::getPrice))
                .ifPresent(book -> System.out.println("En pahalı kitap: "+book.getTitle()));

        // Kitap isimlerini alfabetik olarak sıralayın
        System.out.println("Kitap isimlerini alfabetik olarak sıralayın");
        books.stream().map(Book::getTitle).sorted().forEach(System.out::println);

        // Adında "Bir" geçen kitapları filtreleyin
        System.out.println("Adında \"Bir\" geçen kitapları filtreleyin");
        books.stream().filter(book -> book.getTitle().toLowerCase().contains("bir"))
                .forEach(book -> System.out.println(book.getTitle()));

        // Aynı yazara ait kitapları groupBy ile gruplayın
        System.out.println("Aynı yazara ait kitapları groupBy ile gruplayın");
        Map<Author, List<Book>> booksByAuthor = books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor));
        booksByAuthor.forEach((author, books1) -> {
            System.out.println(author.getName() + " adlı yazarın kitapları:");
            books1.forEach(book -> System.out.println(" - "+ book.getTitle()));
        });
    }
}