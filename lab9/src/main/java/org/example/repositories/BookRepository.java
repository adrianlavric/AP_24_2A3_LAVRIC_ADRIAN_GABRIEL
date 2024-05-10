package org.example.repositories;

import org.example.JpaUtil;
import org.example.entities.Book;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class BookRepository {

    public void create(Book book) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
        em.close();
    }

    public Book findById(int id) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Book book = em.find(Book.class, id);
        em.close();
        return book;
    }

    public List<Book> findByName(String name) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE b.title LIKE :title", Book.class);
        query.setParameter("title", "%" + name + "%");
        List<Book> books = query.getResultList();
        em.close();
        return books;
    }
}
