package com.sparta.mini_projcet.service;

import com.sparta.mini_projcet.dto.NoticeCreateDto;
import com.sparta.mini_projcet.dto.NoticeResponseDto;
import com.sparta.mini_projcet.model.Notice;
import com.sparta.mini_projcet.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeRepository noticeRepository;

    // 게시글 작성
    @Transactional
    public NoticeResponseDto noticeWrite(NoticeCreateDto noticeCreateDto, String username){
        Notice notice = Notice.createNotice(noticeCreateDto, username);
        noticeRepository.save(notice);
        NoticeResponseDto noticeResponseDto = new NoticeResponseDto(notice);
        return noticeResponseDto;
    }

    // 게시글 조회
    public List<NoticeResponseDto> getNotice() {
        List<Notice> notice = noticeRepository.findAllByOrderByCreatedAtDesc(); //db에서 CreatedAt이라는 값을 기준으로 내림차순 해서 가져와라
        List<NoticeResponseDto> result = notice.stream() .map(n -> new NoticeResponseDto(n)) .collect(Collectors.toList());
        return result;
    }

    // 게시글 삭제
    @Transactional
    public void deleteContent(Long contentId, String userName) {
        Notice writer = noticeRepository.findById(contentId).orElseThrow(
                () -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
        if (Objects.equals(writer.getUsername(), userName)) {
            noticeRepository.delete(writer);
        }else{
            throw new IllegalArgumentException("작성한 유저가 아닙니다.");
        }
    }

    //게시글 수정
    @Transactional
    public NoticeResponseDto changeNotice(Long noticeId, NoticeCreateDto noticeCreateDto) {
        Notice notice = noticeRepository.findById(noticeId).orElseThrow(
                () -> new IllegalArgumentException("게시글이 존재하지 않습니다."));

        notice.setTitle(noticeCreateDto.getTitle());
        notice.setDescription(noticeCreateDto.getDescription());
        notice.setImage(noticeCreateDto.getImage());
        notice.setNoticeDate(noticeCreateDto.getDay());

        NoticeResponseDto noticeResponseDto = new NoticeResponseDto(notice);
        //noticeRepository.save(notice);
        return noticeResponseDto;
    }
}

