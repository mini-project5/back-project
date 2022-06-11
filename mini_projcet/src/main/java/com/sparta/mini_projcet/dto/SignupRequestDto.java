package com.sparta.mini_projcet.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupRequestDto {
    private String userid;
    private String username;
    private String password;
    private String passwordCk;
//    private boolean admin = false;
//    private String adminToken = "";
}