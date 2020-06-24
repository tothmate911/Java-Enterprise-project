package com.codecool.librarymanagement;

import com.codecool.librarymanagement.dao.BookDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class LibraryManagementApplication {

    private BookDao bookDao;

    public LibraryManagementApplication(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementApplication.class, args);
    }

    @PostConstruct
    public void initialise() {
        bookDao.initialise();
        bookDao.initializeDetailedBooks();
    }
}
