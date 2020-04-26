package com.hong.book_rental_service.repository;

import com.hong.book_rental_service.domian.Rental;
import com.hong.book_rental_service.dto.RentalRequestCond;
import com.hong.book_rental_service.dto.RentalResponseList;

import java.util.List;

public interface RentalRepositoryCust {
    List<RentalResponseList> rentalSearch(RentalRequestCond requestRentalCond);
}
