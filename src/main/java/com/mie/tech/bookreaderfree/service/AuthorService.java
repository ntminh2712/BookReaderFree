package com.mie.tech.bookreaderfree.service;


import com.mie.tech.bookreaderfree.entity.Author;
import com.mie.tech.bookreaderfree.entity.Book;
import com.mie.tech.bookreaderfree.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }
}
