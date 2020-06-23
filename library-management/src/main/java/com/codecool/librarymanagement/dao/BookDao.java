package com.codecool.librarymanagement.dao;
import com.codecool.librarymanagement.generated.BooksItem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookDao {
    private List<BooksItem> bookList = new ArrayList<>();

    public BookDao() {

    }

    public void setBookList(List<BooksItem> bookByMongo) {
        this.bookList = bookByMongo;
    }

    public void printBooksItem(){
        System.out.println(bookList);
    }

}
