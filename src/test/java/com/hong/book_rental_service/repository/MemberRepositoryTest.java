package com.hong.book_rental_service.repository;

import com.hong.book_rental_service.domian.Member;
import com.hong.book_rental_service.domian.MemberType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberRepositoryTest {

    @Autowired
    EntityManager em;

    @Autowired
    MemberRepository memberRepository;

    private Long testID;
    private String email = "test@email.com";
    private String inyong = "inyong";
    private String resno = "38416";
    private String pass = "pass";

//    @BeforeEach
//    public void init(){
//        Member member = Member.builder()
//                .email("inyong@email.com")
//                .password("1234")
//                .build();
//        Member savedMember = memberRepository.save(member);
//        testID = savedMember.getId();
//    }

    @Test
    @BeforeEach
    public void 회원가입(){

        Member member = Member.builder()
                .email(email)
                .password(pass)
                .name(inyong)
                .memberType(MemberType.ADMIN)
                .resno(resno)
                .build();
        Member savedMember = memberRepository.save(member);
        testID = savedMember.getId();

        assertThat(savedMember.getEmail()).isEqualTo(email);
        assertThat(savedMember.getName()).isEqualTo(inyong);
        assertThat(savedMember.getPassword()).isEqualTo(pass);
        assertThat(savedMember.getResno()).isEqualTo(resno);

        em.flush();
        em.clear();
    }

    @Test
    public void 로그인(){
        Optional<Member> findMember = memberRepository.findById(testID);
        assertThat(findMember.isPresent()).isTrue();
        assertThat(findMember.get().getPassword()).isEqualTo(pass);
    }

    @Test
    public void 회원수정(){
        Optional<Member> optionalMember = memberRepository.findById(testID);
        Member findMember = null;
        if(optionalMember.isPresent()){
            findMember = optionalMember.get();
        }
        // 수정 : 이름, 비밀번호,
        Member modifiedMember = Member.builder()
                .name("new_name")
                .password("new_pass")
                .build();
        findMember.modifyMember(modifiedMember);

        assertThat(findMember.getName()).isEqualTo("new_name");
        assertThat(findMember.getPassword()).isEqualTo("new_pass");
    }
}