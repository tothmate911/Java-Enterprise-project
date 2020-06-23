package com.codecool.librarymanagement.controller;
import com.codecool.librarymanagement.dao.BookDao;
import com.codecool.librarymanagement.generated.Book;
import com.codecool.librarymanagement.service.BookApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BookController {

    private BookApiService bookApiService;
    private BookDao bookDao;

    @Autowired
    public void setBookApiService(BookApiService bookApiService, BookDao bookDao) {
        this.bookApiService = bookApiService;
        this.bookDao = bookDao;
    }

    //private BookDao bookDao;

 /*   public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }*/

    @GetMapping("/test")
    public Book fetchBooksByMongo(){
        bookDao.setBookList(bookApiService.getBookByMongo().getBooks());
        bookDao.printBooksItem();

        return bookApiService.getBookByMongo();
    }

}
