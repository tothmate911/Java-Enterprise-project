package com.codecool.librarymanagement;

import com.codecool.librarymanagement.dao.BookDao;
import com.codecool.librarymanagement.model.generated.Book;
import com.codecool.librarymanagement.model.generated.detailed.DetailedBook;
import com.codecool.librarymanagement.service.BookApiService;
import org.springframework.boot.CommandLineRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandLineLibraryManagementApplication implements CommandLineRunner {

    private BookDao bookDao;
    private BookApiService bookApiService;

    public CommandLineLibraryManagementApplication(BookDao bookDao, BookApiService bookApiService) {
        this.bookDao = bookDao;
        this.bookApiService = bookApiService;
    }

    private final List<Book> bookList = new ArrayList<>();
    private List<DetailedBook> detailedBookList = new ArrayList<>();

    @Override
    public void run(String... args) {
        List<String> categories= new ArrayList<>(
                Arrays.asList("csharp", "java", "javascript", "actionscript", "ajax",
                        "angular", "android", "django", "fsharp", "gimp", "google",
                        "html5", "html", "linux", "lego", "python", "ruby", "sap", "xml")
        );

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
