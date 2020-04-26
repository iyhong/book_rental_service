package com.hong.book_rental_service.domian;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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
    @Enumerated(value = EnumType.STRING)
    private BookStatus status;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "requester")
    private Member requester;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "register")
    private Member register;

    private LocalDateTime purchaseDateTime;
    @CreatedDate
    private LocalDateTime createdDateTime;
    @LastModifiedDate
    private LocalDateTime updatedDateTime;

    @Builder
    public Book(String title, int price, int stock, String author,
                BookStatus status, Member requester, Member register){
        this.title = title;
        this.price = price;
        this.stock = stock;
        this.author = author;
        this.status = status;
        this.requester = requester;
        this.register = register;
    }

}
