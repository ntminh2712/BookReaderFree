package com.mie.tech.bookreaderfree.controller;

//import com.mie.tech.bookreaderfree.entity.Book;

import com.mie.tech.bookreaderfree.entity.Book;
import com.mie.tech.bookreaderfree.entity.Category;
import com.mie.tech.bookreaderfree.service.BookService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/book")
public class BookController {

    @Autowired
    BookService bookService;

//    @GetMapping(value = "/category")
//    public String cloneDataCategory() throws IOException {
////        List<Category> list = new ArrayList<>();
////        Document document = Jsoup.connect("http://www.gutenberg.org/wiki/Category:Bookshelf").ignoreContentType(true).get();
////        Category category = new Category();
////        Elements group = document.select("div.mw-category-generated #mw-subcategories div.mw-category");
////        for (Element elementGroup: group){
////            Elements elements = elementGroup.select("div.mw-category-group ul");
////            for (Element elementCategory : elements) {
////                category.setKey(elementCategory.select("a").attr("href"));
////                category.setName(elementCategory.select("a").text());
////                Document documentDescription = Jsoup.connect("http://www.gutenberg.org/wiki/Category:Bookshelf").ignoreContentType(true).get();
////                Elements elementDescription = document.select("#mw-content-text div.mw-parser-output p:first-child");
////                category.setDescription(elementDescription.text());
////                list.add(category);
////                System.out.print(category);
////            }
////        }
//        return "";
//    }


    @GetMapping(value = "/clone/all")
    public void updateTopAuthor() throws IOException {
        String[] list = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "j", "k", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "other"};
        for (int i = 0; i < list.length; i++) {
            Document documentTitle = Jsoup.connect("http://www.gutenberg.org/browse/titles/" + list[i]).ignoreContentType(true).get();

            Elements group = documentTitle.select("div.pgdbbytitle");
            for (Element elementGroup : group) {
                Elements elementsBook = elementGroup.select("h2");
                Book book = new Book();
                String link = elementsBook.select("a:first-child").attr("href");
                Document documentEbook = Jsoup.connect("http://www.gutenberg.org" + link).ignoreContentType(true).get();
                Elements elementsTable = documentEbook.select("#bibrec table.bibrec tbody");
                book.setAvatar(documentEbook.select("#cover img.cover-art").attr("src"));
                book.setKey_url(link);
                String name = documentEbook.select("div.header h1").text();
                book.setName(name);
                for (Element elementEbook : elementsTable) {
                    Elements elements = elementEbook.select("tr");
                    for (Element elementDetail : elements) {
                        String title = elementDetail.select("th").text();
                        switch (title) {
                            case "Author":
                                book.setAuthor(elementDetail.select("td a").text());
                                break;
                            case "Title":
                                book.setName(elementDetail.select("td a").text());
                                break;
                            case "Contents":
                                book.setContent(elementDetail.select("td a").text());
                            case "Subject":
                                book.setSubject(elementDetail.select("td a").text());
                                break;
                            case "Language":
                                book.setLanguage(elementDetail.select("td a").text());
                                break;
                            case "Downloads":
                                book.setDownload(elementDetail.select("td a").text());
                            case "Release&nbsp;Date":
                                book.setRelease_date(elementDetail.select("td a").text());
                            case "Category":
                                book.setCategory(elementDetail.select("td a").text());
                                break;
                            case "EBook-No.":
                                book.setNo(elementDetail.select("td a").text());
                                break;
                        }
                    }
                }
                bookService.saveBook(book);
            }

        }
    }
}
