package com.codecool.librarymanagement.dao;

import com.codecool.librarymanagement.model.generated.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDoaJpa extends BookDao, JpaRepository<Book, String> {

}
