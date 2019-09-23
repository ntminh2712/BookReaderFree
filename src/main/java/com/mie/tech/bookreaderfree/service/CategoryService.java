package com.mie.tech.bookreaderfree.service;

import com.mie.tech.bookreaderfree.entity.Category;
import com.mie.tech.bookreaderfree.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {


    @Autowired
    CategoryRepository categoryRepository;


    public Category saveCategory(Category category){

        return categoryRepository.save(category);
    }

    public List<Category> getListCategory() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(int id){

        return categoryRepository.findById(id).orElse(null);
    }

}
