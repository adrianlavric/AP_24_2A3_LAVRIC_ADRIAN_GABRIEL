package com.example.demo.service;

import com.example.demo.dao.BookDAO;
import com.example.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookDAO bookDAO;

    public List<Book> getAllBooks() {
        return bookDAO.findAll();
    }

    public Optional<Book> getBookById(Integer id) {
        return bookDAO.findById(id);
    }

    public Book addBook(Book book) {
        return bookDAO.save(book);
    }

    public Book updateBookTitle(Integer id, String newTitle) {
        Optional<Book> optionalBook = bookDAO.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setTitle(newTitle);
            return bookDAO.save(book);
        } else {
            return null;
        }
    }

    public void deleteBook(Integer id) {
        bookDAO.deleteById(id);
    }
}
