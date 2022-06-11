package com.sparta.mini_projcet.model;

import com.sparta.mini_projcet.dto.SignupRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class Member {

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;


    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String passwordCk;

//    @Column(nullable = false)
//    @Enumerated(value = EnumType.STRING)
//    private UserRoleEnum role;

    public Member(String nickname, String username, String password, String passwordCk ) {
        this.nickname = nickname;
        this.username = username;
        this.password = password;
        this.passwordCk = passwordCk;
    }

    public Member(SignupRequestDto requestDto) {
        this.password = requestDto.getPassword();
        this.nickname = requestDto.getNickname();
        this.username = requestDto.getUsername();
        this.passwordCk = requestDto.getPasswordCk();
    }
}
