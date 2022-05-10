package com.example.BookTrackerAPI.bootstrap;

import com.example.BookTrackerAPI.model.Book;
import com.example.BookTrackerAPI.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BookLoader implements CommandLineRunner {

	public final BookRepository bookRepository;

	public BookLoader(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		loadBooks();
	}

	private void loadBooks() {

	}
}
