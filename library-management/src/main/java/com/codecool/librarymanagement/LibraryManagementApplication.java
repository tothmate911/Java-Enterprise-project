package com.codecool.librarymanagement;
import com.codecool.librarymanagement.dao.BookDao;
import com.codecool.librarymanagement.service.BookApiService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class LibraryManagementApplication {

    private BookDao bookDao;
    private BookApiService bookApiService;

    public LibraryManagementApplication(BookDao bookDao, BookApiService bookApiService) {
        this.bookDao = bookDao;
        this.bookApiService = bookApiService;
    }

    @PostConstruct
    public void start(){
        bookDao.setBookList(bookApiService.getBookByMongo().getBooks());
    }


    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementApplication.class, args);



    }
}
