package com.gongzone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.gongzone.production.controller", "com.gongzone.production.service", "com.gongzone.production.dto" })
@EntityScan(basePackages = { "com.gongzone.production.entity", "com.gongzone.client.entity" })
@EnableJpaRepositories(basePackages = { "com.gongzone.production.repository" })
public class GongzoneBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(GongzoneBackendApplication.class, args);
	}

}
