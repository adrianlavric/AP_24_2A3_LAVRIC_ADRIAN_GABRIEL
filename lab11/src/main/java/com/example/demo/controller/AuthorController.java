package com.example.demo.controller;

import com.example.demo.model.Author;
import com.example.demo.service.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @Operation(summary = "Obține lista tuturor autorilor")
    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }
}
