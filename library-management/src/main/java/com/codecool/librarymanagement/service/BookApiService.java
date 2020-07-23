package com.codecool.librarymanagement.service;

import com.codecool.librarymanagement.entity.BookCategory;
import com.codecool.librarymanagement.model.generated.Book;
import com.codecool.librarymanagement.model.generated.BooksResponse;
import com.codecool.librarymanagement.entity.DetailedBook;
import com.codecool.librarymanagement.repository.BookCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
@Service
public class BookApiService {

    private final BookCategoryRepository bookCategoryRepository;

    public BookApiService(BookCategoryRepository bookCategoryRepository){
        this.bookCategoryRepository = bookCategoryRepository;
    }

    public List<Book> getBookByCategory(String category) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.itbook.store/1.0/search/" + category;
        ResponseEntity<BooksResponse> booksResponseEntity = restTemplate.exchange(url, HttpMethod.GET,
                null, BooksResponse.class);
        return Objects.requireNonNull(booksResponseEntity.getBody()).getBooks();
    }

    public DetailedBook getDetailedBooksByIsbn(String isbn13, String category) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.itbook.store/1.0/books/" + isbn13;
        ResponseEntity<DetailedBook> bookResponseEntity = restTemplate.exchange(url, HttpMethod.GET,
                null, DetailedBook.class);
        Objects.requireNonNull(bookResponseEntity.getBody()).setBookCategory(bookCategoryRepository.findByName(category));
        Objects.requireNonNull(bookResponseEntity.getBody()).setUrl("/book/" + isbn13);
        return Objects.requireNonNull(bookResponseEntity.getBody());
    }

}
