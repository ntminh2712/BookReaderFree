package com.mie.tech.bookreaderfree.controller;

import com.mie.tech.bookreaderfree.entity.Author;
import com.mie.tech.bookreaderfree.entity.Book;
import com.mie.tech.bookreaderfree.entity.rest.RESTResponse;
import com.mie.tech.bookreaderfree.service.AuthorService;
import com.mie.tech.bookreaderfree.service.BookService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;


    @Autowired
    BookService bookService;

//
//    public ResponseEntity<Object> getListAuthor() {
//        List<Author> list = new ArrayList<>();
//
//        return new ResponseEntity<>(new RESTResponse.Success()
//                .setStatus(HttpStatus.OK.value())
//                .setMessage("Action get list top author")
//                .addData(list)
//                .build(), HttpStatus.OK);
//    }

    //    @GetMapping
//    public String updateTopAuthor() throws IOException {
//        String url = "http://www.gutenberg.org/browse/authors/a";
//        Connection conn = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36");
//        try {
//            Connection.Response resp = conn.execute();
//            if (resp.statusCode() != 200) {
//                System.out.println("Error: "+resp.statusCode());
//            }else{
//                System.out.println(Thread.currentThread().getName()+" is downloading "+ url);
////                Document document = conn.get();
//                return conn.get().html()+"";
//            }
//        }catch(IOException e) {
//            System.out.println(e.getStackTrace());
//            System.out.println(Thread.currentThread().getName()+"No puedo conectar con  "+ url + e);
//            System.out.println("No se puede conectar");
//        }
//        return "";
//    }




    @GetMapping(value = "/clone/all")
    public void cloneAuthor() throws IOException {
        String[] list = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "j", "k", "m", "n", "o","p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "other"};
        for (int i = 0; i < list.length; i++){
            Document document = Jsoup.connect("http://www.gutenberg.org/browse/authors/"+list[i]).ignoreContentType(true).get();
            Elements group = document.select("div.pgdbbyauthor");
            for (Element elementGroup : group) {
                Elements elementsAuthor = elementGroup.select("h2");
                for (Element elementAuthor : elementsAuthor) {
                    Author author = new Author();

                    String name = elementAuthor.select("a:first-child").text();
                    author.setKey_name(name);
                    author.setKeyUrl(elementAuthor.select("a:last-child").attr("href"));
                    author.setDescription(elementAuthor.select("a").text());
                    if (name != "" && name.length() != 0 && name.contains(",")) {
                        String born_die = name.substring(name.lastIndexOf(","), name.length());
                        if (born_die.contains("1")) {
                            author.setBorn_die(born_die.replace(", ",""));
                            author.setName(elementAuthor.select("a").text().substring(0, name.length() - born_die.length()));
                        } else {
                            author.setName(name);
                            author.setBorn_die("");
                        }
                        if (author.getName() != "" && author.getName().length() != 0) {
                            authorService.saveAuthor(author);
                        }
                    }
                }
            }
        }

    }

}
