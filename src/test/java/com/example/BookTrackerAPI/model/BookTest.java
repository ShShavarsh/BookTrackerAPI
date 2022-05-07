package com.example.BookTrackerAPI.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BookTest {

	@Test
	public void testBookModelGetterMethods() {
		//setup
		Book cut = new Book("Title of the book",1997,"Shavarsh",999);
		
		//execute
		String title = cut.getTitle();
		int year = cut.getYearOfPublication();
		String author = cut.getAuthor();
		int length = cut.getLength();
		
		//assert
		assertTrue("Title of the book".equals(title));
		assertEquals(1997,year);
		assertTrue("Shavarsh".equals(author));
		assertEquals(999,length);
	}
}
