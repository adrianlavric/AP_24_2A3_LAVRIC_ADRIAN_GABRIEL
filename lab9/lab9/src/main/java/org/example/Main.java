package org.example;

import org.example.entities.Author;
import org.example.entities.Book;
import org.example.entities.BookAuthor;
import org.example.entities.PublishingHouse;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BooksUnit");
        EntityManager em = emf.createEntityManager();

        Author author1 = new Author();
        author1.setName("Mircea Eliade");

        Author author2 = new Author();
        author2.setName("Hermann Hesse");

        em.getTransaction().begin();
        em.persist(author1);
        em.persist(author2);
        em.getTransaction().commit();

        PublishingHouse publishingHouse1 = new PublishingHouse();
        publishingHouse1.setName("Cartex");

        PublishingHouse publishingHouse2 = new PublishingHouse();
        publishingHouse2.setName("Penguin Books");

        em.getTransaction().begin();
        em.persist(publishingHouse1);
        em.persist(publishingHouse2);
        em.getTransaction().commit();

        Book book1 = new Book();
        book1.setTitle("Luceafarul");
        book1.setPublishingHouse(publishingHouse1);

        Book book2 = new Book();
        book2.setTitle("Steppenwolf");
        book2.setPublishingHouse(publishingHouse2);

        em.getTransaction().begin();
        em.persist(book1);
        em.persist(book2);
        em.getTransaction().commit();

        BookAuthor bookAuthor1 = new BookAuthor();
        bookAuthor1.setBook(book1);
        bookAuthor1.setAuthor(author1);

        BookAuthor bookAuthor2 = new BookAuthor();
        bookAuthor2.setBook(book2);
        bookAuthor2.setAuthor(author2);

        em.getTransaction().begin();
        em.persist(bookAuthor1);
        em.persist(bookAuthor2);
        em.getTransaction().commit();

        org.example.repositories.BookRepository bookRepository = new org.example.repositories.BookRepository(emf);
        List<Book> booksByAuthor1 = bookRepository.findByAuthor(author1);
        System.out.println("Books by author " + author1.getName() + ":");
        for (Book b : booksByAuthor1) {
            System.out.println("- " + b.getTitle());
        }

        boolean isAssociated = bookRepository.isBookAssociatedWithAuthor(book1.getId(), author1.getId());
        System.out.println("Is book associated with author? " + (isAssociated ? "Yes" : "No"));

        em.close();
        emf.close();
    }
}


//    public static void Compulsory() {
//        BookRepository repo = new BookRepository();
//
//        Book book1 = new Book();
//        book1.setTitle("Book1");
//        book1.setAuthors("Author1");
//        Book book2 = new Book();
//        book2.setTitle("Book2");
//        book2.setAuthors("Author2");
//        repo.create(book1);
//        repo.create(book2);
//
//        Book foundBook = repo.findById(1);
//        System.out.println("Found Book: " + foundBook.getTitle());
//
//        System.out.println("Books with 'book' in title:");
//        repo.findByName("book").forEach(b -> System.out.println(b.getTitle()));
//
//        JpaUtil.shutdown();
//    }
