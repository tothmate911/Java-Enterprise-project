package com.codecool.librarymanagement.conrtoller;

import com.codecool.librarymanagement.service.BookStorage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BookController {

    private BookStorage bookStorage;

    public BookController(BookStorage bookStorage) {
        this.bookStorage = bookStorage;
    }

    @GetMapping("/books")
    public String getBooks() {

        String url = "http://openlibrary.org/api/books?bibkeys=ISBN:0385472579,LCCN:62019420&format=json";
        RestTemplate restTemplate = new RestTemplate();

        String result = restTemplate.getForObject(url, String.class);
        System.out.println(result);

        return result;
    }



}
