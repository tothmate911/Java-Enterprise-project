package com.codecool.librarymanagement.model.generated.detailed;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DetailedBook{

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

	@JsonProperty("url")
	private String url;

	@JsonProperty("pages")
	private String pages;

	@JsonProperty("pdf")
	private Pdf pdf;

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
	private String desc;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setYear(String year){
		this.year = year;
	}

	public String getYear(){
		return year;
	}

	public void setRating(String rating){
		this.rating = rating;
	}

	public String getRating(){
		return rating;
	}

	public void setLanguage(String language){
		this.language = language;
	}

	public String getLanguage(){
		return language;
	}

	public void setError(String error){
		this.error = error;
	}

	public String getError(){
		return error;
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

	public void setPages(String pages){
		this.pages = pages;
	}

	public String getPages(){
		return pages;
	}

	public void setPdf(Pdf pdf){
		this.pdf = pdf;
	}

	public Pdf getPdf(){
		return pdf;
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

	public void setPublisher(String publisher){
		this.publisher = publisher;
	}

	public String getPublisher(){
		return publisher;
	}

	public void setIsbn10(String isbn10){
		this.isbn10 = isbn10;
	}

	public String getIsbn10(){
		return isbn10;
	}

	public void setAuthors(String authors){
		this.authors = authors;
	}

	public String getAuthors(){
		return authors;
	}

	public void setDesc(String desc){
		this.desc = desc;
	}

	public String getDesc(){
		return desc;
	}

	@Override
 	public String toString(){
		return 
			"DetailedBook{" +
			"category = '" + category +'\'' +
			",image = '" + image + '\'' +
			",year = '" + year + '\'' + 
			",rating = '" + rating + '\'' + 
			",language = '" + language + '\'' + 
			",error = '" + error + '\'' + 
			",title = '" + title + '\'' + 
			",url = '" + url + '\'' + 
			",pages = '" + pages + '\'' + 
			",pdf = '" + pdf + '\'' + 
			",price = '" + price + '\'' + 
			",subtitle = '" + subtitle + '\'' + 
			",isbn13 = '" + isbn13 + '\'' + 
			",publisher = '" + publisher + '\'' + 
			",isbn10 = '" + isbn10 + '\'' + 
			",authors = '" + authors + '\'' + 
			",desc = '" + desc + '\'' + 
			"}";
		}
}