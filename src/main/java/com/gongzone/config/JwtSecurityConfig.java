package com.gongzone.config;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.gongzone.security.jwt.JwtFilter;
import com.gongzone.security.jwt.TokenProvider;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JwtSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

	private final TokenProvider tokenProvider;
	
	@Override
	public void configure(HttpSecurity http) {
		JwtFilter customerFilter = new JwtFilter(tokenProvider);
		http.addFilterBefore(customerFilter, UsernamePasswordAuthenticationFilter.class);
	}
}
