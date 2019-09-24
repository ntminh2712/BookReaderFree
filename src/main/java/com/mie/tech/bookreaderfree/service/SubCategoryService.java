package com.mie.tech.bookreaderfree.service;

import com.mie.tech.bookreaderfree.entity.Category;
import com.mie.tech.bookreaderfree.entity.SubCategory;
import com.mie.tech.bookreaderfree.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SubCategoryService {

    @Autowired
    SubCategoryRepository subCategoryRepository;

    public SubCategory saveSubCategory(SubCategory subCategory){

        return subCategoryRepository.save(subCategory);
    }

}
