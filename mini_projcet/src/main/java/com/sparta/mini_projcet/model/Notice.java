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
public class Notice {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notice_id")
    private Long id;

    private String title;
    private String description;
    //private String username;


    public static Notice createNotice(NoticeCreateDto noticeCreateDto){
        Notice notice = new Notice();

        notice.setTitle(noticeCreateDto.getTitle());
        notice.setDescription(noticeCreateDto.getDescription());
        /*notice.setUsername(noticeCreateDto.getUsername());*/
        return notice;
    }

}
