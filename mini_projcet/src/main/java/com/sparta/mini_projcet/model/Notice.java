package com.sparta.mini_projcet.model;

import com.sparta.mini_projcet.dto.NoticeCreateDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "notice")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Notice extends Timestamped{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notice_id")
    private Long id;

    private String title;
    private String description;
    private String username;
    private String nickname;

    @Column
    private int loveCnt;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;



    public static Notice createNotice(NoticeCreateDto noticeCreateDto, String username){
        Notice notice = new Notice();

        notice.setTitle(noticeCreateDto.getTitle());
        notice.setDescription(noticeCreateDto.getDescription());
        notice.setUsername(username);
        return notice;
    }

}
