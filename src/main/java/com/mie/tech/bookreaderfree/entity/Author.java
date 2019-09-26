package com.mie.tech.bookreaderfree.entity;

import javax.persistence.*;


@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String keyUrl;
    private String born_die;
    private String key_name;

    public Author() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getKeyUrl() {
        return keyUrl;
    }

    public void setKeyUrl(String keyUrl) {
        this.keyUrl = keyUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public String getKey_name() {
        return key_name;
    }

    public void setKey_name(String key_name) {
        this.key_name = key_name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBorn_die() {
        return born_die;
    }

    public void setBorn_die(String born_die) {
        this.born_die = born_die;
    }

    public static final class AuthorBuilder {
        private int id;
        private String name;
        private String description;
        private String keyUrl;
        private String born_die;
        private String key_name;

        private AuthorBuilder() {
        }

        public static AuthorBuilder anAuthor() {
            return new AuthorBuilder();
        }

        public AuthorBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public AuthorBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public AuthorBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public AuthorBuilder withKeyUrl(String keyUrl) {
            this.keyUrl = keyUrl;
            return this;
        }

        public AuthorBuilder withBorn_die(String born_die) {
            this.born_die = born_die;
            return this;
        }

        public AuthorBuilder withKey_name(String key_name) {
            this.key_name = key_name;
            return this;
        }

        public Author build() {
            Author author = new Author();
            author.setId(id);
            author.setName(name);
            author.setDescription(description);
            author.setKeyUrl(keyUrl);
            author.setBorn_die(born_die);
            author.setKey_name(key_name);
            return author;
        }
    }
}
