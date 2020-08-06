package com.codecool.librarymanagement.controller;
import com.codecool.librarymanagement.dao.BookDao;
import com.codecool.librarymanagement.entity.BookCategory;
import com.codecool.librarymanagement.model.UserRentedBooks;
import com.codecool.librarymanagement.model.generated.detailed.DetailedBook;
import org.hibernate.hql.internal.ast.DetailedSemanticException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

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

    @GetMapping("/getstatus/{isbn13}")
    public Boolean getStatus(@PathVariable("isbn13") String isbn13) {
        return bookDao.isAvailable(isbn13);
    }

    @GetMapping("/borrow/{isbn13}/{username}")
    public Boolean borrow(@PathVariable("isbn13") String isbn13, @PathVariable("username") String username) {
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

    @GetMapping("/borrow/cancel/{isbn13}")
    public Boolean cancelBorrowing(@PathVariable("isbn13") String isbn13) {
        bookDao.setAvailable(isbn13, true);
        bookDao.setDate(isbn13, null);
        return true;
    }

    @GetMapping("/admin")
    public List<UserRentedBooks> getAllUsersWithRentedBooks() {
        UserRentedBooks u1 = new UserRentedBooks(1, "user123", List.of(bookDao.getBookByIsbn13("9781449396794"), bookDao.getBookByIsbn13("9780596521066")));
        UserRentedBooks u2 = new UserRentedBooks(2, "456", List.of(bookDao.getBookByIsbn13("9780134123486"), bookDao.getBookByIsbn13("9780596007010")));
        return List.of(u1,u2);
    }

    @GetMapping("/user/{username}")
    public List<DetailedBook> getRentedBooksByUser() {

        int noOfDays = 14;
        LocalDate localDate = LocalDate.now();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        calendar.add(Calendar.DAY_OF_YEAR, noOfDays);
        Date date = calendar.getTime();

        bookDao.setAvailable("9781449396794", false);
        bookDao.setAvailable("9780596521066", false);
        bookDao.setDate("9781449396794", date);
        bookDao.setDate("9780596521066", date);
        DetailedBook b1 = bookDao.getBookByIsbn13("9781449396794");
        DetailedBook b2 = bookDao.getBookByIsbn13("9780596521066");

        return List.of(b1,b2);
    }

}
