package com.sparta.mini_projcet.service;
import com.sparta.mini_projcet.dto.SignupRequestDto;
import com.sparta.mini_projcet.model.User;
import com.sparta.mini_projcet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
//    private static final String ADMIN_TOKEN = "AAABnv/xRVklrnYxKZ0aHgTBcXukeZygoC";

//    @Autowired
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    public User registerUser(@RequestBody SignupRequestDto requestDto) {
        String user_id = requestDto.getUser_id();
        String username = requestDto.getUsername();
        String password = requestDto.getPassword();
        String passwordCk = requestDto.getPasswordCk();

        System.out.println("user_id = " + user_id);
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        System.out.println("passwordCk = " + passwordCk);

        // 회원 ID 중복 확인
//        Optional<User> found = userRepository.findByUser_id(user_id);
//        if (found.isPresent()) {
//            throw new IllegalArgumentException("중복된 사용자 ID 가 존재합니다.");
//        }
//        Optional<User> foundname = userRepository.findByUsername(username);
//        if (foundname.isPresent()) {
//            throw new IllegalArgumentException("중복된 사용자 닉네임이 존재합니다.");
//        }
//        if(!password.equals(passwordCk)){
//            throw new IllegalArgumentException("비밀번호를 확인해주세요");
//        }
//        if(password.length() < 6){
//            throw new IllegalArgumentException("비밀번호는 6자 이상으로 입력해주세요");
//        }



//        String email = requestDto.getEmail();
// 사용자 ROLE 확인
//        UserRoleEnum role = UserRoleEnum.USER;
//        if (requestDto.isAdmin()) {
//            if (!requestDto.getAdminToken().equals(ADMIN_TOKEN)) {
//                throw new IllegalArgumentException("관리자 암호가 틀려 등록이 불가능합니다.");
//            }
//            role = UserRoleEnum.ADMIN;
//        }
//        User user = new User(username, password, email, role);
        User user = new User(user_id, username, password, passwordCk);
        System.out.println("user = " + user);
        return userRepository.save(user);

    }
}