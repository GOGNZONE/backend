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
		 "com.gongzone.s3.controller", "com.gongzone.employee.dto","com.gongzone.release.dto",
		"com.gongzone.production.dto", "com.gongzone.order.dto", "com.gongzone.bom.dto", "com.gongzone.storage.dto","com.gongzone.client.dto", "com.gongzone.stock.dto", 
		"com.gongzone.service", "com.gongzone.service.implement", "com.gongzone.s3.service", 
		"com.gongzone.employee.mapper","com.gongzone.client.mapper","com.gongzone.release.mapper",
		"com.gongzone.order.mapper", "com.gongzone.bom.mapper", "com.gongzone.storage.mapper",
		"com.gongzone.stock.mapper", 
		"com.gongzone.s3.config", "com.gongzone.config", "com.gongzone.security.jwt" })
@SpringBootConfiguration
public class GongzoneBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(GongzoneBackendApplication.class, args);
	}

}












