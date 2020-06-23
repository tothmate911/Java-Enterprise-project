package com.codecool.librarymanagement.service;
import com.codecool.librarymanagement.generated.Book;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookApiService {

    public Book getBookByMongo(String mongo){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Book> bookResponseEntity = restTemplate.exchange("https://api.itbook.store/1.0/search/"+mongo,
                HttpMethod.GET, null, Book.class);
        return bookResponseEntity.getBody();

    }
}
