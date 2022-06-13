package com.sparta.mini_projcet.service;

import com.sparta.mini_projcet.dto.NoticeCreateDto;
import com.sparta.mini_projcet.dto.NoticeResponseDto;
import com.sparta.mini_projcet.model.Notice;
import com.sparta.mini_projcet.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeRepository noticeRepository;

    // 게시글 작성
    @Transactional
    public void noticeWrite(NoticeCreateDto noticeCreateDto, String username){
        Notice notice = Notice.createNotice(noticeCreateDto, username);
        noticeRepository.save(notice);
    }

    // 게시글 조회
    public List<Notice> getNotice() {
        List<Notice> contents = noticeRepository.findAllByOrderByCreatedAtDesc();
        return contents;
    }

    // 게시글 삭제
    public void deleteContent(Long ContentId, String userName) {
        String writer = noticeRepository.findById(ContentId).orElseThrow(
                () -> new IllegalArgumentException("게시글이 존재하지 않습니다.")).getNickname();
        if (Objects.equals(writer, userName)) {
            noticeRepository.deleteById(ContentId);
        }else new IllegalArgumentException("작성한 유저가 아닙니다.");
    }
}

