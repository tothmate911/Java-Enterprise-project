package com.codecool.librarymanagement.controller;

import com.codecool.librarymanagement.dao.BookDao;
import com.codecool.librarymanagement.model.generated.detailed.DetailedBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
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

    @GetMapping("/{isbn13}")
    public Boolean borrow(@PathVariable("isbn13") String isbn13) {
        if (bookDao.isAvailable(isbn13)) {
            bookDao.setAvailable(isbn13, false);

            int noOfDays = 14;
            LocalDate localDate = LocalDate.now();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
            calendar.add(Calendar.DAY_OF_YEAR, noOfDays);
            Date date = calendar.getTime();

            bookDao.setDate(isbn13, date);
            return true;
        } else {
            return false;
        }
    }

    @GetMapping("/getstatus/{isbn13}")
    public Boolean getStatus(@PathVariable("isbn13") String isbn13) {
        return bookDao.isAvailable(isbn13);
    }

    @GetMapping("/cancel/{isbn13}")
    public Boolean cancelBorrowing(@PathVariable("isbn13") String isbn13) {
        bookDao.setAvailable(isbn13, true);
        bookDao.setDate(isbn13, null);
        return true;
    }
}
