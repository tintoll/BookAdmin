package com.book.repository;

import com.book.Reader;
import com.book.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by tinoll on 2017. 1. 21..
 */

//JpaRepository를 확장하여 공통되니 영속성 연산을 수행하는 메서드 18개를 상속받는다
//인터페이스 이지만 런타임시 자동으로 구현이 된다고 함
public interface ReadingListRepository extends JpaRepository<Book,Long> { //첫번째인자는 도메인타입,두번째는 클래스의 ID프로퍼티 타입
    List<Book> findByReader(Reader reader);
}
