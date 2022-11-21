package com.example.yunishop.domain.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    void 회원_저장_테스트() {
        Member member = new Member();
        member.setName("테스트");
        member.setMemberId("테스트");
        member.setPassword("테스트");
        member.setPostCode(111);
        member.setAddress("테스트");
        member.setAddtionalAddress("테스트");

        Member savedMember = memberRepository.save(member);

        System.out.println(savedMember.toString());
    }

}