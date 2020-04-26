package com.hong.book_rental_service.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.EntityManager;

@Configuration
@AllArgsConstructor
@EnableJpaAuditing
public class MyConfiguration {

    private final EntityManager em;

    @Bean
    JPAQueryFactory queryFactory(){
        return new JPAQueryFactory(em);
    }
}
