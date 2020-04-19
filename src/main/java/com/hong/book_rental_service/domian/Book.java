package com.hong.book_rental_service.domian;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
public class Book {
    @Id @GeneratedValue
    @Column(name = "book_id")
    private Long id;
    private String title;
    private int price;
    private int stock;
    private String author;
    private BookStatus status;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member")
    private Member requestMember;
    private LocalDateTime purchaseDateTime;
    private LocalDateTime createdDateTime;
    private LocalDateTime updatedDateTime;

    @Builder
    public Book(String title, int price, int stock, String author,
                BookStatus status, Member requestMember){
        this.title = title;
        this.price = price;
        this.stock = stock;
        this.author = author;
        this.status = status;
        this.requestMember = requestMember;
    }
}
