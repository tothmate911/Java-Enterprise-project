package com.codecool.librarymanagement.dao;

import com.codecool.librarymanagement.entity.BookCategory;
import com.codecool.librarymanagement.entity.Category;
import com.codecool.librarymanagement.entity.DetailedBook;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public interface BookDao {
    void initialise(List<String> categories, List<DetailedBook> detailedBookList);

    List<DetailedBook> sortAllBooks();

    List<DetailedBook> sortCategoryBooks(String category);

    List<DetailedBook> getBooksByCategory(String  category);

    List<DetailedBook> getBooksBySearchedString(String searchedString);

    List<DetailedBook> getBooksByCategoryAndSearchedString(String  category, String search);

    List<DetailedBook> getDetailedBookList();

    List<String> getCategories();

    DetailedBook getBookById(Long id);

    TreeMap<String, List<String>> orderCategoriesWithTreeMap();

}
