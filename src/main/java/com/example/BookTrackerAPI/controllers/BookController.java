package com.example.BookTrackerAPI.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.BookTrackerAPI.model.Book;
import com.example.BookTrackerAPI.services.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {
    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //The function receives a GET request, processes it and gives back a list of Book as a response.
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book>books = bookService.getBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
    
    //The function receives a GET request, processes it, and gives back a list of Book as a response.
    @GetMapping({"/{bookId}"})
    public ResponseEntity<Book> getBook(@PathVariable Long bookId) {
        return new ResponseEntity<>(bookService.getBookById(bookId), HttpStatus.OK);
    }
    
    //The function receives a POST request, processes it, creates a new Book and saves it to the database, and returns a resource link to the created book.          
    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
    	Book book1 = bookService.insert(book);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("book", "/api/v1/book/" + book1.getId().toString());
        return new ResponseEntity<>(book1, httpHeaders, HttpStatus.CREATED);
    }
    
    //The function receives a PUT request, updates the Book with the specified Id and returns the updated Book
    @PutMapping({"/{bookId}"})
    public ResponseEntity<Book> updateBook(@PathVariable("bookId") Long bookId, @RequestBody Book book) {
    	bookService.updateBook(bookId, book);
        return new ResponseEntity<>(bookService.getBookById(bookId), HttpStatus.OK);
    }
    
    //The function receives a DELETE request, deletes the Book with the specified Id.
    @DeleteMapping({"/{bookId}"})
    public ResponseEntity<Book> deleteBook(@PathVariable("bookId") Long bookId) {
    	bookService.deleteBook(bookId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
