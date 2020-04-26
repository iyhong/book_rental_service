package com.hong.book_rental_service.repository;

import com.hong.book_rental_service.domian.Book;
import com.hong.book_rental_service.dto.ResponseBookList;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;

import java.util.List;

import static com.hong.book_rental_service.domian.QBook.book;

@AllArgsConstructor
public class BookRepositoryImpl implements BookRepositoryCust {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Book> serach() {
        List<Book> result = queryFactory.select(book)
                .from(book)
                .fetch();

        return result;
    }

    @Override
    public List<ResponseBookList> bookSearch() {
        List<ResponseBookList> books = queryFactory
                .select(Projections.fields(ResponseBookList.class,
                        book.id,
                        book.title,
                        book.price,
                        book.stock,
                        book.author,
                        book.status,
                        book.requestMember,
                        book.purchaseDateTime,
                        book.createdDateTime,
                        book.updatedDateTime))
                .from(book)
                .fetch();
        return books;
    }
}
