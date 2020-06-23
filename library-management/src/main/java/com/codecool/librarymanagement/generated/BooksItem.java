package com.codecool.librarymanagement.generated;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BooksItem{

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

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setPrice(String price){
		this.price = price;
	}

	public String getPrice(){
		return price;
	}

	public void setSubtitle(String subtitle){
		this.subtitle = subtitle;
	}

	public String getSubtitle(){
		return subtitle;
	}

	public void setIsbn13(String isbn13){
		this.isbn13 = isbn13;
	}

	public String getIsbn13(){
		return isbn13;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"BooksItem{" + 
			"image = '" + image + '\'' + 
			",price = '" + price + '\'' + 
			",subtitle = '" + subtitle + '\'' + 
			",isbn13 = '" + isbn13 + '\'' + 
			",title = '" + title + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}