package com.codecool.librarymanagement;

import com.codecool.librarymanagement.dao.BookDao;
import com.codecool.librarymanagement.model.generated.Book;
import com.codecool.librarymanagement.model.generated.detailed.DetailedBook;
import com.codecool.librarymanagement.service.BookApiService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class LibraryManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementApplication.class, args);
    }

    @Bean
    @Profile("production")
    public CommandLineRunner init(BookDao bookDao, BookApiService bookApiService) {
        return new CommandLineLibraryManagementApplication(bookDao, bookApiService);
    }



//    private final BookDao bookDao;
//    private final BookApiService bookApiService;
//    private final List<Book> bookList = new ArrayList<>();
//    private List<DetailedBook> detailedBookList = new ArrayList<>();
//
//    public LibraryManagementApplication(BookDao bookDao, BookApiService bookApiService) {
//        this.bookDao = bookDao;
//        this.bookApiService = bookApiService;
//    }

//    @PostConstruct
//    public void initialise() {
//        List<String> categories= new ArrayList<>(
//                Arrays.asList("csharp", "java", "javascript", "actionscript", "ajax",
//                        "angular", "android", "django", "fsharp", "gimp", "google",
//                        "html5", "html", "linux", "lego", "python", "ruby", "sap", "xml")
//        );
//
//        for (String category : categories) {
//            for (Book book : bookApiService.getBookByCategory(category)) {
//                book.setCategory(category);
//                bookList.add(book);
//            }
//        }
//
//        for (Book book : bookList) {
//            detailedBookList.add(bookApiService.getDetailedBooksByIsbn(book.getIsbn13(), book.getCategory()));
//        }
//
//        bookDao.initialise(categories, detailedBookList);
//    }



//    @Bean
//    @Profile("production")
//    public CommandLineRunner init() {
//        return args -> {
//            List<String> categories= new ArrayList<>(
//                    Arrays.asList("csharp", "java", "javascript", "actionscript", "ajax",
//                            "angular", "android", "django", "fsharp", "gimp", "google",
//                            "html5", "html", "linux", "lego", "python", "ruby", "sap", "xml")
//            );
//
//            for (String category : categories) {
//                for (Book book : bookApiService.getBookByCategory(category)) {
//                    book.setCategory(category);
//                    bookList.add(book);
//                }
//            }
//
//            for (Book book : bookList) {
//                detailedBookList.add(bookApiService.getDetailedBooksByIsbn(book.getIsbn13(), book.getCategory()));
//            }
//
//            bookDao.initialise(categories, detailedBookList);
//        };
//    }


}
