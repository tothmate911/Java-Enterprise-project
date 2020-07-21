package com.codecool.librarymanagement.repository;

import com.codecool.librarymanagement.model.generated.detailed.DetailedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<DetailedBook, Long> {

    List<DetailedBook> findAllByOrderByTitle();

    List<DetailedBook> findAllByCategoryOrderByTitle(String category);

    List<DetailedBook> findAllByCategory(String category);

    List<DetailedBook> findAllByTitleContaining(String searchedString);

    List<DetailedBook> findAllByCategoryAndTitleContaining(String category, String searchedString);

}
