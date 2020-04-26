package com.hong.book_rental_service.domian;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
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
    @Enumerated(value = EnumType.STRING)
    private MemberType memberType;
    private LocalDateTime createdDateTime;
    private LocalDateTime updatedDateTime;

    @Builder
    public Member (String name, String resno, String password, String email, List<Rental> rentals, MemberType memberType,
                   LocalDateTime createdDateTime, LocalDateTime updatedDateTime){
        this.name = name;
        this.resno = resno;
        this.password = password;
        this.email = email;
        this.rentals = rentals;
        this.memberType = memberType;
        this.createdDateTime = createdDateTime;
        this.updatedDateTime = updatedDateTime;
    }

    public void modifyMember(Member modifiedMember) {
        this.name = modifiedMember.name;
        this.password = modifiedMember.password;
    }
}
