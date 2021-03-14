package com.example.Bookstore;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void findByAuthorShouldReturnBook(){
        List<Book> books = bookRepository.findBookByAuthor("Leo Tolstoy");

        Assertions.assertThat(books).hasSize(1);
        Assertions.assertThat(books.get(0).getTitle()).isEqualTo("War and Peace");
    }

    @Test
    public void createNewBook(){
        Book book = new Book("Farewell To Arms", "Ernest Hemingway", "1232323-21", 1929, 10.0, new Category("Romance"));
        bookRepository.save(book);
        Assertions.assertThat(book.getId()).isNotNull();
    }

    @Test
    public void deleteBook(){
        long id = bookRepository.findBookByAuthor("Leo Tolstoy").get(0).getId();
        bookRepository.deleteById(id);
        Assertions.assertThat(bookRepository.findById(id)).isEmpty();
    }
}
