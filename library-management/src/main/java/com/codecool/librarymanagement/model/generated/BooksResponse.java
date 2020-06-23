package com.codecool.librarymanagement.model.generated;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BooksResponse {

	@JsonProperty("total")
	private String total;

	@JsonProperty("books")
	private List<Book> books;

	@JsonProperty("page")
	private String page;

	@JsonProperty("error")
	private String error;

	public String getTotal(){
		return total;
	}

	public List<Book> getBooks(){
		return books;
	}

	public String getPage(){
		return page;
	}

	public String getError(){
		return error;
	}
}