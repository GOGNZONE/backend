//package com.gongzone.common.config;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//
//	private ApiInfo apiInfo() {
//		return new ApiInfoBuilder()
//				.title("GONGZONE")
//				.description("GONGZONE API")
//				.version("1.0.0")
//				.build();
//	}
//	
//	private Set<String> getConsumeContentTypes() {
//		Set<String> consumes = new HashSet<>();
//		consumes.add("application/json;charset=UTF-8");
//		consumes.add("applicationi/x-www-form-urlencoded");
//		return consumes;
//	}
//	
//	private Set<String> getProduceContentTypes() {
//		Set<String> produces = new HashSet<>();
//		produces.add("application/json;charset=UTF-8");
//		return produces;
//	}
//	
//	@Bean
//	public Docket commonApi() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.consumes(getConsumeContentTypes())
//				.produces(getProduceContentTypes())
//				.apiInfo(apiInfo())
//				.select()
//				.apis(RequestHandlerSelectors.basePackage(
//						"com.gongzone.employee.apiController"))
//				.paths(PathSelectors.ant("/api/**"))
//				.build();
//	}
//
//}
