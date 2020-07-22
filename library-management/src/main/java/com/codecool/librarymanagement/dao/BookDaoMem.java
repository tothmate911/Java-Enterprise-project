package com.codecool.librarymanagement.dao;

import com.codecool.librarymanagement.model.generated.detailed.DetailedBook;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component(value = "bookDaoMem")
public class BookDaoMem implements BookDao {

    private List<DetailedBook> detailedBookList;
    private List<String> categories;
    private static Long idCounter = 0L;

    public void initialise(List<String> categories, List<DetailedBook> detailedBookList) {
        this.categories = categories;
        detailedBookList.forEach(book -> book.setId(++idCounter));
        this.detailedBookList = detailedBookList;
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
        if (searchedString.equals("@")) {
            return Collections.emptyList();
        } else {
            return getBooksBySearchedWordFromList(searchedString, detailedBookList);
        }
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
                map.put(firstChar.toUpperCase(), new ArrayList<>(Collections.singletonList(category)));
            } else {
                map.get(firstChar.toUpperCase()).add(category);
            }
        }
        return new TreeMap<>(map);
    }
}
