package com.sparta.mini_projcet.controller;

import com.sparta.mini_projcet.dto.SignupRequestDto;
import com.sparta.mini_projcet.model.Member;
import com.sparta.mini_projcet.service.MemberService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;


    // 회원 가입 요청 처리
    @PostMapping("/user/register")
    public Member registerUser(@RequestBody SignupRequestDto requestDto) {
        return memberService.registerUser(requestDto);
    }

    // 로그인 테스트
    @GetMapping("/")
    public String test(String pw){
       /* BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encrypted_pw = encoder.encode("aaaaaa");
        if(encoder.matches(pw, encrypted_pw))
            return "accept : " + encrypted_pw;
        else
            return "떙";*/
        return "login";
    }

}