package com.ryj.feedproject;

import com.ryj.feedproject.entity.Feed;
import com.ryj.feedproject.repository.FeedRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class TransactionTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    FeedRepository feedRepository;

    @Test
    @Transactional
    @Rollback(value = false) // 테스트 코드에서 @Transactional 를 사용하면 테스트가 완료된 후 롤백하기 때문에 false 옵션 추가
    @DisplayName("메모 생성 성공")
    void test1() {
        Feed feed = new Feed();
        feed.setUsername("Rin");
        feed.setPassword("12345");
        feed.setContents("테스트해보기");

        em.persist(feed);  // 영속성 컨텍스트에 메모 Entity 객체를 저장합니다.
    }
}
