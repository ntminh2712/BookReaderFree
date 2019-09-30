package com.mie.tech.bookreaderfree.entity;


import javax.persistence.*;

@Entity
@Table(name = "new-release")
public class NewReleaseBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int no;
    private String name;
    private String author;
    private String download;
    private String category;
    private String release_date;
    private String subject;
    private String avatar;
    private String language;


    public NewReleaseBook() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDownload() {
        return download;
    }

    public void setDownload(String download) {
        this.download = download;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public static final class NewReleaseBookBuilder {
        private int id;
        private int no;
        private String name;
        private String author;
        private String download;
        private String category;
        private String release_date;
        private String subject;
        private String avatar;
        private String language;

        private NewReleaseBookBuilder() {
        }

        public static NewReleaseBookBuilder aNewReleaseBook() {
            return new NewReleaseBookBuilder();
        }

        public NewReleaseBookBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public NewReleaseBookBuilder withNo(int no) {
            this.no = no;
            return this;
        }

        public NewReleaseBookBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public NewReleaseBookBuilder withAuthor(String author) {
            this.author = author;
            return this;
        }

        public NewReleaseBookBuilder withDownload(String download) {
            this.download = download;
            return this;
        }

        public NewReleaseBookBuilder withCategory(String category) {
            this.category = category;
            return this;
        }

        public NewReleaseBookBuilder withRelease_date(String release_date) {
            this.release_date = release_date;
            return this;
        }

        public NewReleaseBookBuilder withSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public NewReleaseBookBuilder withAvatar(String avatar) {
            this.avatar = avatar;
            return this;
        }

        public NewReleaseBookBuilder withLanguage(String language) {
            this.language = language;
            return this;
        }

        public NewReleaseBook build() {
            NewReleaseBook newReleaseBook = new NewReleaseBook();
            newReleaseBook.setId(id);
            newReleaseBook.setNo(no);
            newReleaseBook.setName(name);
            newReleaseBook.setAuthor(author);
            newReleaseBook.setDownload(download);
            newReleaseBook.setCategory(category);
            newReleaseBook.setRelease_date(release_date);
            newReleaseBook.setSubject(subject);
            newReleaseBook.setAvatar(avatar);
            newReleaseBook.setLanguage(language);
            return newReleaseBook;
        }
    }
}
