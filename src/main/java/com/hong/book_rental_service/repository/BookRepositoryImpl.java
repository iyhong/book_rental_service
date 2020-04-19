package com.hong.book_rental_service.repository;

import com.hong.book_rental_service.domian.Book;
import com.hong.book_rental_service.domian.QBook;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;

import java.util.List;

import static com.hong.book_rental_service.domian.QBook.book;

@AllArgsConstructor
public class BookRepositoryImpl implements BookRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Book> serach() {
        List<Book> result = queryFactory.select(book)
                .from(book)
                .fetch();

        return result;
    }
}
