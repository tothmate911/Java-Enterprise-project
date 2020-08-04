package com.codecool.librarymanagement.repository;

import com.codecool.librarymanagement.entity.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Long> {

    BookCategory findByName(String category);

}
