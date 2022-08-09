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
@EntityScan(basePackages = { "com.gongzone.production.entity", "com.gongzone.client.entity",
		"com.gongzone.employee.entity", "com.gongzone.order.entity", "com.gongzone.bom.entity",
		"com.gongzone.storage.entity", "com.gongzone.stock.entity","com.gongzone.release.entity" })

@EnableJpaRepositories(basePackages = { "com.gongzone.production.repository", "com.gongzone.employee.repository",
		"com.gongzone.storage.repository", "com.gongzone.stock.repository", "com.gongzone.order.repository",
		"com.gongzone.bom.repository","com.gongzone.client.repository","com.gongzone.release.repository" })

@ComponentScan(basePackages = { "com.gongzone.production.apiController", "com.gongzone.employee.apiController",
		"com.gongzone.client.apiController","com.gongzone.release.apiController",
		"com.gongzone.order.controller", "com.gongzone.bom.controller", "com.gongzone.storage.controller",
		"com.gongzone.stock.controller", "com.gongzone.s3.controller", "com.gongzone.employee.dto","com.gongzone.release.dto",
		"com.gongzone.production.dto", "com.gongzone.order.dto", "com.gongzone.bom.dto", "com.gongzone.storage.dto","com.gongzone.client.dto",
		"com.gongzone.stock.dto", "com.gongzone.employee.service", "com.gongzone.production.service",
		"com.gongzone.order.service", "com.gongzone.bom.service", "com.gongzone.storage.service","com.gongzone.client.service","com.gongzone.release.service",
		"com.gongzone.stock.service", "com.gongzone.s3.service", "com.gongzone.employee.mapper","com.gongzone.client.mapper","com.gongzone.release.mapper",
		"com.gongzone.order.mapper", "com.gongzone.bom.mapper", "com.gongzone.storage.mapper",
		"com.gongzone.stock.mapper", "com.gongzone.s3.config" })

public class GongzoneBackendApplication {

//    @Bean
//    public RestTemplate restTemplate(RestTemplateBuilder builder) {
//        return builder.build();
//    }

	public static void main(String[] args) {
		SpringApplication.run(GongzoneBackendApplication.class, args);
	}

}












