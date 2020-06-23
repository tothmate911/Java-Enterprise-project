package com.codecool.librarymanagement.controller;
import com.codecool.librarymanagement.generated.Book;
import com.codecool.librarymanagement.service.BookApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BookController {

    private BookApiService bookApiService;

    @Autowired
    public void setBookApiService(BookApiService bookApiService) {
        this.bookApiService = bookApiService;
    }

    //private BookDao bookDao;

 /*   public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }*/

    @GetMapping("/test/{name}")
    public Book fetchBooksByMongo(@PathVariable("name") String mongo){
        return bookApiService.getBookByMongo(mongo);
    }



}
