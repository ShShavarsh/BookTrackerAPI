package com.example.BookTrackerAPI.services;

import java.util.List;

import com.example.BookTrackerAPI.model.Book;

public interface BookService {

	List<Book> getBooks();

	Book getBookById(Long id);

	Book insert(Book todo);

    void updateBook(Long id, Book todo);

    void deleteBook(Long todoId);
}
