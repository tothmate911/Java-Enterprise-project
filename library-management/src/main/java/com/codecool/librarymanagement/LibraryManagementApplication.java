package com.codecool.librarymanagement;

import com.codecool.librarymanagement.dao.BookDao;
import com.codecool.librarymanagement.repository.BookCategoryRepository;
import com.codecool.librarymanagement.service.BookApiService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class LibraryManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementApplication.class, args);
    }

    @Bean
    @Profile("production")
    public CommandLineRunner init(BookDao bookDao, BookApiService bookApiService, BookCategoryRepository bookCategoryRepository) {
        return new CommandLineLibraryManagementApplication(bookDao, bookApiService, bookCategoryRepository);
    }
}
