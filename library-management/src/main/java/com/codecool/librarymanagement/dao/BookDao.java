package com.codecool.librarymanagement.dao;

import com.codecool.librarymanagement.model.generated.detailed.DetailedBook;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public interface BookDao {
    void initialiseBooks();

    void initializeDetailedBooks();

    List<DetailedBook> sortAllBooks();

    List<DetailedBook> sortCategoryBooks(String category);

    List<DetailedBook> getBooksByCategory(String category);

    List<DetailedBook> getBooksBySearchedString(String searchedString);

    List<DetailedBook> getBooksByCategoryAndSearchedString(String category, String search);

    List<DetailedBook> getDetailedBookList();

    List<String> getCategories();

    DetailedBook getBookById(Long id);

    TreeMap<String, List<String>> orderCategoriesWithTreeMap();
}
