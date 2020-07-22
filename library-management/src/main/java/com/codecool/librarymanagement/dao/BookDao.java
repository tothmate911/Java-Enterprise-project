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

    Boolean isAvailable(Long id);

    void setAvailable(Long id, Boolean status);

    TreeMap<String, List<String>> orderCategoriesWithTreeMap();

}
