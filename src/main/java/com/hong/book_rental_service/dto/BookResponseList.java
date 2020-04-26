package com.hong.book_rental_service.dto;

import com.hong.book_rental_service.domian.BookStatus;
import com.hong.book_rental_service.domian.Member;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BookResponseList {
    private Long id;
    private String title;
    private int price;
    private int stock;
    private String author;
    private BookStatus status;
    private Member requester;
    private Member register;
    private LocalDateTime purchaseDateTime;
    private LocalDateTime createdDateTime;
    private LocalDateTime updatedDateTime;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", author='" + author + '\'' +
                ", status=" + status +
                ", requester=" + requester.getName() +
                ", register=" + register.getName() +
                ", purchaseDateTime=" + purchaseDateTime +
                ", createdDateTime=" + createdDateTime +
                ", updatedDateTime=" + updatedDateTime +
                '}';
    }
}
