package com.hong.book_rental_service.repository;

import com.hong.book_rental_service.domian.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long>, RentalRepositoryCust{
}
