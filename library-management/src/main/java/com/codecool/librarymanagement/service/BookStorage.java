package com.codecool.librarymanagement.service;

import com.codecool.librarymanagement.model.Book;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookStorage {

    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void addBooks(Book book) {
        books.add(book);
    }
}
