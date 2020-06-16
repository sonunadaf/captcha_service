package com.proj.captcha.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({ "com.proj.captcha.controller", "com.proj.captcha.service", "com.proj.captcha.repository",
		"com.proj.captcha.exception" })
@EntityScan({ "com.proj.captcha.domain" })
@EnableJpaRepositories({ "com.proj.captcha.repository" })
@SpringBootApplication
public class CaptchaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaptchaServiceApplication.class, args);
	}

}
