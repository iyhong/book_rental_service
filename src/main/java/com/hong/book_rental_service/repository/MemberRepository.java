package com.hong.book_rental_service.repository;

import com.hong.book_rental_service.domian.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findById(Long id);
}
