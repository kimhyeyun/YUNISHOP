package com.example.yunishop.service;

import com.example.yunishop.domain.member.Member;
import com.example.yunishop.domain.member.MemberRepository;
import com.example.yunishop.web.dto.MemberFormDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    public Long save(MemberFormDto memberFormDto) {
        return memberRepository.save(memberFormDto.toEntity()).getId();
    }

    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }
}
