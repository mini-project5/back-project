package com.sparta.mini_projcet.controller;

import com.sparta.mini_projcet.dto.NoticeCreateDto;
import com.sparta.mini_projcet.dto.NoticeResponseDto;
import com.sparta.mini_projcet.exception.ApiResponseMessage;
import com.sparta.mini_projcet.model.Notice;
import com.sparta.mini_projcet.repository.MemberRepository;
import com.sparta.mini_projcet.repository.NoticeRepository;
import com.sparta.mini_projcet.security.UserDetailsImpl;
import com.sparta.mini_projcet.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;

    private final NoticeRepository noticeRepository;
    private final MemberRepository memberRepository;

    // 게시글 작성
    @PostMapping("/api/notice/write")
    public ResponseEntity<ApiResponseMessage> noticeWrite(@RequestBody @Valid NoticeCreateDto noticeCreateDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        noticeService.noticeWrite(noticeCreateDto, userDetails.getUsername());
        ApiResponseMessage message = new ApiResponseMessage("Success", "게시글이 작성 되었습니다.", "", "");
        return new ResponseEntity<ApiResponseMessage>(message, HttpStatus.OK);

    }
    // 게시글 조회
    @GetMapping("/api/notice")
    public List<NoticeResponseDto> getContents() {
        return noticeService.getNotice();
    }

    // 게시글 디테일 조회
    @GetMapping("/main/{id}")
    public Notice getContents(@PathVariable Long id) {
        Notice contents =  noticeRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("id가 존재하지 않습니다."));
        return contents;
    }
}
