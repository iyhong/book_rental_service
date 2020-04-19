package com.hong.book_rental_service.domian;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
public class Rental {

    @Id @GeneratedValue
    @Column(name = "rental_id")
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    private RentalStatus rentalStatus;
    private LocalDateTime rentalDateTime;
    private LocalDateTime returnDateTime;
    private LocalDateTime mailSentDateTime;

}
