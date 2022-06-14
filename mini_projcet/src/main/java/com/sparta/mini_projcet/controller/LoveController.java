package com.sparta.mini_projcet.controller;

import com.sparta.mini_projcet.exception.ApiResponseMessage;
import com.sparta.mini_projcet.security.UserDetailsImpl;
import com.sparta.mini_projcet.service.LoveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LoveController {

    private final LoveService loveService;

    @PostMapping("/api/loves/{noticeId}")
    public ResponseEntity<Boolean> loveClick(@PathVariable Long noticeId, @AuthenticationPrincipal UserDetailsImpl userDetails){
        Long memberId = userDetails.getMember().getId();
//        loveService.loveUp(noticeId , memberId);
        return new ResponseEntity<>(loveService.loveUp(noticeId , memberId), HttpStatus.OK);
    }
}
