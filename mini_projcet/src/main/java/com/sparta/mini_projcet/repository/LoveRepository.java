package com.sparta.mini_projcet.repository;

import com.sparta.mini_projcet.model.Loves;
import com.sparta.mini_projcet.model.Member;
import com.sparta.mini_projcet.model.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoveRepository extends JpaRepository <Loves, Long> {
    Optional<Loves> findByNoticeAndMember(Notice notice, Member member);
}
