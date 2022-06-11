package com.sparta.mini_projcet.repository;
import com.sparta.mini_projcet.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
//    <T> Optional<T> findByUsername(String username);
    Optional<Member> findByUsername(String username);
    Optional<Member> findByNickname(String nickname);
}