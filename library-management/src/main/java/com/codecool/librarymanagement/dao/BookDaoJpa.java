package com.codecool.librarymanagement.dao;

import com.codecool.librarymanagement.model.generated.Book;
import com.codecool.librarymanagement.model.generated.detailed.DetailedBook;
import com.codecool.librarymanagement.repository.BookRepository;
import com.codecool.librarymanagement.service.BookApiService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.*;

@Primary
@Component
public class BookDaoJpa implements BookDao {

    private BookRepository bookRepository;

    private final BookApiService bookApiService;
    private final List<Book> bookList = new ArrayList<>();
    private final List<String> categories = new ArrayList<>(
            Arrays.asList("csharp", "java", "javascript", "actionscript", "ajax",
                    "angular", "android", "django", "fsharp", "gimp", "google",
                    "html5", "html", "linux", "lego", "python", "ruby", "sap", "xml")
    );

    public BookDaoJpa(BookApiService bookApiService, BookRepository bookRepository) {
        this.bookApiService = bookApiService;
        this.bookRepository = bookRepository;
        initialiseBooks();
        initializeDetailedBooks();
    }

    @Override
    public void initialiseBooks() {
        for (String category : categories) {
            for (Book book : bookApiService.getBookByCategory(category)) {
                book.setCategory(category);
                bookList.add(book);
            }
        }
    }

    @Override
    public void initializeDetailedBooks() {
        for (Book book : bookList) {
            DetailedBook detailedBook = bookApiService.getDetailedBooksByIsbn(book.getIsbn13(), book.getCategory());
            bookRepository.save(detailedBook);
        }
    }

    @Override
    public List<DetailedBook> sortAllBooks() {
        return bookRepository.findAllByOrderByTitle();
    }

    @Override
    public List<DetailedBook> sortCategoryBooks(String category) {
        return bookRepository.findAllByCategoryOrderByTitle(category);
    }

    @Override
    public List<DetailedBook> getBooksByCategory(String category) {
        return bookRepository.findAllByCategory(category);
    }

    @Override
    public List<DetailedBook> getBooksBySearchedString(String searchedString) {
        return bookRepository.findAllByTitleContaining(searchedString);
    }

    @Override
    public List<DetailedBook> getBooksByCategoryAndSearchedString(String category, String searchedString) {
        return bookRepository.findAllByCategoryAndTitleContaining(category, searchedString);
    }

    @Override
    public List<DetailedBook> getDetailedBookList() {
        return bookRepository.findAll();
    }

    @Override
    public List<String> getCategories() {
        Collections.sort(categories);
        return categories;
    }

    @Override
    public DetailedBook getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public TreeMap<String, List<String>> orderCategoriesWithTreeMap() {
        Map<String, List<String>> map = new HashMap<>();

        for (String category : categories) {
            String firstChar = String.valueOf(category.charAt(0));
            if (map.get(firstChar.toUpperCase()) == null) {
                map.put(firstChar.toUpperCase(), new ArrayList<>(Arrays.asList(category)));
            } else {
                map.get(firstChar.toUpperCase()).add(category);
            }
        }
        return new TreeMap<>(map);
    }
}
