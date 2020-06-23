package com.codecool.librarymanagement.generated;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;


public class Book{

	@JsonProperty("total")
	private String total;

	@JsonProperty("books")
	private List<BooksItem> books;

	@JsonProperty("page")
	private String page;

	@JsonProperty("error")
	private String error;

	public void setTotal(String total){
		this.total = total;
	}

	public String getTotal(){
		return total;
	}

	public void setBooks(List<BooksItem> books){
		this.books = books;
	}

	public List<BooksItem> getBooks(){
		return books;
	}

	public void setPage(String page){
		this.page = page;
	}

	public String getPage(){
		return page;
	}

	public void setError(String error){
		this.error = error;
	}

	public String getError(){
		return error;
	}

	@Override
 	public String toString(){
		return 
			"Book{" + 
			"total = '" + total + '\'' + 
			",books = '" + books + '\'' + 
			",page = '" + page + '\'' + 
			",error = '" + error + '\'' + 
			"}";
		}
}