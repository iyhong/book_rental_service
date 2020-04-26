package com.hong.book_rental_service.dto;

import com.hong.book_rental_service.domian.BookStatus;
import com.hong.book_rental_service.domian.Member;

import java.time.LocalDateTime;

public class ResponseBookList {
    private Long id;
    private String title;
    private int price;
    private int stock;
    private String author;
    private BookStatus status;
    private Member requestMember;
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
                ", requestMember=" + requestMember.getName() +
                ", purchaseDateTime=" + purchaseDateTime +
                ", createdDateTime=" + createdDateTime +
                ", updatedDateTime=" + updatedDateTime +
                '}';
    }
}
