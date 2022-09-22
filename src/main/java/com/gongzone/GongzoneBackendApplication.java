package com.gongzone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableJpaAuditing
@EnableAspectJAutoProxy
@EnableScheduling
@EnableAutoConfiguration
@SpringBootApplication
@EntityScan(basePackages = { "com.gongzone.entity"})
@EnableJpaRepositories(basePackages = { "com.gongzone.repository" })
@ComponentScan(basePackages = { "com.gongzone.apiController",
		 "com.gongzone.s3.controller", "com.gongzone.service", "com.gongzone.service.implement", "com.gongzone.s3.service", 
		"com.gongzone.s3.config", "com.gongzone.config", "com.gongzone.security.jwt" })
@SpringBootConfiguration
public class GongzoneBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(GongzoneBackendApplication.class, args);
	}

}












