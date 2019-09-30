package com.mie.tech.bookreaderfree.entity;


import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "ebooks")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private  String no;
    private String name;
    private String author;
    private String download;
    private String category;

    @Column( length = 1000000 )
    private String content;
    private String release_date;
    private String subject;
    private String avatar;
    private String language;
    private String key_url;
    private String translator;
    private String illustrator;

    private long create_at;
    private long delete_at;
    private long update_at;
    private int status;

    public Book() {
        this.create_at = Calendar.getInstance().getTimeInMillis();
        this.delete_at = Calendar.getInstance().getTimeInMillis();
        this.update_at = Calendar.getInstance().getTimeInMillis();
        this.status = 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public String getIllustrator() {
        return illustrator;
    }

    public void setIllustrator(String illustrator) {
        this.illustrator = illustrator;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDownload() {
        return download;
    }

    public void setDownload(String download) {
        this.download = download;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getKey_url() {
        return key_url;
    }

    public void setKey_url(String key_url) {
        this.key_url = key_url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public static final class BookBuilder {
        private  int id;
        private  String no;
        private String name;
        private String author;
        private String download;
        private String category;
        private String content;
        private String release_date;
        private String subject;
        private String avatar;
        private String language;
        private String key_url;

        private BookBuilder() {
        }

        public static BookBuilder aBook() {
            return new BookBuilder();
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getDownload() {
            return download;
        }

        public void setDownload(String download) {
            this.download = download;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getRelease_date() {
            return release_date;
        }

        public void setRelease_date(String release_date) {
            this.release_date = release_date;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getKey_url() {
            return key_url;
        }

        public void setKey_url(String key_url) {
            this.key_url = key_url;
        }

        public BookBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public BookBuilder withNo(String no) {
            this.no = no;
            return this;
        }

        public BookBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public BookBuilder withAuthor(String author) {
            this.author = author;
            return this;
        }

        public BookBuilder withDownload(String download) {
            this.download = download;
            return this;
        }

        public BookBuilder withCategory(String category) {
            this.category = category;
            return this;
        }

        public BookBuilder withContent(String content) {
            this.content = content;
            return this;
        }

        public BookBuilder withRelease_date(String release_date) {
            this.release_date = release_date;
            return this;
        }

        public BookBuilder withSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public BookBuilder withAvatar(String avatar) {
            this.avatar = avatar;
            return this;
        }

        public BookBuilder withLanguage(String language) {
            this.language = language;
            return this;
        }

        public BookBuilder withKey_url(String key_url) {
            this.key_url = key_url;
            return this;
        }

        public Book build() {
            Book book = new Book();
            book.setId(id);
            book.setNo(no);
            book.setName(name);
            book.setAuthor(author);
            book.setDownload(download);
            book.setCategory(category);
            book.setContent(content);
            book.setRelease_date(release_date);
            book.setSubject(subject);
            book.setAvatar(avatar);
            book.setLanguage(language);
            book.setKey_url(key_url);
            return book;
        }
    }
}
