package com.gongzone.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvnConfig implements WebMvcConfigurer{
	
	private final long MAX_AGE_SECS = 3600;
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowCredentials(true)
			.allowedHeaders("*")
			.allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE")
			.allowedOrigins("https://localhost:3000")
			.maxAge(MAX_AGE_SECS);
	}
}
