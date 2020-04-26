package com.hong.book_rental_service.repository;

import com.hong.book_rental_service.domian.Rental;
import com.hong.book_rental_service.dto.RentalRequestCond;
import com.hong.book_rental_service.dto.RentalResponseList;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;

import java.util.List;

import static com.hong.book_rental_service.domian.QRental.rental;

@AllArgsConstructor
public class RentalRepositoryImpl implements RentalRepositoryCust {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<RentalResponseList> rentalSearch(RentalRequestCond requestRentalCond) {
        return queryFactory
                .select(Projections.fields(RentalResponseList.class,
                        rental.id,
                        rental.rentalDateTime))
                .from(rental)
                .fetch();
    }
}
