package com.hong.book_rental_service.repository;

import com.hong.book_rental_service.domian.Book;
import com.hong.book_rental_service.dto.BookRequestCond;
import com.hong.book_rental_service.dto.BookResponseList;

import java.util.List;

public interface BookRepositoryCust {
    List<Book> serach();
    List<BookResponseList> bookSearch();
    List<BookResponseList> bookSearchByTitle(BookRequestCond bookCond);
}
