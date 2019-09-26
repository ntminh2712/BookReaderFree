package com.mie.tech.bookreaderfree.repository;

import com.mie.tech.bookreaderfree.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
