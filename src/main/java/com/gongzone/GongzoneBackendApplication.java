package com.gongzone;

import org.springframework.boot.SpringApplication;
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
@SpringBootApplication
@EntityScan(basePackages = { 
		"com.gongzone.production.entity", 
		"com.gongzone.client.entity",
		"com.gongzone.employee.entity",
		"com.gongzone.release.entity",
		"com.gongzone.delivery.entity"})

@EnableJpaRepositories(basePackages = { 
		"com.gongzone.production.repository", 
		"com.gongzone.employee.repository",
		"com.gongzone.release.repository",
		"com.gongzone.delivery.repository"})

@ComponentScan(basePackages = { 
		"com.gongzone.employee.apiController", 
		"com.gongzone.employee.dto", 
		"com.gongzone.employee.service",
		"com.gongzone.employee.mapper",
		
		"com.gongzone.client.dto",
		
		"com.gongzone.production.apiController",
		"com.gongzone.production.dto",
		"com.gongzone.production.service", 
		
		"com.gongzone.release.apiController",
		"com.gongzone.release.dto",
		"com.gongzone.release.service",
		
		"com.gongzone.delivery.dto"})
public class GongzoneBackendApplication {

//    @Bean
//    public RestTemplate restTemplate(RestTemplateBuilder builder) {
//        return builder.build();
//    }

	public static void main(String[] args) {
		SpringApplication.run(GongzoneBackendApplication.class, args);
	}

}
