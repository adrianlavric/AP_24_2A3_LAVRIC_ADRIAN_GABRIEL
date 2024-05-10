package org.example;

import org.example.entities.Book;
import org.example.repositories.BookRepository;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BookRepository repo = new BookRepository();

        Book book1 = new Book();
        book1.setTitle("Book1");
        book1.setAuthors("Author1");
        Book book2 = new Book();
        book2.setTitle("Book2");
        book2.setAuthors("Author2");
        repo.create(book1);
        repo.create(book2);

        Book foundBook = repo.findById(1);
        System.out.println("Found Book: " + foundBook.getTitle());

        System.out.println("Books with 'book' in title:");
        repo.findByName("book").forEach(b -> System.out.println(b.getTitle()));

        JpaUtil.shutdown();
    }
}