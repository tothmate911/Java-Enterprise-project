package com.codecool.librarymanagement.repository;
import com.codecool.librarymanagement.entity.BookCategory;
import com.codecool.librarymanagement.entity.DetailedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<DetailedBook, Long> {

    List<DetailedBook> findAllByOrderByTitle();

    List<DetailedBook> findAllByBookCategoryOrderByTitle(BookCategory category);

    //List<DetailedBook> findAllByBookCategory(BookCategory category);

    List<DetailedBook> findAllByBookCategory_Name(String name);

    List<DetailedBook> findAllByTitleContainingIgnoreCase(String searchedString);

    List<DetailedBook> findAllByBookCategoryAndTitleContaining(BookCategory category, String searchedString);

}
