package com.gongzone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.gongzone.employee.controller", "com.gongzone.employee.service", "com.gongzone.employee.dto"})
@EnableJpaRepositories(basePackages = {"com.gongzone.employee.repository"})
@EntityScan(basePackages = {"com.gongzone.employee.entity"})
public class GongzoneBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(GongzoneBackendApplication.class, args);
	}

}
