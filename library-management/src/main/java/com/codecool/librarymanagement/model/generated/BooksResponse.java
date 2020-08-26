package com.codecool.librarymanagement.model.generated;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BooksResponse {

    @JsonProperty("total")
    private String total;

    @JsonProperty("books")
    private List<Book> books;

    @JsonProperty("page")
    private String page;

    @JsonProperty("error")
    private String error;

}
