package com.example.Bookstore.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findBookByAuthor(String author);
}
