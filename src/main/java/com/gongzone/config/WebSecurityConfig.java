package com.gongzone.config;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.gongzone.security.JwtAuthenticationFilter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@EnableWebSecurity
@Slf4j
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private JwtAuthenticationFilter jwtAuthenticationFilter;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// http 시큐리티 빌더
		http.cors()
				.and()
				.csrf() // csrf는 현재 사용하지 않음으로 disable
				.disable()
				.httpBasic() // token을 사용하므로 basic 인증 disable
				.disable()
				.sessionManagement() // session 기반이 아님을 선언
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.authorizeRequests() // root(/) 와 /auth/** 경로는 인증 안해도 됨
				.antMatchers("/", "/signup", "/signin", "find-password").permitAll()
				.anyRequest()
				.authenticated();
		
		// filter 등로
		// 매 리퀘스트마다 CorsFilter 실행한 후에 jwtAuthenticationFilter 실행
		http.addFilterAfter(jwtAuthenticationFilter, CorsFilter.class);
	}
}
