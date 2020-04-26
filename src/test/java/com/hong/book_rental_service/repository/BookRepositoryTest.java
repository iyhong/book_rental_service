package com.hong.book_rental_service.repository;

import com.hong.book_rental_service.domian.Book;
import com.hong.book_rental_service.domian.BookStatus;
import com.hong.book_rental_service.domian.Member;
import com.hong.book_rental_service.dto.BookRequestCond;
import com.hong.book_rental_service.dto.BookResponseList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
        createBook("vue.js", "원형섭", 30000, member, member);
        createBook("reactJS 한큐에", "엄제경", 20000, member, member);
        createBook("html", "채신욱", 35000, member, member);
        createBook("스프링 부트", "홍인용", 25000, member, member);
        createBook("책읽어주는 신부", "김미림", 14000, member, member);

        List<Book> all = bookRepository.findAll();
    }

    private void createBook(String title, String author, int price, Member requester, Member register) {
        Book book = Book.builder()
                .title(title)
                .author(author)
                .status(BookStatus.ENABLE)
                .requester(requester)
                .register(register)
                .price(price)
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
    public void 도서목록_전체_조회(){
        List<BookResponseList> books = bookRepository.bookSearch();
        for (BookResponseList book : books) {
            System.out.println("book = " + book);
        }

        assertThat(books.size()).isEqualTo(5);
    }

    @Test
    public void 도서목록_제목으로_조회(){
        BookRequestCond bookCond = new BookRequestCond("js");
        List<BookResponseList> books = bookRepository.bookSearchByTitle(bookCond);
        for (BookResponseList book : books) {
            System.out.println("book = " + book);
        }
        assertThat(books.size()).isEqualTo(2);

    }

    @Test
    public void 도서목록_제목으로_조회_검색어없이(){
        BookRequestCond bookCond = new BookRequestCond("");
        List<BookResponseList> books = bookRepository.bookSearchByTitle(bookCond);
        for (BookResponseList book : books) {
            System.out.println("book = " + book);
        }
        assertThat(books.size()).isEqualTo(5);

    }

}