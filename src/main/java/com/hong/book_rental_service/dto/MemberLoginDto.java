package com.hong.book_rental_service.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberLoginDto {
    private String email;
    private String password;
}
