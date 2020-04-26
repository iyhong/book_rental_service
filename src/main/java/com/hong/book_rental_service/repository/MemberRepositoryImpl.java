package com.hong.book_rental_service.repository;

import com.hong.book_rental_service.domian.Member;
import com.hong.book_rental_service.dto.MemberLoginDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberRepositoryImpl implements MemberRepositoryCust {
    @Autowired
    JPAQueryFactory queryFactory;

    @Override
    public Member login(MemberLoginDto member) {
//        queryFactory.select()
        return null;
    }


}
