package com.hong.book_rental_service.repository;

import com.hong.book_rental_service.domian.Book;
import com.hong.book_rental_service.dto.BookRequestCond;
import com.hong.book_rental_service.dto.BookResponseList;
import com.querydsl.core.types.Predicate;
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
    public List<BookResponseList> bookSearch() {
        List<BookResponseList> books = queryFactory
                .select(Projections.fields(BookResponseList.class,
                        book.id,
                        book.title,
                        book.price,
                        book.stock,
                        book.author,
                        book.status,
                        book.requester,
                        book.register,
                        book.purchaseDateTime,
                        book.createdDateTime,
                        book.updatedDateTime))
                .from(book)
                .fetch();
        return books;
    }

    @Override
    public List<BookResponseList> bookSearchByTitle(BookRequestCond requsetBookCond) {
        return queryFactory
                .select(Projections.fields(BookResponseList.class,
                        book.id,
                        book.title,
                        book.price,
                        book.stock,
                        book.author,
                        book.status,
                        book.requester,
                        book.register,
                        book.purchaseDateTime,
                        book.createdDateTime,
                        book.updatedDateTime))
                .from(book)
                .where(titleContainsIgnoreCase(requsetBookCond.getTitle()))
                .fetch();
    }

    private Predicate titleContainsIgnoreCase(String title) {
        return title != null ? book.title.containsIgnoreCase(title) : null;
    }
}
