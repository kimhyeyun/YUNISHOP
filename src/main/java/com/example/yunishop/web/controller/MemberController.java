package com.example.yunishop.web.controller;

import com.example.yunishop.service.MemberService;
import com.example.yunishop.web.dto.MemberFormDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController("/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping(value = "/new")
    public String memberJoinForm() {
        return "member/joinForm";
    }

    @PostMapping(value = "/new")
    @ResponseBody
    public Long join(@RequestBody MemberFormDto memberFormDto) {

        return memberService.save(memberFormDto);
    }
}
