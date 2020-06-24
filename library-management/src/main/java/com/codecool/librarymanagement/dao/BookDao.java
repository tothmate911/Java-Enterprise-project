package com.codecool.librarymanagement.dao;
import com.codecool.librarymanagement.model.generated.Book;
import com.codecool.librarymanagement.model.generated.detailed.DetailedBook;
import com.codecool.librarymanagement.service.BookApiService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookDao {

    private final BookApiService bookApiService;
    private final List<Book> bookList = new ArrayList<>();
    private final List<DetailedBook> detailedBookList = new ArrayList<>();
    private final List<String> categories = new ArrayList<>(
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

    public void initializeDetailedBooks() {
        for (Book book : bookList) {
            detailedBookList.add(bookApiService.getDetailedBooksByIsbn(book.getIsbn13(), book.getCategory()));
        }
    }

    public List<DetailedBook> sortBooksByParameter() {
        return detailedBookList.stream()
                .sorted(Comparator.comparing(DetailedBook::getTitle))
                .collect(Collectors.toList());
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public List<Book> getBooksByCategory(String category) {
        return bookList.stream()
                .filter(book -> book.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    public List<Book> getBooksBySearchedString(String searchedString) {
        return getBooksBySearchedWordFromList(searchedString, bookList);
    }

    public List<Book> getBooksByCategoryAndSearchedString(String category, String search) {
        return getBooksBySearchedWordFromList(search, getBooksByCategory(category));
    }

    private List<Book> getBooksBySearchedWordFromList(String searchedString, List<Book> books) {
        String stringLowerCase = searchedString.toLowerCase();
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(stringLowerCase)
                        || book.getSubtitle().toLowerCase().contains(stringLowerCase))
                .collect(Collectors.toList());
    }

    public List<DetailedBook> getDetailedBookList() {
        return detailedBookList;
    }

    public List<String> getCategories() {
        return categories;
    }
}
