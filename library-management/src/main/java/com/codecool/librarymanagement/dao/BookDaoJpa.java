package com.codecool.librarymanagement.dao;
import com.codecool.librarymanagement.entity.Book;
import com.codecool.librarymanagement.entity.BookCategory;
import com.codecool.librarymanagement.entity.DetailedBook;
import com.codecool.librarymanagement.repository.BookRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.*;

@Primary
@Component
public class BookDaoJpa implements BookDao {

    private BookRepository bookRepository;
    private List<String> categories = new ArrayList<>();

    public BookDaoJpa(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void initialise(List<String> categories, List<DetailedBook> detailedBookList) {
        this.categories = categories;
        detailedBookList.forEach(book -> bookRepository.save(book));
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
        if (searchedString.equals("@")) {
            return Collections.emptyList();
        } else {
            return bookRepository.findAllByTitleContainingIgnoreCase(searchedString);
        }
    }

    @Override
    public List<DetailedBook> getBooksByCategoryAndSearchedString(String  category, String searchedString) {
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
