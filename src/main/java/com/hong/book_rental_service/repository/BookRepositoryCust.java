package com.hong.book_rental_service.repository;

import com.hong.book_rental_service.domian.Book;
import com.hong.book_rental_service.dto.ResponseBookList;

import java.util.List;

public interface BookRepositoryCust {
    List<Book> serach();
    List<ResponseBookList> bookSearch();
}
