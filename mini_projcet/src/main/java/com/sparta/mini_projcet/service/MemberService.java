package com.sparta.mini_projcet.service;

import com.sparta.mini_projcet.dto.LoginRequestDto;
import com.sparta.mini_projcet.dto.SignupRequestDto;
import com.sparta.mini_projcet.model.Member;
import com.sparta.mini_projcet.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;
import java.util.regex.Pattern;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
//    private final BCryptPasswordEncoder encoder;


//    private static final String ADMIN_TOKEN = "AAABnv/xRVklrnYxKZ0aHgTBcXukeZygoC";
//
//    @Autowired
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    public Boolean login(LoginRequestDto loginRequestDto){
        Member member = memberRepository.findByUsername(loginRequestDto.getUsername())
                .orElse(null);
        if (member != null) {
            if (!passwordEncoder.matches(loginRequestDto.getPassword(), member.getPassword())) {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }


    public void registerUser(@RequestBody SignupRequestDto requestDto) {
        String nickname = requestDto.getNickname();
        String username = requestDto.getUsername();
        String password = requestDto.getPassword();
        String passwordCk = requestDto.getPasswordCk();
//        String pattern = "^[a-zA-Z0-9]*$";
        System.out.println("passwordCk = " + passwordCk);
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        System.out.println("nickname = " + nickname);
// 회원 ID 중복 확인
        Optional<Member> found = memberRepository.findByUsername(username);
        if (found.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자 닉네임이 존재합니다.");
        }
//        if(!Pattern.matches(pattern, password)){
//            throw new IllegalArgumentException("패스워드는 알파벳 대소문자와 숫자로만 입력해주세요.");
//        }
        Optional<Member> foundid = memberRepository.findByNickname(nickname);
        if (foundid.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자 ID 가 존재합니다.");
        }
        if (password.length() > 6){ // !!!!정우님꺼!!!!
            throw new IllegalArgumentException("비밀번호는 6자 이상 입력해주세요");
        }
        if(!password.equals(passwordCk)){
            throw new IllegalArgumentException("비밀번호와 비밀번호 확인이 같지않습니다 확인해주세요");
        }

        //패스워드 암호화
        password = passwordEncoder.encode(requestDto.getPassword());
        passwordCk = passwordEncoder.encode(requestDto.getPasswordCk());

//        if(!encoder.matches(password, passwordCk)) {
//            throw new IllegalArgumentException("비밀번호와 비밀번호 확인이 같지않습니다 확인해주세요");
//        }


//        String email = requestDto.getEmail();
//// 사용자 ROLE 확인
//        UserRoleEnum role = UserRoleEnum.USER;
//        if (requestDto.isAdmin()) {
//            if (!requestDto.getAdminToken().equals(ADMIN_TOKEN)) {
//                throw new IllegalArgumentException("관리자 암호가 틀려 등록이 불가능합니다.");
//            }
//            role = UserRoleEnum.ADMIN;
//        }

        Member member = new Member(nickname , username ,password ,passwordCk);
        System.out.println("user = " + member);
        memberRepository.save(member);

    }
}