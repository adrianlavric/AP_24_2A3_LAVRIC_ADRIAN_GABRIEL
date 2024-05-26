package com.example.demo.dao;

import com.example.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDAO extends JpaRepository<Book, Integer> {
}

