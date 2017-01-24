package com.book.domain;

import com.book.Reader;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by tinoll on 2017. 1. 21..
 */
@Entity // JPA엔티티로 지정
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;    // 엔티티 유일성을 식별하고 자동으로 값을 제공하는 필드로 지정

    private String isbn;
    private String title;
    private String author;
    private String description;

    private Reader reader;

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
