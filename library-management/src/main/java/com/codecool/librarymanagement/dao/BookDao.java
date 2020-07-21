package com.codecool.librarymanagement.dao;

import com.codecool.librarymanagement.model.generated.Book;
import com.codecool.librarymanagement.model.generated.detailed.DetailedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public interface BookDao {
    void initialiseBooks();

    void initializeDetailedBooks();

    List<DetailedBook> sortAllBooks();

    List<DetailedBook> sortCategoryBooks(String category);

    List<DetailedBook> getBooksByCategory(String category);

    List<DetailedBook> getBooksBySearchedString(String searchedString);

    List<DetailedBook> getBooksByCategoryAndSearchedString(String category, String search);

    List<DetailedBook> getBooksBySearchedWordFromList(String searchedString, List<DetailedBook> booksToSearchFrom);

    List<DetailedBook> getDetailedBookList();

    List<String> getCategories();

    DetailedBook getBookById(Long id);

    TreeMap<String, List<String>> orderCategoriesWithTreeMap();
}
