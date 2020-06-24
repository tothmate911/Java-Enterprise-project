package com.codecool.librarymanagement.dao;

import com.codecool.librarymanagement.model.generated.Book;
import com.codecool.librarymanagement.service.BookApiService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookDao {

    private BookApiService bookApiService;

    private List<Book> bookList = new ArrayList<>();

    private List<String> categories = new ArrayList<>(
            Arrays.asList("csharp", "java", "javascript", "actionscript", "ajax",
                    "angular", "android", "django", "fsharp", "gimp", "google",
                    "html5", "html", "linux", "lego", "python", "ruby", "sap", "xml")
    );


    public BookDao(BookApiService bookApiService) {
        this.bookApiService = bookApiService;
    }

    public void initialise() {
        for (String category : categories) {
            for (Book book : bookApiService.getBookByCategory(category)) {
                book.setCategory(category);
                bookList.add(book);
            }
        }
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public List<String> getCategories() {
        return categories;
    }

    public List<Book> getBooks(String category) {
        return bookList.stream()
                .filter(book -> book.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    public List<Book> getBooksBySearchedString(String searchedString) {
        return bookList.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(searchedString.toLowerCase())
                || book.getSubtitle().toLowerCase().contains(searchedString.toLowerCase()))
                .collect(Collectors.toList());
    }
}
