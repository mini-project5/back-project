package com.sparta.mini_projcet.repository;
import com.sparta.mini_projcet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    <T> Optional<T> findByUsername(String username);
//    Optional<User> findByUsername(String username);
//
//    Optional<User> findByUser_id(String user_id);
}