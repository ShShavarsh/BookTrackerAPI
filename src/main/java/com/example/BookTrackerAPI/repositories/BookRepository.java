package com.example.BookTrackerAPI.repositories;

import com.example.BookTrackerAPI.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
}
