package com.codecool.librarymanagement.dao;
import com.codecool.librarymanagement.model.generated.detailed.DetailedBook;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public interface BookDao {
    void initialise(List<String> categories, List<DetailedBook> detailedBookList);

    List<DetailedBook> sortAllBooks();

    List<DetailedBook> sortCategoryBooks(String category);

    List<DetailedBook> getBooksByCategory(String category);

    List<DetailedBook> getBooksBySearchedString(String searchedString);

    List<DetailedBook> getBooksByCategoryAndSearchedString(String category, String search);

    List<DetailedBook> getDetailedBookList();

    List<String> getCategories();

    DetailedBook getBookById(Long id);

    DetailedBook getBookByIsbn13(String isbn13);

    Boolean isAvailable(String isbn13);

    Boolean isAvailable(Long id);

    void setAvailable(String isbn13, Boolean status);

    void setAvailable(Long id, Boolean status);

    void setDate(String isbn13, Date date);

    TreeMap<String, List<String>> orderCategoriesWithTreeMap();

    void borrow(String isbn13, String username);
}
