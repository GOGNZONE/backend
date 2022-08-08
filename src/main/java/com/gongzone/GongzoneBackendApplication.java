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
// entity
@EntityScan(basePackages = { 
		"com.gongzone.production.entity", 
		"com.gongzone.client.entity",
		"com.gongzone.employee.entity",
		"com.gongzone.release.entity",
		"com.gongzone.delivery.entity"})

// Repository
@EnableJpaRepositories(basePackages = { 
		"com.gongzone.production.repository",
		"com.gongzone.employee.repository",
		"com.gongzone.release.repository",
		"com.gongzone.client.repository"})

@ComponentScan(basePackages = { 
		"com.gongzone.common.errors",
    
    // RestController
		"com.gongzone.employee.apiController",
		"com.gongzone.production.apiController",
		"com.gongzone.client.apiController",
    "com.gongzone.release.apiController",
    
    // serivce
		"com.gongzone.employee.service",
		"com.gongzone.production.service",
		"com.gongzone.client.service",
		"com.gongzone.release.service",
		"com.gongzone.production.service", 
    
    // DTO
		"com.gongzone.employee.dto",
		"com.gongzone.production.dto" ,
		"com.gongzone.client.dto",
		"com.gongzone.release.dto",
		})
public class GongzoneBackendApplication {

//    @Bean
//    public RestTemplate restTemplate(RestTemplateBuilder builder) {
//        return builder.build();
//    }

	public static void main(String[] args) {
		SpringApplication.run(GongzoneBackendApplication.class, args);
	}

}
