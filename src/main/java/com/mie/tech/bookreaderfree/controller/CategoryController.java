package com.mie.tech.bookreaderfree.controller;

import com.mie.tech.bookreaderfree.entity.Category;
import com.mie.tech.bookreaderfree.entity.rest.RESTResponse;
import com.mie.tech.bookreaderfree.service.CategoryService;
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

    @PostMapping(value = "/clone")
    public String cloneDataCategory() throws IOException {
        List<Category> list = new ArrayList<>();
        Document document = Jsoup.connect(DefineUtil.URL_CATEGORY).ignoreContentType(true).get();

        Elements group = document.select("div.mw-category-generated #mw-subcategories div.mw-category");
        for (Element elementGroup: group){
            Elements elements = elementGroup.select("div.mw-category-group ul li");
            for (Element elementCategory : elements) {
                System.out.print(elementCategory);
                Category category = new Category();
                category.setName(elementCategory.select("a").text());
                category.setKeyUrl(elementCategory.select("a").attr("href"));
                Document documentDescription = Jsoup.connect("http://www.gutenberg.org"+category.getKeyUrl()).ignoreContentType(true).get();
                Elements elementDescription = documentDescription.select("#mw-content-text div.mw-parser-output p:first-child");
                category.setDescription(elementDescription.text());
                categoryService.saveCategory(category);
            }
        }
        return "";
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getListCategory(){
        return new ResponseEntity<>(new RESTResponse.Success()
                .setMessage("Action get list categoy")
                .addData(categoryService.getListCategory())
                .setStatus(HttpStatus.OK.value())
                .build(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getCategoryById(@RequestParam(value = "id") int id){
        Category category = categoryService.getCategoryById(id);
        if (category == null) {
            return new ResponseEntity<>(new RESTResponse.SimpleError()
                    .setCode(HttpStatus.NOT_FOUND.value())
                    .setMessage("Not found")
                    .build(),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new RESTResponse.Success()
                .setMessage("Action get category")
                .addData(category)
                .setStatus(HttpStatus.OK.value())
                .build(), HttpStatus.OK);
    }

}
