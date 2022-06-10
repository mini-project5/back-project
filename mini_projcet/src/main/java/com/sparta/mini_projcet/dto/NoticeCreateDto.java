package com.sparta.mini_projcet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
@AllArgsConstructor
public class NoticeCreateDto {
    @NotNull(message = "제목을 입력해 주세요.")
    private String title;
    @NotNull(message = "내용을 입력해 주세요.")
    private String description;
}
