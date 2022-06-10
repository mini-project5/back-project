package com.sparta.mini_projcet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NoticeCreateDto {
    private String title;
    private String description;
    private String username;
}
