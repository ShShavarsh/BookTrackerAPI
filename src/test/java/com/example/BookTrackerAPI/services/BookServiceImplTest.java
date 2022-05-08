package com.example.BookTrackerAPI.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
		// setup

		// execute
		List<Book> books = cut.getBooks();

		// assert
		assertTrue(books.isEmpty());
	}

	@Test
	public void afterAddingBookToBooksListItShouldReturnTheSameBook() {
		// setup
		Book book = new Book("Title of the book", 1997, "Shavarsh", 999, 1L);

		// execute
		Book savedBook = cut.insert(book);

		// assert
		assertTrue(savedBook.getId() == book.getId());

		// tear down
		cut.deleteBook(book.getId());
	}

	@Test
	public void afterDeletingBookFromBooksListItShouldBeEmpty() {
		// setup
		Book book = new Book("Title of the book", 1997, "Shavarsh", 999, 10L);
		Book savedBook = cut.insert(book);

		// execute
		cut.deleteBook(savedBook.getId());

		// assert
		assertTrue(cut.getBooks().isEmpty());

		// tear down
	}

	@Test
	public void afterUpdatingBookFromBooksListItShouldBeUpdated() {
		// setup
		Book initialBook = new Book("Title of the book", 1997, "Shavarsh", 999, 10L);
		Book savedBook = cut.insert(initialBook);

		// execute
		Book updatedBook = new Book("Title of the book Updated", 1998, "Shavarsh Shahoyan", 1000, 10L);
		cut.updateBook(savedBook.getId(), updatedBook);

		// assert
		assertTrue(cut.getBooks().get(0).getTitle().equals(updatedBook.getTitle()));
		assertTrue(cut.getBooks().get(0).getAuthor().equals(updatedBook.getAuthor()));
		assertTrue(cut.getBooks().get(0).getLength() == updatedBook.getLength());
		assertTrue(cut.getBooks().get(0).getYearOfPublication() == updatedBook.getYearOfPublication());

		// tear down
		cut.deleteBook(savedBook.getId());
	}

	@Test
	public void afterInsertingBookIntoBooksListItShouldBeAccessibleByID() {
		// setup
		Book initialBook = new Book("Title of the book", 1997, "Shavarsh", 999, 10L);
		Book savedBook = cut.insert(initialBook);

		// execute
		Book returnedBookByID = cut.getBookById(savedBook.getId());

		// assert
		assertTrue(cut.getBooks().get(0).getTitle().equals(returnedBookByID.getTitle()));
		assertTrue(cut.getBooks().get(0).getAuthor().equals(returnedBookByID.getAuthor()));
		assertTrue(cut.getBooks().get(0).getLength() == returnedBookByID.getLength());
		assertTrue(cut.getBooks().get(0).getYearOfPublication() == returnedBookByID.getYearOfPublication());

		// tear down
		cut.deleteBook(savedBook.getId());
	}

}
