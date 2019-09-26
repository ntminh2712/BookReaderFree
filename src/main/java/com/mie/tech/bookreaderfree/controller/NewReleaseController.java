package com.mie.tech.bookreaderfree.controller;


import com.mie.tech.bookreaderfree.entity.Category;
import com.mie.tech.bookreaderfree.entity.SubCategory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/book/release")
public class NewReleaseController {

    @GetMapping(value = "/clone")
    public String cloneDataCategory() throws IOException {
        List<Category> list = new ArrayList<>();
//        Document document = Jsoup.connect("http://www.gutenberg.org/wiki/Category:Wars_Bookshelf").ignoreContentType(true).get();
//
//        Elements group = document.select("div.mw-category-generated #mw-pages div.mw-content-ltr div.mw-category");
//        for (Element elementGroup: group){
//            Elements elements = elementGroup.select("div.mw-category-group ul li");
//            for (Element elementCategory : elements) {
//                SubCategory subCategory = new SubCategory();
//                subCategory.setName(elementCategory.select("a").text().replace("(Bookshelf)", ""));
//                subCategory.setKeyUrl(elementCategory.select("a").attr("href"));
//                subCategory.setCategoryId(22);
//                subCategoryService.saveSubCategory(subCategory);
//            }
//        }
        return "clone success";
    }
}
