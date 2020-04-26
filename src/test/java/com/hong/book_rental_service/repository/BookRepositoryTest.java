package com.hong.book_rental_service.repository;

import com.hong.book_rental_service.domian.Book;
import com.hong.book_rental_service.domian.BookStatus;
import com.hong.book_rental_service.domian.Member;
import com.hong.book_rental_service.dto.ResponseBookList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.iterable;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    MemberRepository memberRepository;

    @BeforeEach
    public void 책등록() {
        Member member = Member.builder()
                .name("inyong")
                .build();

        memberRepository.save(member);
        for (int i = 0; i < 10; i++) {
             createBook(i, member);
        }
    }

    private void createBook(int i, Member member) {
        Book book = Book.builder()
                .title("book" + i)
                .author("mirim" + i)
                .status(BookStatus.ENABLE)
                .requestMember(member)
                .price(30)
                .build();

        Book savedBook = bookRepository.save(book);
    }

    @Test
    public void crudTest(){
        Book book = Book.builder()
                .title("book1")
                .author("inyong")
                .price(30)
                .build();

        Book savedBook = bookRepository.save(book);

//        Optional<Book> findBook = bookRepository.findById(savedBook.getId());
//        Assertions.assertThat(findBook.get().getTitle()).isEqualTo(book.getTitle());
        List<Book> search = bookRepository.serach();
        assertThat(search.get(0).getTitle()).isEqualTo(book.getTitle());
    }

    @Test
    public void 도서목록_조회(){
        List<ResponseBookList> books = bookRepository.bookSearch();
        for (ResponseBookList book : books) {
            System.out.println("book = " + book);
        }
    }

}