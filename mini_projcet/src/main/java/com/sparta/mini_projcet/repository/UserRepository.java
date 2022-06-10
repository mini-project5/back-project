package com.sparta.mini_projcet.repository;
import com.sparta.mini_projcet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
//    Optional<User> findByUsername(String username);

//    Optional<User> findByUserid(String user_id);
}