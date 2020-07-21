package com.codecool.librarymanagement.dao;

import com.codecool.librarymanagement.model.generated.Book;
import com.codecool.librarymanagement.model.generated.detailed.DetailedBook;
import com.codecool.librarymanagement.service.BookApiService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

@Component
public class BookDaoJpa implements BookDao {

    private final BookApiService bookApiService;
    private final List<Book> bookList = new ArrayList<>();
    private final List<DetailedBook> detailedBookList = new ArrayList<>();
    private final List<String> categories = new ArrayList<>(
            Arrays.asList("csharp", "java", "javascript", "actionscript", "ajax",
                    "angular", "android", "django", "fsharp", "gimp", "google",
                    "html5", "html", "linux", "lego", "python", "ruby", "sap", "xml")
    );

    public BookDaoJpa(BookApiService bookApiService) {
        this.bookApiService = bookApiService;
    }

    @Override
    public void initialiseBooks() {

    }

    @Override
    public void initializeDetailedBooks() {

    }

    @Override
    public List<DetailedBook> sortAllBooks() {
        return null;
    }

    @Override
    public List<DetailedBook> sortCategoryBooks(String category) {
        return null;
    }

    @Override
    public List<DetailedBook> getBooksByCategory(String category) {
        return null;
    }

    @Override
    public List<DetailedBook> getBooksBySearchedString(String searchedString) {
        return null;
    }

    @Override
    public List<DetailedBook> getBooksByCategoryAndSearchedString(String category, String search) {
        return null;
    }

    @Override
    public List<DetailedBook> getBooksBySearchedWordFromList(String searchedString, List<DetailedBook> booksToSearchFrom) {
        return null;
    }

    @Override
    public List<DetailedBook> getDetailedBookList() {
        return null;
    }

    @Override
    public List<String> getCategories() {
        return null;
    }

    @Override
    public DetailedBook getBookById(Long id) {
        return null;
    }

    @Override
    public TreeMap<String, List<String>> orderCategoriesWithTreeMap() {
        return null;
    }
}
