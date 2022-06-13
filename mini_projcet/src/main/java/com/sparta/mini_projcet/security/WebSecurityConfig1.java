//package com.sparta.mini_projcet.security;
//import com.sparta.mini_projcet.repository.MemberRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@RequiredArgsConstructor
//@Configuration
//@EnableWebSecurity // 스프링 Security 지원을 가능하게 함
//public class WebSecurityConfig1 extends WebSecurityConfigurerAdapter {
//
//    private final MemberRepository memberRepository;
//    @Bean
//    public BCryptPasswordEncoder encodePassword() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    public void configure(WebSecurity web) {
//// h2-console 사용에 대한 허용 (CSRF, FrameOptions 무시)
//        web
//                .ignoring()
//                .antMatchers("/h2-console/**");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//// 회원 관리 처리 API (POST /user/**) 에 대해 CSRF 무시
//        http.csrf()
////                .ignoringAntMatchers("/register");
////                .ignoringAntMatchers("/");
//                .ignoringAntMatchers("/user/**")
//                .ignoringAntMatchers("/main/**");
////        // UsernamePasswordAuthenticationFilter 단계에서 json로그인과 jwt토큰을 만들어 response 반환
////                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class) // AuthenticationManager
////
////                // BasicAuthenticationFilter 단계에서 jwt토큰 검증
////                .addFilter(new JwtAuthorizationFilter(authenticationManager(), memberRepository))
//
//
//        http.authorizeRequests()
//// image 폴더를 login 없이 허용
//                .antMatchers("/images/**").permitAll()
//// css 폴더를 login 없이 허용
//                .antMatchers("/css/**").permitAll()
//// 회원 관리 처리 API 전부를 login 없이 허용
//                .antMatchers("/user/register").permitAll()
//                .antMatchers("/main/write").permitAll()
//                .antMatchers("/").permitAll()
//// 그 외 어떤 요청이든 '인증'
//                .antMatchers("/h2-console/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
////                // 시큐리티 폼로그인기능 비활성화
////                .formLogin().disable()
////                // 로그인폼 화면으로 리다이렉트 비활성화
////                .httpBasic().disable()
//// [로그인 기능]
//                .formLogin()
//// 로그인 View 제공 (GET /user/login)
//                //.loginPage("/user/login")
//
//// 로그인 처리 (POST /user/login)
//                .loginProcessingUrl("/user/login")
//// 로그인 처리 후 성공 시 URL
//                .defaultSuccessUrl("/")
//
//// 로그인 처리 후 실패 시 URL
////                .failureUrl("/user/login?error")
//                .permitAll()
//                .and()
//
//// [로그아웃 기능]
//                .logout()
//// 로그아웃 처리 URL
//                .logoutUrl("/user/logout")
//                .permitAll();
//    }
//}
