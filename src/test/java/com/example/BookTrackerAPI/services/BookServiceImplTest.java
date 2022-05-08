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
	
}
