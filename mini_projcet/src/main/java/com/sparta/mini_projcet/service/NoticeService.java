package com.sparta.mini_projcet.service;

import com.sparta.mini_projcet.dto.NoticeCreateDto;
import com.sparta.mini_projcet.model.Notice;
import com.sparta.mini_projcet.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeRepository noticeRepository;

    @Transactional
    public void noticeWrite(NoticeCreateDto noticeCreateDto){
        Notice notice = Notice.createNotice(noticeCreateDto);
        noticeRepository.save(notice);
    }
}
