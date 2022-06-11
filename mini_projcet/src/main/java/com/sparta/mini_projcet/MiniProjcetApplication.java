package com.sparta.mini_projcet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@SpringBootApplication
public class MiniProjcetApplication {
	public static void main(String[] args) {
		SpringApplication.run(MiniProjcetApplication.class, args);
	}

}
