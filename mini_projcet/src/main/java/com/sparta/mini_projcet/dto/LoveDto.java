package com.sparta.mini_projcet.dto;

import com.sparta.mini_projcet.model.Member;
import com.sparta.mini_projcet.model.Notice;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoveDto {
    private Notice notice;
    private Member member;
}
