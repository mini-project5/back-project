package com.sparta.mini_projcet.security;

import com.sparta.mini_projcet.model.Member;
import com.sparta.mini_projcet.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Autowired
    public UserDetailsServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //UserDetailsService가 가지고 있는 함수중 loadUserByUsername 를 사용
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = (Member) memberRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Can't find " + username));

        return new UserDetailsImpl(member);
    }
}
