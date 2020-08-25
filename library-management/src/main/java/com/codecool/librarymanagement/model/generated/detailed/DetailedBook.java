package com.codecool.librarymanagement.model.generated.detailed;

import com.codecool.librarymanagement.entity.BookCategory;
import com.codecool.librarymanagement.entity.BookUser;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DetailedBook {

    @ManyToOne
    private BookCategory bookCategory;

    @Id
    @GeneratedValue
    private Long id;

    private String category;

    private Boolean available = true;

    private Date duedate;

    @JsonProperty("image")
    private String image;

    @JsonProperty("year")
    private String year;

    @JsonProperty("rating")
    private String rating;

    @JsonProperty("language")
    private String language;

    @Transient
    @JsonProperty("error")
    private String error;

    @Column(nullable = false)
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

    @JsonProperty("desc")
    @Column(columnDefinition = "text")
    private String description;

    @ManyToOne
    private BookUser user;

}

