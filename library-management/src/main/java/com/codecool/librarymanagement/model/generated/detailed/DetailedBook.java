package com.codecool.librarymanagement.model.generated.detailed;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class DetailedBook {

    @Id
    @GeneratedValue
    private Long id;

    private String category;

    @JsonProperty("image")
    private String image;

    @JsonProperty("year")
    private String year;

    @JsonProperty("rating")
    private String rating;

    @JsonProperty("language")
    private String language;

    @JsonProperty("error")
    private String error;

    @JsonProperty("title")
    private String title;

    private String url;

    @JsonProperty("pages")
    private String pages;

//	@JsonProperty("pdf")
//	private Pdf pdf;

    @JsonProperty("price")
    private String price;

    @JsonProperty("subtitle")
    private String subtitle;

    @JsonProperty("isbn13")
    private String isbn13;

    @JsonProperty("publisher")
    private String publisher;

    @JsonProperty("isbn10")
    private String isbn10;

    @JsonProperty("authors")
    private String authors;

    @Column(columnDefinition = "LONGTEXT")
    @JsonProperty("desc")
    private String desc;

}
