package com.codecool.librarymanagement.model.generated.detailed;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pdf{

	@JsonProperty("Chapter 5")
	private String chapter5;

	@JsonProperty("Chapter 2")
	private String chapter2;

	public void setChapter5(String chapter5){
		this.chapter5 = chapter5;
	}

	public String getChapter5(){
		return chapter5;
	}

	public void setChapter2(String chapter2){
		this.chapter2 = chapter2;
	}

	public String getChapter2(){
		return chapter2;
	}

	@Override
 	public String toString(){
		return 
			"Pdf{" + 
			"chapter 5 = '" + chapter5 + '\'' + 
			",chapter 2 = '" + chapter2 + '\'' + 
			"}";
		}
}