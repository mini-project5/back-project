package com.sparta.mini_projcet.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class NoticeRequestDto {
    private String title;
    private String nickname;
    private String username;
    private String description;
}