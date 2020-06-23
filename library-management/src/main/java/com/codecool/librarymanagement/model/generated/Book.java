package com.codecool.librarymanagement.model.generated;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {

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

	public String getImage(){
		return image;
	}

	public String getPrice(){
		return price;
	}

	public String getSubtitle(){
		return subtitle;
	}

	public String getIsbn13(){
		return isbn13;
	}

	public String getTitle(){
		return title;
	}

	public String getUrl(){
		return url;
	}
}