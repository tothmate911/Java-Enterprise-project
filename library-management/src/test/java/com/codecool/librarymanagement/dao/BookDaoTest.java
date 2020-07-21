package com.codecool.librarymanagement.dao;

import com.codecool.librarymanagement.model.generated.detailed.DetailedBook;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookDaoTest {

    private BookDao bookDao;
    private List<String> categories;
    private List<DetailedBook> detailedBookList;

    private DetailedBook book1;
    private DetailedBook book2;
    private DetailedBook book3;

    @BeforeEach
    public void setup() {
        bookDao = new BookDaoMem();
        categories = List.of("python", "java");

        book1 = new DetailedBook();
        book1.setTitle("Test Java Book 2");
        book1.setSubtitle("Subtitle Java");
        book1.setCategory("java");

        book2 = new DetailedBook();
        book2.setTitle("Test Python Book 1");
        book2.setSubtitle("Subtitle");
        book2.setCategory("python");

        book3 = new DetailedBook();
        book3.setTitle("Test Java Book 1");
        book3.setSubtitle("Subtitle");
        book3.setCategory("java");

        detailedBookList = List.of(book1, book2, book3);
        bookDao.initialise(categories, detailedBookList);
    }

    @Test
    public void testSortAllBooks() {
        Assert.assertEquals(List.of(book3, book1, book2), bookDao.sortAllBooks());
    }

    @Test
    public void testSortCategoryBooks() {
        Assert.assertEquals(List.of(book3, book1), bookDao.sortCategoryBooks("java"));
    }

    @Test
    public void testGetBooksByCategory() {
        Assert.assertEquals(List.of(book1, book3), bookDao.getBooksByCategory("java"));
    }

    @Test
    public void testGetBooksBySearchedString() {
        Assert.assertEquals(List.of(book2), bookDao.getBooksBySearchedString("py"));
    }

    @Test
    public void testGetBooksByCategoryAndSearchedString() {
        Assert.assertEquals(List.of(book1, book3), bookDao.getBooksByCategoryAndSearchedString("java", "est"));
    }

    @Test
    public void testGetBookById() {
        Long id = book1.getId();
        Assert.assertEquals(book1, bookDao.getBookById(id));
    }

    @Test
    public void testOrderCategoriesWithTreeMap() {
        Map<String, List<String>> map = new HashMap<>();
        map.put("J", List.of("java"));
        map.put("P", List.of("python"));

        Assert.assertEquals(map, bookDao.orderCategoriesWithTreeMap());
    }
}