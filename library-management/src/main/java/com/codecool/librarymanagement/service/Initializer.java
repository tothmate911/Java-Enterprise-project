package com.codecool.librarymanagement.service;

import com.codecool.librarymanagement.dao.BookDao;
import com.codecool.librarymanagement.entity.BookCategory;
import com.codecool.librarymanagement.model.generated.Book;
import com.codecool.librarymanagement.model.generated.detailed.DetailedBook;
import com.codecool.librarymanagement.repository.BookCategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Profile("production")
public class Initializer implements CommandLineRunner {
    private final BookDao bookDao;
    private final BookApiService bookApiService;
    private final BookCategoryRepository bookCategoryRepository;

    public Initializer(BookDao bookDao, BookApiService bookApiService, BookCategoryRepository bookCategoryRepository) {
        this.bookDao = bookDao;
        this.bookApiService = bookApiService;
        this.bookCategoryRepository = bookCategoryRepository;
    }

    private final List<Book> bookList = new ArrayList<>();
    private final List<DetailedBook> detailedBookList = new ArrayList<>();

    @Override
    public void run(String... args) throws Exception {

    }
    @PostConstruct
    public void initialise() {
        List<String> categories = new ArrayList<>(
                Arrays.asList("csharp", "java", "javascript", "actionscript", "ajax",
                        "angular", "android", "django", "fsharp", "gimp", "google",
                        "html5", "html", "linux", "lego", "python", "ruby", "sap", "xml")
        );


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

