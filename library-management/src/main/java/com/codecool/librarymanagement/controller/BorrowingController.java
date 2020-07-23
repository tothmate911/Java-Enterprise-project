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
@RequestMapping("/borrow")
@CrossOrigin
public class BorrowingController {

    private BookDao bookDao;

    @Autowired
    public void setBookApiService(BookDao bookDao) {
        this.bookDao = bookDao;
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
}
