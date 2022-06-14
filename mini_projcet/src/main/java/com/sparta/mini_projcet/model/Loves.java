package com.sparta.mini_projcet.model;

import com.sparta.mini_projcet.dto.LoveDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Entity
@Setter
@NoArgsConstructor
public class Loves {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "Heart_A")
    @Column(name = "HEART_ID")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "NOTICE_ID")
    private Notice notice;

    public Loves(LoveDto loveDto) {
        this.member = loveDto.getMember();
        this.notice = loveDto.getNotice();
    }


}
