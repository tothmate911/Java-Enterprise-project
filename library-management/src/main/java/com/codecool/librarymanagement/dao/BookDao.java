package com.codecool.librarymanagement.dao;

import com.codecool.librarymanagement.model.generated.Book;
import com.codecool.librarymanagement.model.generated.detailed.DetailedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public interface BookDao extends JpaRepository<Book, String> {
    public void initialise();

    public void initializeDetailedBooks();

    public List<DetailedBook> sortAllBooks();

    public List<DetailedBook> sortCategoryBooks(String category);

    public List<DetailedBook> getBooksByCategory(String category);

    public List<DetailedBook> getBooksBySearchedString(String searchedString);

    public List<DetailedBook> getBooksByCategoryAndSearchedString(String category, String search);

    public List<DetailedBook> getBooksBySearchedWordFromList(String searchedString, List<DetailedBook> booksToSearchFrom);

    public List<DetailedBook> getDetailedBookList();

    public List<String> getCategories();

    public DetailedBook getBookById(String id);

    public TreeMap<String, List<String>> orderCategoriesWithTreeMap();
}
