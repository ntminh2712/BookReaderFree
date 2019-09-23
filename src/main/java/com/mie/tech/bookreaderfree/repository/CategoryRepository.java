package com.mie.tech.bookreaderfree.repository;

import com.mie.tech.bookreaderfree.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
