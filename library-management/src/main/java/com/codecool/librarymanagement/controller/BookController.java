package com.codecool.librarymanagement.controller;

import com.codecool.librarymanagement.dao.BookDao;
import com.codecool.librarymanagement.model.generated.Book;
import com.codecool.librarymanagement.model.generated.detailed.DetailedBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    private BookDao bookDao;

    @Autowired
    public void setBookApiService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookDao.getDetailedBookList();
    }

    @GetMapping("/categories")
    public List<String> showAllCategories() {
        return bookDao.getCategories();
    }

    @GetMapping("/books/category/{category}")
    public List<Book> getBooksByCategory(@PathVariable String category) {
        return bookDao.getBooksByCategory(category);
    }

    @GetMapping("/books/searchby/{search}")
    public List<Book> sortBy(@PathVariable("search") String search) {
        return bookDao.getBooksBySearchedString(search);
    }

    @GetMapping("/books/category/{category}/searchby/{search}")
    public List<Book> searchInCategory(@PathVariable("category") String category,
                                       @PathVariable("search") String search) {
        return bookDao.getBooksByCategoryAndSearchedString(category, search);
    }

    @GetMapping("/books/sort")
    public List<DetailedBook> sortBy() {
        return bookDao.sortBooksByParameter();
    }

    @GetMapping("/books/category/{category}/sortby/{sort}")
    public List<Book> sortInCategory(@PathVariable("category") String category, @PathVariable("sort") String search) {
        return null;

    }


}
