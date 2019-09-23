package com.mie.tech.bookreaderfree.controller;

//import com.mie.tech.bookreaderfree.entity.Book;
import com.mie.tech.bookreaderfree.entity.Category;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1")
public class BookController {

    /*@Autowired
    BookService  service;*/

//    @GetMapping(value = "/category")
//    public String cloneDataCategory() throws IOException {
//        List<Category> list = new ArrayList<>();
//        Document document = Jsoup.connect("http://www.gutenberg.org/wiki/Category:Bookshelf").ignoreContentType(true).get();
//        Category category = new Category();
//        Elements group = document.select("div.mw-category-generated #mw-subcategories div.mw-category");
//        for (Element elementGroup: group){
//            Elements elements = elementGroup.select("div.mw-category-group ul");
//            for (Element elementCategory : elements) {
//                category.setKey(elementCategory.select("a").attr("href"));
//                category.setName(elementCategory.select("a").text());
//                Document documentDescription = Jsoup.connect("http://www.gutenberg.org/wiki/Category:Bookshelf").ignoreContentType(true).get();
//                Elements elementDescription = document.select("#mw-content-text div.mw-parser-output p:first-child");
//                category.setDescription(elementDescription.text());
//                list.add(category);
//                System.out.print(category);
//            }
//        }
//        return list +"";
//    }
}
