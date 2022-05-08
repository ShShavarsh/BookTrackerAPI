package com.example.BookTrackerAPI.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BookTest {

	@Test
	public void testBookModelGetterMethods() {
		//setup
		Book cut = new Book("Title of the book",1997,"Shavarsh",999,1L);
		
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
	
	@Test
	public void testBookModelSetterMethods() {
		//setup
		Book cut = new Book();
		
		//execute
		cut.setAuthor("Shavarsh");
		cut.setLength(999);
		cut.setTitle("Title of the book");
		cut.setYearOfPublication(1997);
		
		//assert
		assertTrue("Title of the book".equals(cut.getTitle()));
		assertEquals(1997,cut.getYearOfPublication());
		assertTrue("Shavarsh".equals(cut.getAuthor()));
		assertEquals(999,cut.getLength());
	}
}
