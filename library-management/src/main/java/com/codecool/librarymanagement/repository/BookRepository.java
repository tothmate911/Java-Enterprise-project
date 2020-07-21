package com.codecool.librarymanagement.repository;

import com.codecool.librarymanagement.model.generated.detailed.DetailedBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<DetailedBook, String> {

}
