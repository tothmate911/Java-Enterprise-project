package com.codecool.librarymanagement.controller;

import com.codecool.librarymanagement.dao.BookDao;
import com.codecool.librarymanagement.model.generated.Book;
import com.codecool.librarymanagement.model.generated.detailed.DetailedBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookDao bookDao;

    @Autowired
    public void setBookApiService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @GetMapping("/")
    public List<DetailedBook> getAllBooks() {
        return bookDao.getDetailedBookList();
    }

    @GetMapping("/categories")
    public List<String> showAllCategories() {
        return bookDao.getCategories();
    }

    @GetMapping("/category/{category}")
    public List<DetailedBook> getBooksByCategory(@PathVariable String category) {
        return bookDao.getBooksByCategory(category);
    }

    @GetMapping("/searchby/{search}")
    public List<DetailedBook> sortBy(@PathVariable("search") String search) {
        return bookDao.getBooksBySearchedString(search);
    }

    @GetMapping("/category/{category}/searchby/{search}")
    public List<DetailedBook> searchInCategory(@PathVariable("category") String category,
                                               @PathVariable("search") String search) {
        return bookDao.getBooksByCategoryAndSearchedString(category, search);
    }

    @GetMapping("/sort")
    public List<DetailedBook> sortBy() {
        return bookDao.sortAllBooks();
    }

    @GetMapping("/category/{category}/sort")
    public List<DetailedBook> sortInCategory(@PathVariable("category") String category) {
        return bookDao.sortCategoryBooks(category);
    }
}
