package com.mie.tech.bookreaderfree.controller;

import com.mie.tech.bookreaderfree.entity.Author;
import com.mie.tech.bookreaderfree.entity.Category;
import com.mie.tech.bookreaderfree.entity.rest.RESTResponse;
import com.mie.tech.bookreaderfree.util.DefineUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/author")
public class AuthorController {

    public ResponseEntity<Object> getListAuthor() {
        List<Author> list = new ArrayList<>();

        return new ResponseEntity<>(new RESTResponse.Success()
                .setStatus(HttpStatus.OK.value())
                .setMessage("Action get list top author")
                .addData(list)
                .build(), HttpStatus.OK);
    }

    public String updateTopAuthor() throws IOException {
        List<Category> list = new ArrayList<>();
        Document document = Jsoup.connect(DefineUtil.URL_TOP_AUTHOR).ignoreContentType(true).get();

        Elements group = document.select("div.mw-category-generated #mw-subcategories div.mw-category");
        return "";
    }
}
