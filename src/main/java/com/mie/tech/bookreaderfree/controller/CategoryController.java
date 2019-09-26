package com.mie.tech.bookreaderfree.controller;

import com.mie.tech.bookreaderfree.entity.Category;
import com.mie.tech.bookreaderfree.entity.SubCategory;
import com.mie.tech.bookreaderfree.entity.rest.RESTResponse;
import com.mie.tech.bookreaderfree.service.CategoryService;
import com.mie.tech.bookreaderfree.service.SubCategoryService;
import com.mie.tech.bookreaderfree.util.DefineUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    SubCategoryService subCategoryService;

    @GetMapping(value = "/clone")
    public String cloneDataCategory() throws IOException {
        List<Category> list = new ArrayList<>();
        Document document = Jsoup.connect("http://www.gutenberg.org/wiki/Category:Wars_Bookshelf").ignoreContentType(true).get();

        Elements group = document.select("div.mw-category-generated #mw-pages div.mw-content-ltr div.mw-category");
        for (Element elementGroup: group){
            Elements elements = elementGroup.select("div.mw-category-group ul li");
            for (Element elementCategory : elements) {
                SubCategory subCategory = new SubCategory();
                subCategory.setName(elementCategory.select("a").text().replace("(Bookshelf)", ""));
                subCategory.setKeyUrl(elementCategory.select("a").attr("href"));
                subCategory.setCategoryId(22);
                subCategoryService.saveSubCategory(subCategory);
            }
        }
        return "clone success";
    }

//    Elements group = document.select("div.mw-category-generated #mw-pages div.mw-content-ltr");
//    Elements elements = elementGroup.select("ul li");

//    Elements group = document.select("div.mw-category-generated #mw-pages div.mw-content-ltr div.mw-category");
//        Elements elements = elementGroup.select("div.mw-category-group ul li");

//
//    @RequestMapping(method = RequestMethod.GET)
//    public ResponseEntity<Object> getListCategory(){
//        return new ResponseEntity<>(new RESTResponse.Success()
//                .setMessage("Action get list categoy")
//                .addData(categoryService.getListCategory())
//                .setStatus(HttpStatus.OK.value())
//                .build(), HttpStatus.OK);
//    }

//    @RequestMapping(method = RequestMethod.GET)
//    public ResponseEntity<Object> getCategoryById(@RequestParam(value = "id") int id){
//        Category category = categoryService.getCategoryById(id);
//        if (category == null) {
//            return new ResponseEntity<>(new RESTResponse.SimpleError()
//                    .setCode(HttpStatus.NOT_FOUND.value())
//                    .setMessage("Not found")
//                    .build(),
//                    HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(new RESTResponse.Success()
//                .setMessage("Action get category")
//                .addData(category)
//                .setStatus(HttpStatus.OK.value())
//                .build(), HttpStatus.OK);
//    }

}
