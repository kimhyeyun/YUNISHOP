package com.example.yunishop.web.controller;

import com.example.yunishop.service.MemberService;
import com.example.yunishop.web.dto.MemberFormDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController("/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    @GetMapping(value = "/new")
    public String memberJoinForm() {
        return "member/joinForm";
    }

    @PostMapping(value = "/new")
    @ResponseBody
    public Long join(@RequestBody MemberFormDto memberFormDto) {
        String encodePassword = passwordEncoder.encode(memberFormDto.getPassword());
        memberFormDto.setPassword(encodePassword);

        return memberService.save(memberFormDto);
    }
}
