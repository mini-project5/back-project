package com.sparta.mini_projcet.controller;

import com.sparta.mini_projcet.dto.SignupRequestDto;
import com.sparta.mini_projcet.exception.ApiResponseMessage;
import com.sparta.mini_projcet.service.MemberService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ApiResponseMessage>  registerUser(@RequestBody SignupRequestDto requestDto) {
        memberService.registerUser(requestDto);

        ApiResponseMessage message = new ApiResponseMessage("Success", "회원가입이 완료되었습니다", "", "");
        return new ResponseEntity<ApiResponseMessage>(message, HttpStatus.OK);
    }


//    List<SimpleOrderDto> result = orders.stream() .map(o -> new SimpleOrderDto(o)) .collect(Collectors.toList());
}