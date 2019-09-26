package com.mie.tech.bookreaderfree.repository;

import com.mie.tech.bookreaderfree.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
