package com.mie.tech.bookreaderfree.service;

import com.mie.tech.bookreaderfree.entity.Book;
import com.mie.tech.bookreaderfree.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }
}
