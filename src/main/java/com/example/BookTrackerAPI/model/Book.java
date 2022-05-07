package com.example.BookTrackerAPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	 private String title;
	 private int yearOfPublication;
	 private String author;
	 private int length;
	
}
