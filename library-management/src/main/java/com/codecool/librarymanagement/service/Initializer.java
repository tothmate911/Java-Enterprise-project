package com.codecool.librarymanagement.service;

import com.codecool.librarymanagement.dao.BookDao;
import com.codecool.librarymanagement.entity.BookCategory;
import com.codecool.librarymanagement.entity.Category;
import com.codecool.librarymanagement.model.generated.Book;
import com.codecool.librarymanagement.model.generated.detailed.DetailedBook;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import com.codecool.librarymanagement.entity.DetailedBook;
import com.codecool.librarymanagement.repository.BookCategoryRepository;
import com.codecool.librarymanagement.service.BookApiService;
import org.springframework.boot.CommandLineRunner;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Profile("production")
public class Initializer {
    private BookDao bookDao;
    private BookApiService bookApiService;

    public Initializer(BookDao bookDao, BookApiService bookApiService) {
        this.bookDao = bookDao;
        this.bookApiService = bookApiService;
    }

    private final List<Book> bookList = new ArrayList<>();
    private List<DetailedBook> detailedBookList = new ArrayList<>();

    @PostConstruct
    public void initialise() {
        List<String> categories = new ArrayList<>(
                Arrays.asList("csharp", "java", "javascript", "actionscript", "ajax",
                        "angular", "android", "django", "fsharp", "gimp", "google",
                        "html5", "html", "linux", "lego", "python", "ruby", "sap", "xml")
        );

    private final List<Book> bookList = new ArrayList<>();
    private final List<DetailedBook> detailedBookList = new ArrayList<>();

    @Override
    public void run(String... args) throws Exception {

        for (String category : categories) {
            BookCategory bookCategory = new BookCategory(category);
            bookCategoryRepository.save(bookCategory);
        }

        for (String category : categories) {
            for (Book book : bookApiService.getBookByCategory(category)) {
                book.setCategory(category);
                bookList.add(book);
            }
        }

        for (Book book : bookList) {
            detailedBookList.add(bookApiService.getDetailedBooksByIsbn(book.getIsbn13(), book.getCategory()));
        }

        bookDao.initialise(categories, detailedBookList);
    }
}
