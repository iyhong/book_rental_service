package com.hong.book_rental_service.dto;

import com.hong.book_rental_service.domian.Member;
import com.hong.book_rental_service.domian.RentalStatus;

import java.time.LocalDateTime;
import java.util.List;

public class RentalResponseList {
    private Long id;
    private LocalDateTime rentalDateTime;
    private RentalStatus rentalStatus;
    private Member rentMember;
    List<BookResponseList> bookList;

    @Override
    public String toString() {
        return "ResponseRentalList{" +
                "id=" + id +
                ", rentalDateTime=" + rentalDateTime +
                ", rentalStatus=" + rentalStatus +
                ", rentMember=" + rentMember.getName() +
                ", bookList=" + bookList +
                '}';
    }
}
