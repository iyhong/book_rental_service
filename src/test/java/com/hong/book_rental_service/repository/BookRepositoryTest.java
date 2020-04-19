package com.hong.book_rental_service.repository;

import com.hong.book_rental_service.domian.Book;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    public void crudTest(){
        Book book = Book.builder()
                .title("book1")
                .author("inyong")
                .price(30)
                .build();

        Book savedBook = bookRepository.save(book);

//        Optional<Book> findBook = bookRepository.findById(savedBook.getId());
//        Assertions.assertThat(findBook.get().getTitle()).isEqualTo(book.getTitle());
        List<Book> search = bookRepository.serach();
        assertThat(search.get(0).getTitle()).isEqualTo(book.getTitle());
    }

}