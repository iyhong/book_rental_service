package com.hong.book_rental_service.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Book {
    @Id @GeneratedValue
    @Column(name = "book_id")
    private Long id;
    private String title;
    private int price;
    private int stock;
    private String author;
    private BookStatus status;
    @OneToOne
    @JoinColumn(name = "member")
    private Member requestMember;
    private LocalDateTime purchaseDateTime;
    private LocalDateTime createdDateTime;
    private LocalDateTime updatedDateTime;
}
