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
@ComponentScan(basePackages = { "com.gongzone.production.apiController", "com.gongzone.production.service", "com.gongzone.production.dto" })
@EntityScan(basePackages = { "com.gongzone.production.entity", "com.gongzone.client.entity", "com.gongzone.employee.entity" })
@EnableJpaRepositories(basePackages = { "com.gongzone.production.repository" })
@ComponentScan(basePackages = {"com.gongzone.employee.apiController",
		"com.gongzone.employee.service",
		"com.gongzone.employee.dto",
		"com.gongzone.employee.mapper"})
@EnableJpaRepositories(basePackages = {"com.gongzone.employee.repository"})
@EntityScan(basePackages = {"com.gongzone.employee.entity"})
public class GongzoneBackendApplication {
	
//    @Bean
//    public RestTemplate restTemplate(RestTemplateBuilder builder) {
//        return builder.build();
//    }

	public static void main(String[] args) {
		SpringApplication.run(GongzoneBackendApplication.class, args);
	}

}
