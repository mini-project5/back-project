package com.sparta.mini_projcet.repository;

import com.sparta.mini_projcet.model.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class NoticeRepository {
    private final EntityManager em;

    public void save(Notice notice){
        em.persist(notice);
    }
}
