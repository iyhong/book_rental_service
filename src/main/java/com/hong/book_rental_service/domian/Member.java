package com.hong.book_rental_service.domian;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;
    private String resno;
    private String password;
    private String email;
    @OneToMany(mappedBy = "member")
    private List<Rental> rentals;
    private MemberType memberType;
    private LocalDateTime createdDateTime;
    private LocalDateTime updatedDateTime;


}
