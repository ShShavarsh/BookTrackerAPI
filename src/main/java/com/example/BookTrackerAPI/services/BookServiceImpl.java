package com.example.BookTrackerAPI.services;

import org.springframework.stereotype.Service;

import com.example.BookTrackerAPI.model.Book;
import com.example.BookTrackerAPI.repositories.BookRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
	BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBooks() {
    	List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }

    @Override
    public Book getBookById(Long id) {
        return null;
    }

    @Override
    public Book insert(Book book) {
    	 return null;
    }

    @Override
    public void updateBook(Long id, Book book) {
    	
    }

    @Override
    public void deleteBook(Long bookId) {
    	
    }
}
