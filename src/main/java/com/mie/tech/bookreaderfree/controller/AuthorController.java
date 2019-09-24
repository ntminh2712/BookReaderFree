package com.mie.tech.bookreaderfree.controller;

import com.mie.tech.bookreaderfree.entity.Author;
import com.mie.tech.bookreaderfree.entity.Category;
import com.mie.tech.bookreaderfree.entity.rest.RESTResponse;
import com.mie.tech.bookreaderfree.util.DefineUtil;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping
    public String updateTopAuthor() throws IOException {
        //Descargamos el html
        String url = "http://www.gutenberg.org/browse/authors/a";
        Connection conn = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36");
        try {
            Connection.Response resp = conn.execute();
            if (resp.statusCode() != 200) {
                System.out.println("Error: "+resp.statusCode());
            }else{
                System.out.println(Thread.currentThread().getName()+" is downloading "+ url);
//                Document document = conn.get();
                return conn.get().html()+"";
            }
        }catch(IOException e) {
            System.out.println(e.getStackTrace());
            System.out.println(Thread.currentThread().getName()+"No puedo conectar con  "+ url + e);
            System.out.println("No se puede conectar");
        }
        return "";
    }
}
