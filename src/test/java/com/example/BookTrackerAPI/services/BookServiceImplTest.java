package com.example.BookTrackerAPI.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.BookTrackerAPI.model.Book;

@SpringBootTest
public class BookServiceImplTest {

	
	@Autowired
    private BookServiceImpl cut;

	@Test
	public void onFirstCallGetBooksShouldReturnEmptyBookList() {
		//setup
		
		//execute
		List<Book> books = cut.getBooks();
		
		//assert
		assertTrue(books.isEmpty());
	}
	
	@Test
	public void afterAddingBookToBooksListItShouldReturnTheSameBook() {
		//setup
		Book book = new Book("Title of the book",1997,"Shavarsh",999,1L);
		
		//execute
		Book savedBook = cut.insert(book);
		
		//assert
		assertTrue(savedBook.getId() == book.getId());
		
		//tear down
		cut.deleteBook(book.getId());
	}
	
	@Test
	public void afterDeletingBookFromBooksListItShouldBeEmpty() {
		//setup
		Book book = new Book("Title of the book",1997,"Shavarsh",999,10L);
		Book savedBook = cut.insert(book);
		
		//execute
		cut.deleteBook(savedBook.getId());
		
		//assert
		assertTrue(cut.getBooks().isEmpty());
		
		//tear down
	}
	
	

}
