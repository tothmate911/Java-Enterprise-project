package com.codecool.librarymanagement.model.generated;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Book {

    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @JsonProperty("image")
    private String image;

    @JsonProperty("price")
    private String price;

    @JsonProperty("subtitle")
    private String subtitle;

    @JsonProperty("isbn13")
    private String isbn13;

    @JsonProperty("title")
    private String title;

    @JsonProperty("url")
    private String url;

}
