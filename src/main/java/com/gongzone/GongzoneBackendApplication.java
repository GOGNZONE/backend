package com.gongzone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@EnableJpaAuditing
@EnableAspectJAutoProxy
@EnableScheduling
@SpringBootApplication
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
