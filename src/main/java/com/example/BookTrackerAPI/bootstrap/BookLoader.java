package com.example.BookTrackerAPI.bootstrap;

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
//        if (bookRepository.count() == 0) {
//        	bookRepository.save(
//        			Book.builder()
//                            .title("Title1")
//                            .author("Author1")
//                            .yearOfPublication(0)
//                            .length(1)
//                            .build()
//            );
//        	bookRepository.save(
//        			Book.builder()
//                            .title("Title2")
//                            .author("Author2")
//                            .yearOfPublication(0)
//                            .length(1)
//                            .build()
//            );
//            System.out.println("Sample Books Loaded");
//        }
    }
}
