package com.codecool.librarymanagement.repository;

import com.codecool.librarymanagement.entity.BookUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<BookUser, Long> {
}
