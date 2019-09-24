package com.mie.tech.bookreaderfree.repository;

import com.mie.tech.bookreaderfree.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer> {
}
