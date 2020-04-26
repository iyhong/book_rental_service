package com.hong.book_rental_service.repository;

import com.hong.book_rental_service.domian.Member;
import com.hong.book_rental_service.dto.MemberLoginDto;

public interface MemberRepositoryCust {
    Member login(MemberLoginDto member);
}
