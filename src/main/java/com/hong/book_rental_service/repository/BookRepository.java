package com.hong.book_rental_service.repository;

import com.hong.book_rental_service.domian.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> , BookRepositoryCustom{
}
