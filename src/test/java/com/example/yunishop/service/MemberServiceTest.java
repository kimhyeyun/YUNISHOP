package com.example.yunishop.service;

import com.example.yunishop.domain.member.Member;
import com.example.yunishop.web.dto.MemberFormDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.transaction.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    public MemberFormDto createMember() {
        MemberFormDto memberFormDto = new MemberFormDto();
        memberFormDto.setMemberId("test");
        memberFormDto.setName("테스트");
        memberFormDto.setPassword("password");
        memberFormDto.setPostCode(2222);
        memberFormDto.setAddress("테스트");
        memberFormDto.setAdditionalAddress("테스트");

        return memberFormDto;
    }

    @Test
    void 회원_가입_테스트() {
        MemberFormDto memberFormDto = createMember();
        Long id = memberService.save(memberFormDto);
        Optional<Member> savedMember = memberService.findById(id);

        assertEquals(savedMember.get().getMemberId(), memberFormDto.getMemberId());
    }
}