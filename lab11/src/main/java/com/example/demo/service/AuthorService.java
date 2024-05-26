package com.example.demo.service;

import com.example.demo.dao.AuthorDAO;
import com.example.demo.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorDAO authorDAO;

    public List<Author> getAllAuthors() {
        return authorDAO.findAll();
    }
}
