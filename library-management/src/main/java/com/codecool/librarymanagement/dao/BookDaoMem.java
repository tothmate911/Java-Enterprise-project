package com.codecool.librarymanagement.dao;

import com.codecool.librarymanagement.model.generated.Book;
import com.codecool.librarymanagement.model.generated.detailed.DetailedBook;
import com.codecool.librarymanagement.service.BookApiService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

@Component(value = "bookDaoMem")
public class BookDaoMem implements BookDao {

    private final BookApiService bookApiService;
    private final List<Book> bookList = new ArrayList<>();
    private final List<DetailedBook> detailedBookList = new ArrayList<>();
    private final List<String> categories = new ArrayList<>(
            Arrays.asList("csharp", "java", "javascript", "actionscript", "ajax",
                    "angular", "android", "django", "fsharp", "gimp", "google",
                    "html5", "html", "linux", "lego", "python", "ruby", "sap", "xml")
    );
    private static Long idCounter = 0L;

    public BookDaoMem(BookApiService bookApiService) {
        this.bookApiService = bookApiService;
        initialiseBooks();
        initializeDetailedBooks();
    }

    public void initialiseBooks() {
        for (String category : categories) {
            for (Book book : bookApiService.getBookByCategory(category)) {
                book.setCategory(category);
                bookList.add(book);
            }
        }
    }

    public void initializeDetailedBooks() {
        for (Book book : bookList) {
            DetailedBook detailedBook = bookApiService.getDetailedBooksByIsbn(book.getIsbn13(), book.getCategory());
            detailedBook.setId(++idCounter);
            detailedBookList.add(detailedBook);
        }
    }

    public List<DetailedBook> sortAllBooks() {
        return detailedBookList.stream()
                .sorted(Comparator.comparing(DetailedBook::getTitle))
                .collect(Collectors.toList());
    }

    public List<DetailedBook> sortCategoryBooks(String category) {
        return getBooksByCategory(category).stream()
                .sorted(Comparator.comparing(DetailedBook::getTitle))
                .collect(Collectors.toList());
    }

    public List<DetailedBook> getBooksByCategory(String category) {
        return detailedBookList.stream()
                .filter(book -> book.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    public List<DetailedBook> getBooksBySearchedString(String searchedString) {
        return getBooksBySearchedWordFromList(searchedString, detailedBookList);
    }

    public List<DetailedBook> getBooksByCategoryAndSearchedString(String category, String search) {
        return getBooksBySearchedWordFromList(search, getBooksByCategory(category));
    }

    private List<DetailedBook> getBooksBySearchedWordFromList(String searchedString,
                                                              List<DetailedBook> booksToSearchFrom) {
        String stringLowerCase = searchedString.toLowerCase();
        return booksToSearchFrom.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(stringLowerCase)
                        || book.getSubtitle().toLowerCase().contains(stringLowerCase))
                .collect(Collectors.toList());
    }

    public List<DetailedBook> getDetailedBookList() {
        return detailedBookList;
    }

    public List<String> getCategories() {
        Collections.sort(categories);
        return categories;
    }

    public DetailedBook getBookById(Long id) {
        return detailedBookList.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

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
