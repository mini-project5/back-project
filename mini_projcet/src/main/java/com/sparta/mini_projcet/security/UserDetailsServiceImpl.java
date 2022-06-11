//package com.sparta.mini_projcet.security;
//
//import com.sparta.mini_projcet.model.User;
//import com.sparta.mini_projcet.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    private final UserRepository userRepository;
//
//    @Autowired
//    public UserDetailsServiceImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = (User) userRepository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("Can't find " + username));
//
//        return new UserDetailsImpl(user);
//    }
//}
