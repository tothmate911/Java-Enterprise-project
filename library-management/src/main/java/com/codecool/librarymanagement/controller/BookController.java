package com.codecool.librarymanagement.controller;

import com.codecool.librarymanagement.dao.BookDao;
import com.codecool.librarymanagement.model.generated.detailed.DetailedBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.TreeMap;

@RestController
@RequestMapping("/books")
@CrossOrigin
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
    public TreeMap<String, List<String>> showAllCategories() {
        return bookDao.orderCategoriesWithTreeMap();
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

    @GetMapping("/book/{id}")
    public DetailedBook getBook(@PathVariable("id") Long id) {
        return bookDao.getBookById(id);
    }

}
