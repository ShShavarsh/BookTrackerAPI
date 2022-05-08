package com.example.BookTrackerAPI.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Book {
	private String title;
	private int yearOfPublication;
	private String author;
	private int length;
	@Id
    @GeneratedValue
    private Long id;
	
}
